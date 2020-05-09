package prev.phase.seman;

import prev.common.report.Report;
import prev.data.ast.tree.AstTrees;
import prev.data.ast.tree.decl.AstCompDecl;
import prev.data.ast.tree.decl.AstFunDecl;
import prev.data.ast.tree.decl.AstMemDecl;
import prev.data.ast.tree.decl.AstParDecl;
import prev.data.ast.tree.expr.*;
import prev.data.ast.tree.stmt.AstAssignStmt;
import prev.data.ast.tree.stmt.AstExprStmt;
import prev.data.ast.tree.stmt.AstIfStmt;
import prev.data.ast.tree.stmt.AstWhileStmt;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.semtype.*;

import java.util.Iterator;

import static prev.phase.seman.SemAn.*;

public class TypeResolver5 extends AstFullVisitor<Object, TypeResolver2.Mode> {

    @Override
    public SemType visit(AstAtomExpr atomExpr, TypeResolver2.Mode mode){

        SemType t = null;

        switch (atomExpr.type()){
            case VOID:
                t = new SemVoid();
                break;
            case POINTER:
                t = new SemPointer(new SemVoid());
                break;
            case STRING:
                t = new SemPointer(new SemChar());
                break;
            case BOOLEAN:
                t = new SemBoolean();
                break;
            case CHAR:
                t = new SemChar();
                break;
            case INTEGER:
                t = new SemInteger();
                break;
        }

        ofType.put(atomExpr, t.actualType());

        return t.actualType();

    }

    @Override
    public SemType visit(AstPfxExpr pfxExpr, TypeResolver2.Mode mode){

        SemType t = (SemType) pfxExpr.expr().accept(this, mode);
        SemType retT = null;

        switch (pfxExpr.oper()){
            case NOT:
                if (t.actualType() instanceof SemBoolean){
                    retT = t;
                }
                else{
                    throw new Report.Error(pfxExpr, "Expression after ! must be of type boolean.");
                }
                break;
            case ADD:
                if (t.actualType() instanceof SemInteger){
                    retT = t;
                }
                else{
                    throw new Report.Error(pfxExpr, "Expression after + must be of type integer.");
                }
                break;
            case SUB:
                if (t.actualType() instanceof SemInteger){
                    retT = t;
                }
                else{
                    throw new Report.Error(pfxExpr, "Expression after - must be of type integer.");
                }
                break;
            case PTR:
                retT = new SemPointer(t);
                break;
            case NEW:
                if (t.actualType() instanceof SemInteger){
                    retT = new SemPointer(new SemVoid());
                }
                else {
                    throw new Report.Error(pfxExpr, "Expression after new must be of type integer.");
                }
                break;
            case DEL:
                if (t.actualType() instanceof SemPointer){
                    retT = new SemVoid();
                }
                else{
                    throw new Report.Error(pfxExpr, "Expression after del must be of type pointer.");
                }
                break;
        }

        ofType.put(pfxExpr, retT.actualType());

        return retT.actualType();

    }

    @Override
    public SemType visit(AstBinExpr binExpr, TypeResolver2.Mode mode){

        SemType expr1 = (SemType) binExpr.fstExpr().accept(this, mode);
        SemType expr2 = (SemType) binExpr.sndExpr().accept(this, mode);

        SemType t = null;

        switch (binExpr.oper()){
            case SUB:
            case DIV:
            case MUL:
            case MOD:
            case ADD:
                if (expr1.actualType() instanceof SemInteger && expr2.actualType() instanceof  SemInteger){
                    t = expr1;
                }
                else{
                    throw new Report.Error(binExpr, "Both Expressions must be of type integer.");
                }
                break;
            case AND:
            case OR:
                if (expr1.actualType() instanceof SemBoolean && expr2.actualType() instanceof  SemBoolean){
                    t = new SemBoolean();
                }
                else{
                    throw new Report.Error(binExpr, "Both Expressions must be of type boolean.");
                }
                break;
            case EQU:
            case NEQ:
                if (expr1.actualType().getClass().equals(expr2.actualType().getClass()) && (expr1.actualType() instanceof SemBoolean || expr1.actualType() instanceof SemChar || expr1.actualType() instanceof  SemInteger)){
                    t = new SemBoolean();
                }
                else if (expr1.actualType().getClass().equals(expr2.actualType().getClass()) && expr1.actualType() instanceof SemPointer && ((SemPointer)expr1).baseType().getClass().equals(((SemPointer)expr1).baseType().getClass())){
                    t = new SemBoolean();
                }
                else{
                    throw new Report.Error(binExpr, "Both Expressions must be of same type (char, boolean, integer or pointer).");
                }
                break;
            case GEQ:
            case GTH:
            case LEQ:
            case LTH:
                if (expr1.getClass().equals(expr2.getClass()) && (expr1.actualType() instanceof SemChar || expr1.actualType() instanceof SemInteger)){
                    t = new SemBoolean();
                }
                else if (expr1.getClass().equals(expr2.getClass()) && expr1.actualType() instanceof SemPointer && ((SemPointer)expr1).baseType().getClass().equals(((SemPointer)expr1).baseType().getClass())){
                    t = new SemBoolean();
                }
                else{
                    throw new Report.Error(binExpr, "Both Expressions must be of same type (char, integer or pointer).");
                }
                break;
        }

        ofType.put(binExpr, t.actualType());

        return t.actualType();

    }

