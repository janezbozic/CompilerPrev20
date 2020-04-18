package prev.phase.seman;

import prev.common.report.Report;
import prev.data.ast.tree.decl.AstVarDecl;
import prev.data.ast.tree.type.*;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.semtype.SemType;
import prev.data.semtype.SemVoid;

import static prev.phase.seman.SemAn.isType;

public class TypeResolver3 extends AstFullVisitor<Object, TypeResolver2.Mode> {

    @Override
    public Object visit(AstVarDecl varDecl, TypeResolver2.Mode mode){
        SemType t = (SemType) varDecl.type().accept(this, mode);
        if (t.actualType() instanceof SemVoid)
            throw new Report.Error(varDecl, "Varible can not be type Void.");
        return null;
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
