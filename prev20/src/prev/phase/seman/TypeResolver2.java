package prev.phase.seman;

import prev.common.report.Report;
import prev.data.ast.tree.decl.AstCompDecl;
import prev.data.ast.tree.decl.AstTypeDecl;
import prev.data.ast.tree.expr.AstAtomExpr;
import prev.data.ast.tree.type.*;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.semtype.*;

import java.util.Vector;

import static prev.phase.seman.SemAn.*;

public class TypeResolver2 extends AstFullVisitor<Object, TypeResolver2.Mode> {

    public enum Mode {
        HEAD, BODY
    }

    @Override
    public Object visit(AstTypeDecl typeDecl, TypeResolver2.Mode mode) {
        declaresType.get(typeDecl).define((SemType) typeDecl.type().accept(this, mode));
        return null;
    }

    @Override
    public SemType visit(AstAtomType atomType, TypeResolver2.Mode mode) {

        SemType t = null;

        switch (atomType.type()){
            case BOOLEAN:
                t = new SemBoolean();
                break;
            case CHAR:
                t = new SemChar();
                break;
            case VOID:
                t = new SemVoid();
                break;
            case INTEGER:
                t = new SemInteger();
                break;
        }

        isType.put(atomType, t.actualType());

        return t.actualType();
    }

    @Override
    public SemType visit(AstArrType arrType, TypeResolver2.Mode mode){

        SemArray s = null;

        SemType t = (SemType) arrType.elemType().accept(this, mode);

        if (t instanceof SemVoid){
            throw new Report.Error(arrType, "Array can't be type void.");
        }

        arrType.numElems().accept(this, mode);

        if (arrType.numElems() instanceof AstAtomExpr && ((AstAtomExpr) arrType.numElems()).type() == AstAtomExpr.Type.INTEGER){
            long x = Long.parseLong(((AstAtomExpr) arrType.numElems()).value());
            s = new SemArray(t, x);
        }
        else {
            throw new Report.Error(arrType, "Number of Array elements not a number.");
        }

        isType.put(arrType, s.actualType());

        return s.actualType();

    }

    @Override
    public SemType visit(AstPtrType ptrType, TypeResolver2.Mode mode) {

        SemType t = (SemType) ptrType.baseType().accept(this,mode);

        SemPointer s = new SemPointer(t.actualType());

        isType.put(ptrType, s.actualType());

        return s.actualType();

    }

    @Override
    public SemType visit(AstRecType recType, TypeResolver2.Mode mode){

        Vector<SemType> v = new Vector<SemType>();

        for (AstCompDecl c: recType.comps()){
            SemType t = (SemType)c.accept(this, mode);
            if (t instanceof SemVoid) {
                throw new Report.Error(recType, "Type in RecordType can't be void.");
            }
            v.add(t);
        }


        SemRecord r = new SemRecord(v);
        recStr.put(r, recType.comps());

        isType.put(recType, r.actualType());
        return r.actualType();

    }

    @Override
    public SemType visit(AstCompDecl compDecl, TypeResolver2.Mode mode){

        return (SemType) compDecl.type().accept(this, mode);

    }


    @Override
    public SemType visit(AstNameType nameType, TypeResolver2.Mode mode){

        SemType t = declaresType.get((AstTypeDecl)declaredAt.get(nameType));

        if (t.actualType() == null)
            throw new Report.Error(nameType, "Type of variable is not correct");

        isType.put(nameType, t.actualType());

        return t.actualType();
    }

}
