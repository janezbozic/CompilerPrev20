package prev.phase.seman;

import prev.common.report.Report;
import prev.data.ast.tree.decl.AstParDecl;
import prev.data.ast.tree.decl.AstVarDecl;
import prev.data.ast.tree.expr.AstArrExpr;
import prev.data.ast.tree.expr.AstNameExpr;
import prev.data.ast.tree.expr.AstRecExpr;
import prev.data.ast.tree.expr.AstSfxExpr;
import prev.data.ast.tree.stmt.AstAssignStmt;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.semtype.SemPointer;
import prev.data.semtype.SemType;

import static prev.phase.seman.SemAn.*;

/**
 * Address resolver.
 * 
 * The address resolver finds out which expressions denote lvalues and leaves
 * the information in {@link SemAn#isAddr}.
 */
public class AddrResolver extends AstFullVisitor<Object, Object> {

    @Override
    public Boolean visit(AstNameExpr nameExpr, Object o){
        if (declaredAt.get(nameExpr) != null && (declaredAt.get(nameExpr) instanceof AstVarDecl || declaredAt.get(nameExpr) instanceof AstParDecl)){
            isAddr.put(nameExpr, true);
            return true;
        }

        return null;
    }

    @Override
    public Boolean visit(AstSfxExpr sfxExpr, Object o){
        SemType t = ofType.get(sfxExpr.expr());
        if (t != null && t.actualType() instanceof SemPointer){
            isAddr.put(sfxExpr, true);
            return true;
        }

        return null;
    }

    @Override
    public Boolean visit (AstArrExpr arrExpr, Object o){

        arrExpr.arr().accept(this, o);
        if (isAddr.get(arrExpr.arr()) != null){
            isAddr.put(arrExpr, true);
            return true;
        }
        return null;
    }

    @Override
    public Boolean visit(AstRecExpr recExpr, Object o){

        recExpr.rec().accept(this, o);
        if (isAddr.get(recExpr.rec()) != null){
            isAddr.put(recExpr, true);
            return true;
        }
        return null;
    }

    @Override
    public Boolean visit(AstAssignStmt assignStmt, Object object){

        assignStmt.dst().accept(this, object);
        if (isAddr.get(assignStmt.dst()) != null){
            return true;
        }
        else{
            throw new Report.Error(assignStmt, "LValue not valid.");
        }

    }

}
