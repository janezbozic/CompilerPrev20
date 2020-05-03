package prev.phase.asmgen;

import java.util.*;
import prev.data.imc.code.*;
import prev.data.imc.code.expr.*;
import prev.data.imc.code.stmt.*;
import prev.data.imc.visitor.*;
import prev.data.mem.*;
import prev.data.asm.*;
import prev.common.report.*;

/**
 * Machine code generator for ststements.
 */
public class StmtGenerator implements ImcVisitor<Vector<AsmInstr>, Object> {

    @Override
    public Vector<AsmInstr> visit(ImcCJUMP cjump, Object visArg) {

        Vector <AsmInstr> vector = new Vector<>();
        MemLabel label = cjump.posLabel;

        Vector<MemLabel> jumps = new Vector<>();
        jumps.add(label);

        Vector<MemTemp> uses = new Vector<>();
        uses.add(cjump.cond.accept(new ExprGenerator(new MemTemp()), vector));
        vector.add(new AsmOPER("BNZ `s0," + label.name, uses, null, jumps));

        return vector;

    }

    @Override
    public Vector<AsmInstr> visit(ImcESTMT eStmt, Object visArg) {

        Vector <AsmInstr> vector = new Vector<>();
        eStmt.expr.accept(new ExprGenerator(new MemTemp()), vector);

        return vector;

    }

    @Override
    public Vector<AsmInstr> visit(ImcJUMP jump, Object visArg) {

        Vector<AsmInstr> vector = new Vector<>();

        Vector<MemLabel> jumps = new Vector<>();
        jumps.add(jump.label);

        vector.add(new AsmOPER("JMP " + jump.label.name, null, null, jumps));

        return vector;

    }

    @Override
    public Vector<AsmInstr> visit(ImcLABEL label, Object visArg) {

        Vector<AsmInstr> vector = new Vector<>();

        vector.add(new AsmLABEL(label.label));

        return vector;

    }

    @Override
    public Vector<AsmInstr> visit(ImcMOVE move, Object visArg) {

        Vector<AsmInstr> vector = new Vector<>();
        Vector<MemTemp> defs = new Vector<>();
        Vector<MemTemp> uses = new Vector<>();

        ImcExpr lExpr = move.dst;

        if (lExpr instanceof ImcMEM){
            ImcMEM memExpr = (ImcMEM) move.dst;
            uses.add(move.src.accept(new ExprGenerator(new MemTemp()), vector));
            uses.add(memExpr.addr.accept(new ExprGenerator(new MemTemp()), vector));
            vector.add(new AsmOPER("STO `s0, `s1,0", uses, null, null));
        }
        else {
            if (move.src instanceof ImcTEMP && move.dst instanceof ImcTEMP){
                defs.add(move.dst.accept(new ExprGenerator(new MemTemp()), vector));
                uses.add(move.src.accept(new ExprGenerator(new MemTemp()), vector));
                vector.add(new AsmMOVE("SET `d0, `s0", uses, defs));
            }
            else {
                MemTemp temp = move.dst.accept(new ExprGenerator(new MemTemp()), vector);
                uses.add(move.src.accept(new ExprGenerator(temp), vector));
            }
        }

        return vector;

    }
}
