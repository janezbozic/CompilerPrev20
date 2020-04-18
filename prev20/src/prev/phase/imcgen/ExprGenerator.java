package prev.phase.imcgen;

import prev.common.report.Report;
import prev.data.ast.tree.AstTrees;
import prev.data.ast.tree.decl.AstCompDecl;
import prev.data.ast.tree.decl.AstFunDecl;
import prev.data.ast.tree.decl.AstMemDecl;
import prev.data.ast.tree.expr.*;
import prev.data.ast.tree.stmt.AstStmt;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.imc.code.expr.*;
import prev.data.imc.code.stmt.ImcESTMT;
import prev.data.imc.code.stmt.ImcSTMTS;
import prev.data.imc.code.stmt.ImcStmt;
import prev.data.mem.*;
import prev.data.semtype.*;
import prev.phase.memory.Memory;
import prev.phase.seman.SemAn;

import java.util.Stack;
import java.util.Vector;

import static prev.phase.imcgen.ImcGen.exprImc;

public class ExprGenerator extends AstFullVisitor<Object, Stack<MemFrame>> {

    @Override
    public Object visit(AstArrExpr arrExpr, Stack<MemFrame> frames){

        ImcExpr arr = null;
        ImcExpr idx = null;

        if (arrExpr.arr() != null) {
            arr = (ImcExpr) arrExpr.arr().accept(this, frames);
        }
        if (arrExpr.idx() != null)
            idx = (ImcExpr) arrExpr.idx().accept(this, frames);

        if (arr instanceof ImcMEM)
            arr = ((ImcMEM)arr).addr;
        else
            throw new Report.Error(arrExpr.arr(), "Array is not of mem type." + arr);

        return exprImc.put(arrExpr, new ImcMEM(new ImcBINOP(ImcBINOP.Oper.ADD, arr, new ImcBINOP(ImcBINOP.Oper.MUL, idx, new ImcCONST(8)))));

    }

    @Override
    public Object visit(AstAtomExpr atomExpr, Stack<MemFrame> frames){
        ImcExpr imcExpr;

        switch (atomExpr.type()){
            case VOID:
                imcExpr = new ImcCONST(0);
                break;
            case CHAR:
                imcExpr = new ImcCONST((long) atomExpr.value().charAt(1));
                break;
            case INTEGER:
                imcExpr = new ImcCONST(Long.parseLong(atomExpr.value()));
                break;
            case POINTER:
                imcExpr = new ImcCONST(0);
                break;
            case STRING:
                MemAbsAccess absAccess = Memory.strings.get(atomExpr);
                imcExpr = new ImcNAME(absAccess.label);
                break;
            default:
                if (atomExpr.value().equals("true"))
                    imcExpr = new ImcCONST(1);
                else
                    imcExpr = new ImcCONST(0);
                break;
        }

        return exprImc.put(atomExpr, imcExpr);

    }

    @Override
    public Object visit(AstBinExpr binExpr, Stack<MemFrame> frames) {

        ImcExpr fst = null;
        ImcExpr snd = null;

        if (binExpr.fstExpr() != null)
            fst = (ImcExpr) binExpr.fstExpr().accept(this, frames);
        if (binExpr.sndExpr() != null)
            snd = (ImcExpr) binExpr.sndExpr().accept(this, frames);

        ImcBINOP.Oper op;
        switch (binExpr.oper()) {
            case OR:
                op = ImcBINOP.Oper.OR;
                break;
            case AND:
                op = ImcBINOP.Oper.AND;
                break;
            case EQU:
                op = ImcBINOP.Oper.EQU;
                break;
            case NEQ:
                op = ImcBINOP.Oper.NEQ;
                break;
            case LTH:
                op = ImcBINOP.Oper.LTH;
                break;
            case GTH:
                op = ImcBINOP.Oper.GTH;
                break;
            case LEQ:
                op = ImcBINOP.Oper.LEQ;
                break;
            case GEQ:
                op = ImcBINOP.Oper.GEQ;
                break;
            case ADD:
                op = ImcBINOP.Oper.ADD;
                break;
            case SUB:
                op = ImcBINOP.Oper.SUB;
                break;
            case MUL:
                op = ImcBINOP.Oper.MUL;
                break;
            case DIV:
                op = ImcBINOP.Oper.DIV;
                break;
            default:
                op = ImcBINOP.Oper.MOD;
                break;
        }

        return exprImc.put(binExpr, new ImcBINOP(op, fst, snd));
    }

    @Override
    public Object visit(AstCallExpr callExpr, Stack<MemFrame> frames) {

        if (callExpr.args() != null)
            callExpr.args().accept(this, frames);

        MemFrame calledFunFrame = Memory.frames.get((AstFunDecl)SemAn.declaredAt.get(callExpr));
        MemFrame curFrame = frames.peek();

        ImcExpr staticLink = new ImcTEMP(curFrame.FP);
        for(int i = curFrame.depth; i > calledFunFrame.depth - 1; i--){
            staticLink = new ImcMEM(staticLink);
        }

        Vector<ImcExpr> args = new Vector<>();
        Vector<Long> offs = new Vector<>();
        args.add(staticLink);
        offs.add(0L);
        for(AstExpr arg_: callExpr.args()){
            args.add((ImcExpr) arg_.accept(this, frames));
            offs.add(SemAn.ofType.get(arg_).size());
        }
        MemLabel lab = calledFunFrame.label;
        ImcCALL funCall = new ImcCALL(lab, offs, args);

        return exprImc.put(callExpr, funCall);

    }

