package prev.phase.imcgen;

import prev.data.ast.tree.stmt.*;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.imc.code.expr.ImcExpr;
import prev.data.imc.code.stmt.*;
import prev.data.mem.MemFrame;
import prev.data.mem.MemLabel;

import java.util.Stack;
import java.util.Vector;

public class StmtGenerator extends AstFullVisitor<Object, Stack<MemFrame>> {

    @Override
    public Object visit(AstAssignStmt assignStmt, Stack<MemFrame> frames) {

        ImcExpr dstExpr = (ImcExpr) assignStmt.dst().accept(new ExprGenerator(), frames);
        ImcExpr srcExpr = (ImcExpr) assignStmt.src().accept(new ExprGenerator(), frames);

        return ImcGen.stmtImc.put(assignStmt, new ImcMOVE(dstExpr, srcExpr));
    }

    @Override
    public Object visit(AstCompoundStmt compoundStmt, Stack<MemFrame> frames) {

        if (compoundStmt.stmts() != null)
            compoundStmt.stmts().accept(this, frames);

        Vector<ImcStmt> stmts = new Vector<ImcStmt>();
        for (AstStmt stmt : compoundStmt.stmts())
            stmts.add(ImcGen.stmtImc.get(stmt));

        return ImcGen.stmtImc.put(compoundStmt, new ImcSTMTS(stmts));

    }

    @Override
    public Object visit(AstExprStmt exprStmt, Stack<MemFrame> frames) {

        ImcExpr expr = (ImcExpr) exprStmt.expr().accept(new ExprGenerator(), frames);

        return ImcGen.stmtImc.put(exprStmt, new ImcESTMT(expr));

    }

    @Override
    public Object visit(AstIfStmt ifStmt, Stack<MemFrame> frames) {

        ImcExpr cond = (ImcExpr) ifStmt.cond().accept(new ExprGenerator(), frames);
        ImcStmt stmtIf = (ImcStmt) ifStmt.thenStmt().accept(this, frames);
        ImcStmt stmtElse = (ImcStmt) ifStmt.elseStmt().accept(this, frames);

        ImcLABEL labelT = new ImcLABEL(new MemLabel());
        ImcLABEL labelF = new ImcLABEL(new MemLabel());
        ImcLABEL labelE = new ImcLABEL(new MemLabel());

        ImcCJUMP condJ = new ImcCJUMP(cond, labelT.label, labelF.label);
        ImcJUMP jumpE = new ImcJUMP(labelE.label);

        Vector<ImcStmt> imcStmts = new Vector<>();
        imcStmts.add(condJ);
        imcStmts.add(labelT);
        imcStmts.add(stmtIf);
        imcStmts.add(jumpE);
        imcStmts.add(labelF);
        imcStmts.add(stmtElse);
        imcStmts.add(labelE);

        return ImcGen.stmtImc.put(ifStmt, new ImcSTMTS(imcStmts));

    }

    @Override
    public Object visit(AstWhileStmt whileStmt, Stack<MemFrame> frames) {

        ImcExpr cond = (ImcExpr) whileStmt.cond().accept(new ExprGenerator(), frames);
        ImcStmt body = (ImcStmt) whileStmt.bodyStmt().accept(this, frames);

        ImcLABEL labelS = new ImcLABEL(new MemLabel());
        ImcLABEL labelT = new ImcLABEL(new MemLabel());
        ImcLABEL labelF = new ImcLABEL(new MemLabel());
        ImcCJUMP condJ = new ImcCJUMP(cond, labelT.label, labelF.label);
        ImcJUMP jumpS = new ImcJUMP(labelS.label);

        Vector<ImcStmt> whileStmtImc = new Vector<>();
        whileStmtImc.add(labelS);
        whileStmtImc.add(condJ);
        whileStmtImc.add(labelT);
        whileStmtImc.add(body);
        whileStmtImc.add(jumpS);
        whileStmtImc.add(labelF);

        return ImcGen.stmtImc.put(whileStmt, new ImcSTMTS(whileStmtImc));

    }

}