    @Override
    public SemType visit(AstSfxExpr sfxExpr, TypeResolver2.Mode mode){

        SemPointer t = (SemPointer) sfxExpr.expr().accept(this, mode);

        switch (sfxExpr.oper()){
            case PTR:
                ofType.put(sfxExpr, t.baseType().actualType().actualType());
                return t.baseType().actualType().actualType();
        }

        return null;

    }

    @Override
    public SemType visit(AstArrExpr arrExpr, TypeResolver2.Mode mode){

        SemType tArr = (SemType) arrExpr.arr().accept(this, mode);
        SemType tNum = (SemType) arrExpr.idx().accept(this, mode);

        if (tArr.actualType() instanceof SemArray){
            if (tNum.actualType() instanceof SemInteger){
                ofType.put(arrExpr, ((SemArray)tArr).elemType().actualType());
                return ((SemArray)tArr).elemType().actualType();
            }
            else {
                throw new Report.Error(arrExpr, "Index must be of type integer.");
            }
        }
        else {
            throw new Report.Error(arrExpr, "Must be an array.");
        }

    }

    @Override
    public SemType visit(AstNameExpr nameExpr, TypeResolver2.Mode mode){

        SemType t = isType.get(((AstMemDecl)declaredAt.get(nameExpr)).type()).actualType();

        ofType.put(nameExpr, t.actualType());
        return t.actualType();

    }

    @Override
    public SemType visit(AstCallExpr callExpr, TypeResolver2.Mode mode){

        AstFunDecl f = (AstFunDecl) declaredAt.get(callExpr);
        Iterator i1 = f.pars().iterator();
        Iterator i2 = callExpr.args().iterator();
        while (i1.hasNext() && i2.hasNext()){
            SemType t1 = (SemType) ((AstExpr)i2.next()).accept(this, mode);
            SemType t2 = isType.get(((AstParDecl)i1.next()).type()).actualType();
            if (!(t1.actualType().getClass().equals(t2.actualType().getClass()))){
                throw new Report.Error(callExpr, "Function call arguments don't match parameters.");
            }
        }

        ofType.put(callExpr, ofType.get(f.expr()).actualType());

        return ofType.get(f.expr()).actualType();

    }

    @Override
    public SemType visit(AstStmtExpr stmtExpr, TypeResolver2.Mode mode){

        stmtExpr.stmts().accept(this, mode);
        SemType t = ofType.get(stmtExpr.stmts().get(stmtExpr.stmts().size()-1));

        ofType.put(stmtExpr, t.actualType());
        return t.actualType();

    }

    @Override
    public SemType visit(AstExprStmt exprStmt, TypeResolver2.Mode mode){
        SemType t = (SemType) exprStmt.expr().accept(this, mode);
        ofType.put(exprStmt, t.actualType());
        return t.actualType() ;
    }

