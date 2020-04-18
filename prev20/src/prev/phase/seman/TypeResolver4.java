package prev.phase.seman;

import prev.common.report.Report;
import prev.data.ast.tree.decl.AstFunDecl;
import prev.data.ast.tree.decl.AstParDecl;
import prev.data.ast.tree.type.*;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.semtype.*;

import static prev.phase.seman.SemAn.isType;
import static prev.phase.seman.SemAn.ofType;

public class TypeResolver4 extends AstFullVisitor<Object, TypeResolver2.Mode> {

    @Override
    public Object visit(AstFunDecl funDecl, TypeResolver2.Mode mode) {

        if (funDecl.pars() != null){
            funDecl.pars().accept(this, mode);
        }

        SemType tStart = (SemType)funDecl.type().accept(this, mode);
        if (tStart.actualType() instanceof SemArray || tStart.actualType() instanceof SemRecord){
            throw new Report.Error(funDecl, "Function can not be type array or record.");
        }

        ofType.put(funDecl.expr(), tStart.actualType());

        if (funDecl.expr() != null){
            funDecl.expr().accept(this, mode);
        }

        return null;
    }

    @Override
    public SemType visit(AstParDecl parDecl, TypeResolver2.Mode mode){
        SemType t = (SemType) parDecl.type().accept(this, mode);
        if (!(t.actualType() instanceof SemBoolean || t.actualType() instanceof SemChar || t.actualType() instanceof SemInteger || t.actualType() instanceof SemPointer)){
            throw new Report.Error(parDecl, "Argument of a function can't of type " + t.actualType().toString());
        }
        return t.actualType();
    }

    @Override
    public SemType visit(AstAtomType atomType, TypeResolver2.Mode mode) {
        return isType.get(atomType).actualType();
    }

    @Override
    public SemType visit(AstArrType arrType, TypeResolver2.Mode mode){
        return isType.get(arrType).actualType();
    }

    @Override
    public SemType visit(AstPtrType ptrType, TypeResolver2.Mode mode) {
        return isType.get(ptrType).actualType();
    }

    @Override
    public SemType visit(AstRecType recType, TypeResolver2.Mode mode){
        return isType.get(recType).actualType();
    }

    @Override
    public SemType visit(AstNameType nameType, TypeResolver2.Mode mode){
        return isType.get(nameType).actualType();
    }

}