    @Override
    public Object visit(AstCastExpr castExpr, Stack<MemFrame> frames) {

        ImcExpr imcExpr = null;
        ImcExpr imcType = null;
        if (castExpr.expr() != null)
            imcExpr= (ImcExpr) castExpr.expr().accept(this, frames);
        if (castExpr.type() != null)
            imcType= (ImcExpr) castExpr.type().accept(this, frames);

        if (SemAn.isType.get(castExpr.type()).actualType() instanceof SemChar){
            return exprImc.put(castExpr, new ImcBINOP(ImcBINOP.Oper.MOD, imcExpr, new ImcCONST(256)));
        }
        else {
            return exprImc.put(castExpr, imcExpr);
        }

    }

    @Override
    public Object visit(AstNameExpr nameExpr, Stack<MemFrame> frames) {

        AstMemDecl decl = (AstMemDecl) SemAn.declaredAt.get(nameExpr);

        if (decl == null)
            return null;

        MemAccess access = Memory.accesses.get(decl);

        ImcExpr val;
        if (access instanceof MemAbsAccess) {
            val = new ImcMEM(new ImcNAME( ((MemAbsAccess) access).label ));
        }
        else {
            MemRelAccess acc = (MemRelAccess) access;
            ImcExpr baseAddr = new ImcTEMP(frames.peek().FP);
            int declDepth = acc.depth;
            int currentDepth = frames.peek().depth;
            while (currentDepth > declDepth) {
                baseAddr = new ImcMEM(baseAddr);
                currentDepth--;
            }
            val = new ImcMEM(new ImcBINOP(ImcBINOP.Oper.ADD, baseAddr, new ImcCONST(acc.offset)));
        }

        return exprImc.put(nameExpr, val);

    }

    @Override
    public Object visit(AstPfxExpr pfxExpr, Stack<MemFrame> frames) {

        ImcExpr imcExpr = null;

        if (pfxExpr.expr() != null)
            imcExpr = (ImcExpr) pfxExpr.expr().accept(this, frames);

        switch (pfxExpr.oper()) {
            case ADD:
                break;
            case SUB:
                imcExpr = new ImcUNOP(ImcUNOP.Oper.NEG, imcExpr);
                break;
            case NOT:
                imcExpr = new ImcUNOP(ImcUNOP.Oper.NOT, imcExpr);
                break;
            case PTR:
                if (imcExpr instanceof ImcMEM) {
                    imcExpr = ((ImcMEM) imcExpr).addr;
                    break;
                }
                else
                    throw new Report.Error(pfxExpr, "Pointed expr not of type MEM.");
            case NEW:
                Vector<Long> offs1 = new Vector<>();
                offs1.add(new SemInteger().size());
                Vector<ImcExpr> args1 = new Vector<>();
                args1.add(imcExpr);
                imcExpr = new ImcCALL(new MemLabel("new"), offs1, args1);
                break;
            case DEL:
                Vector<Long> offs2 = new Vector<>();
                offs2.add(new SemPointer(new SemVoid()).size());
                Vector<ImcExpr> args2 = new Vector<>();
                args2.add(imcExpr);
                imcExpr = new ImcCALL(new MemLabel("del"), offs2, args2);
                break;
        }

        return exprImc.put(pfxExpr, imcExpr);

    }

    @Override
    public Object visit(AstRecExpr recExpr, Stack<MemFrame> frames) {

        ImcExpr name = (ImcExpr) recExpr.rec().accept(this, frames);

        if (recExpr.comp() != null)
            recExpr.comp().accept(this, frames);

        if (name instanceof ImcMEM)
            name = ((ImcMEM) name).addr;

        AstTrees<AstCompDecl> typP = SemAn.recStr.get((SemRecord) SemAn.ofType.get(recExpr.rec()));

        int off = 0;

        for (AstCompDecl decl: typP){
            if (decl.name().equals(recExpr.comp().name())){
                return exprImc.put(recExpr, new ImcMEM(new ImcBINOP(ImcBINOP.Oper.ADD, name, new ImcCONST(off))));
            }
            off += SemAn.isType.get(decl.type()).actualType().size();
        }

        return null;

    }

    @Override
    public Object visit(AstSfxExpr sfxExpr, Stack<MemFrame> frames) {

        ImcExpr subImc = (ImcExpr) sfxExpr.expr().accept(this, frames);

        return ImcGen.exprImc.put(sfxExpr, new ImcMEM(subImc));

    }

    @Override
    public Object visit(AstStmtExpr stmtExpr, Stack<MemFrame> frames) {
        if (stmtExpr.stmts() != null)
            stmtExpr.stmts().accept(new StmtGenerator(), frames);

        Vector<ImcStmt> stmts = new Vector<ImcStmt>();
        for (AstStmt stmt : stmtExpr.stmts())
            stmts.add(ImcGen.stmtImc.get(stmt));

        if (stmts.lastElement() instanceof ImcESTMT) {
            ImcESTMT t = (ImcESTMT) stmts.lastElement();
            stmts.remove(t);
            return ImcGen.exprImc.put(stmtExpr, new ImcSEXPR(new ImcSTMTS(stmts), t.expr));
        }

        return ImcGen.exprImc.put(stmtExpr, new ImcSEXPR(new ImcSTMTS(stmts), new ImcCONST(0) ));
    }

    @Override
    public Object visit(AstWhereExpr whereExpr, Stack<MemFrame> frames) {

        ImcExpr e = null;

        if (whereExpr.expr() != null)
            e = (ImcExpr) whereExpr.expr().accept(this, frames);

        if (whereExpr.decls() != null)
            whereExpr.decls().accept(new CodeGenerator(), frames);

        return ImcGen.exprImc.put(whereExpr, e);
    }

}