    @Override
    public SemType visit(AstCastExpr castExpr, TypeResolver2.Mode mode){

        SemType t = (SemType) castExpr.expr().accept(this, mode);
        SemType retT = isType.get(castExpr.type());

        if (!(retT.actualType() instanceof SemChar || retT.actualType() instanceof SemInteger || retT.actualType() instanceof SemPointer ||
                t.actualType() instanceof SemPointer || t.actualType() instanceof SemInteger || t.actualType() instanceof SemChar)){
            throw new Report.Error(castExpr, "Cast parameters must be type int/char/ptr.");
        }

        ofType.put(castExpr, retT.actualType());

        return retT.actualType();

    }

    @Override
    public SemType visit(AstAssignStmt assignStmt, TypeResolver2.Mode mode){

        SemType t1 = (SemType) assignStmt.src().accept(this, mode);
        SemType t2 = (SemType) assignStmt.dst().accept(this, mode);

        if (!(t1.actualType().getClass().equals(t2.actualType().getClass()) && (t1.actualType() instanceof SemBoolean || t1.actualType() instanceof SemChar || t1.actualType() instanceof SemInteger || t1.actualType() instanceof SemPointer))){
            throw new Report.Error(assignStmt, "Types of expressions don't match.");
        }

        if (t1.actualType() instanceof SemPointer){
            while (((SemPointer)t1).baseType().actualType() instanceof SemPointer && ((SemPointer)t2).baseType().actualType() instanceof SemPointer){
                t1 = ((SemPointer) t1).baseType().actualType();
                t2 = ((SemPointer) t2).baseType().actualType();
            }
            if (!t1.actualType().getClass().equals(t2.actualType().getClass()))
                throw new Report.Error(assignStmt, "Types of expressions don't match.");
        }

        SemType ret = new SemVoid();

        ofType.put(assignStmt, ret.actualType());

        return ret.actualType();

    }

    @Override
    public SemType visit(AstIfStmt ifStmt, TypeResolver2.Mode mode){

        SemType t = (SemType) ifStmt.cond().accept(this, mode);

        if (!(t.actualType() instanceof SemBoolean)){
            throw new Report.Error(ifStmt, "Condition must be type boolean.");
        }

        SemType t1 = (SemType) ifStmt.thenStmt().accept(this, mode);
        SemType t2 = (SemType) ifStmt.elseStmt().accept(this, mode);
        SemType t3 = new SemVoid();

        ofType.put(ifStmt, t3.actualType());

        return t3.actualType();

    }

    @Override
    public SemType visit(AstWhileStmt whileStmt, TypeResolver2.Mode mode){

        SemType t1 = (SemType) whileStmt.cond().accept(this, mode);
        SemType t2 = (SemType) whileStmt.bodyStmt().accept(this, mode);

        if (!(t1.actualType() instanceof SemBoolean)){
            throw new Report.Error(whileStmt, "Types of expressions don't match.");
        }

        SemType t3 = new SemVoid();

        ofType.put(whileStmt, t3.actualType());

        return t3.actualType();

    }

    @Override
    public SemType visit(AstWhereExpr whereExpr, TypeResolver2.Mode mode){
        if (whereExpr.decls() != null){
            whereExpr.decls().accept(this, mode);
        }
        SemType t = ((SemType) whereExpr.expr().accept(this, mode)).actualType();
        return ofType.put(whereExpr, t);
    }

    @Override
    public SemType visit(AstRecExpr recExpr, TypeResolver2.Mode mode){

        SemRecord t = (SemRecord) recExpr.rec().accept(this, mode);
        AstTrees<AstCompDecl> tree = recStr.get(t);

        for (AstCompDecl i: tree){
            if (i.name().equals(recExpr.comp().name())){
                SemType t1 = isType.get(i.type()).actualType();
                ofType.put(recExpr, t1);
                return t1;
            }
        }

        throw new Report.Error(recExpr, "Component with this name doesn't exist");

    }

    @Override
    public SemType visit(AstFunDecl funDecl, TypeResolver2.Mode mode) {
        SemType t2 = ofType.get(funDecl.expr());
        SemType t1 = (SemType) funDecl.expr().accept(this, mode);
        if (!(t1.actualType().getClass().equals(t2.actualType().getClass()))){
            throw new Report.Error(funDecl, "Return type of a function doesn't match.");
        }
        return t2.actualType();
    }

}
