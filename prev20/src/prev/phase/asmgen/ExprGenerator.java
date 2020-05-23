package prev.phase.asmgen;

import java.util.*;

import prev.Compiler;
import prev.data.mem.*;
import prev.data.imc.code.expr.*;
import prev.data.imc.visitor.*;
import prev.data.asm.*;

/**
 * Machine code generator for expressions.
 */
public class ExprGenerator implements ImcVisitor<MemTemp, Vector<AsmInstr>> {

    MemTemp temp;

    public ExprGenerator (MemTemp t){
	    temp = t;
    }

    @Override
    public MemTemp visit(ImcBINOP binOp, Vector<AsmInstr> visArg) {

	    Vector<MemTemp> defs = new Vector<>();
	    Vector<MemTemp> uses = new Vector<>();

	    defs.add(temp);

	    uses.add(binOp.fstExpr.accept(this, visArg));
	    uses.add(binOp.sndExpr.accept(this, visArg));

	    String inst = "";

	    switch (binOp.oper){
            case ADD:
                inst = "ADD";
                break;
            case SUB:
                inst = "SUB";
                break;
            case MUL:
                inst = "MUL";
                break;
            case DIV:
                inst = "DIV";
                break;
            case AND:
                inst = "AND";
                break;
            case OR:
                inst = "OR";
                break;
            case MOD:
                visArg.add(new AsmOPER("DIV `d0,`s0,`s1", uses, defs, null));
                visArg.add(new AsmOPER("GET `d0,rR", null, defs, null));
                return temp;
            default:
                Vector<MemTemp> cmps = new Vector<>();
                cmps.add(new MemTemp());
                visArg.add(new AsmOPER("CMP `d0,`s0,`s1", uses, cmps, null));
                switch (binOp.oper) {
                    case EQU:
                        visArg.add(new AsmOPER("ZSZ `d0,`s0,1", cmps, defs, null));
                        break;
                    case NEQ:
                        visArg.add(new AsmOPER("ZSNZ `d0,`s0,1", cmps, defs, null));
                        break;
                    case LTH:
                        visArg.add(new AsmOPER("ZSN `d0,`s0,1", cmps, defs, null));
                        break;
                    case GEQ:
                        visArg.add(new AsmOPER("ZSNN `d0,`s0,1", cmps, defs, null));
                        break;
                    case GTH:
                        visArg.add(new AsmOPER("ZSP `d0,`s0,1", cmps, defs, null));
                        break;
                    case LEQ:
                        visArg.add(new AsmOPER("ZSNP `d0,`s0,1", cmps, defs, null));
                        break;

                    default:
                        System.out.println("[ExprGen]" + binOp.oper + " does not exist");
                }
                return temp;
        }

        visArg.add(new AsmOPER(inst + " `d0,`s0,`s1", uses, defs, null));

        return temp;

    }

    @Override
    public MemTemp visit(ImcCALL call, Vector<AsmInstr> visArg) {

        Vector<MemLabel> jumps = new Vector<>();
        jumps.add(call.label);

        int offset = call.args().size() * 8;

        for (int i = call.args().size()-1; i >= 0; i--){
            ImcExpr expr = call.args().get(i);
            offset -= 8;
            MemTemp temp = expr.accept(this, visArg);
            Vector<MemTemp> uses = new Vector<>();
            uses.add(temp);
            visArg.add(new AsmOPER("STO `s0,$254," + offset , uses, null, null));
        }

        visArg.add(new AsmOPER("PUSHJ $" + Integer.parseInt(Compiler.cmdLineArgValue("--num-regs")) + "," + call.label.name, null, null, jumps));

        Vector <MemTemp> defs = new Vector<>();
        defs.add(temp);
        visArg.add(new AsmOPER("LDO `d0,$254,0" , null, defs, null));

        return temp;

    }

    @Override
    public MemTemp visit(ImcCONST constant, Vector<AsmInstr> visArg) {

	    Vector<MemTemp> defs = new Vector<>();
	    defs.add(temp);

	    boolean neg = false;

	    long val = constant.value;
	    if (val < 0){
	        neg = true;
	        val = -val;
        }

	    long l = val & ((1 << 16) - 1);
	    val >>= 16;
        long ml = val & ((1 << 16) - 1);
        val >>= 16;
        long mh = val & ((1 << 16) - 1);
        val >>= 16;
        long h = val & ((1 << 16) - 1);

        visArg.add(new AsmOPER("SETL `d0," + l, null, defs, null));

        if(ml != 0)
            visArg.add(new AsmOPER("INCML `s0," + ml, defs, defs, null));
        if(mh != 0)
            visArg.add(new AsmOPER("INCMH `s0," + mh, defs, defs, null));
        if(h != 0)
            visArg.add(new AsmOPER("INCH `s0," + h, defs, defs, null));
        if(neg) {
            visArg.add(new AsmOPER("NEG  `d0,`s0", defs, defs, null));
        }

        return temp;

    }

    @Override
    public MemTemp visit(ImcMEM mem, Vector<AsmInstr> visArg) {

	    Vector<MemTemp> defs = new Vector<>();
	    Vector<MemTemp> uses = new Vector<>();

	    defs.add(temp);
	    uses.add(mem.addr.accept(this, visArg));

	    visArg.add(new AsmOPER("LDO `d0,`s0,0", uses, defs, null));

	    return temp;

    }

    @Override
    public MemTemp visit(ImcNAME name, Vector<AsmInstr> visArg) {

        Vector<MemTemp> defs = new Vector<>();
	    defs.add(temp);

        visArg.add(new AsmOPER("LDA `d0,"+ name.label.name, null, defs, null));

        return temp;

    }

    @Override
    public MemTemp visit(ImcTEMP temp, Vector<AsmInstr> visArg) {
        return temp.temp;
    }

    @Override
    public MemTemp visit(ImcUNOP unOp, Vector<AsmInstr> visArg) {

	    Vector<MemTemp> defs = new Vector<>();
	    Vector<MemTemp> uses = new Vector<>();

	    defs.add(temp);
	    uses.add(unOp.subExpr.accept(this, visArg));

	    switch (unOp.oper){
            case NEG:
                visArg.add(new AsmOPER("NEG `d0,`s0", uses, defs, null));
                break;
            case NOT:
                visArg.add(new AsmOPER("SUB `d0,`s0,1", uses, defs, null));
                visArg.add(new AsmOPER("NEG `d0,`s0", defs, defs, null));
        }

        return temp;

    }
}
