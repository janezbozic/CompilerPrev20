package prev.phase.seman;

import prev.data.ast.tree.decl.AstTypeDecl;
import prev.data.ast.visitor.AstFullVisitor;
import prev.data.semtype.SemName;

import static prev.phase.seman.SemAn.declaresType;

public class TypeResolver1 extends AstFullVisitor<Object, TypeResolver1.Mode> {

    public enum Mode {
        HEAD, BODY
    }

    @Override
    public Object visit(AstTypeDecl typeDecl, TypeResolver1.Mode mode) {
        declaresType.put(typeDecl, new SemName(typeDecl.name()));
        return null;
    }

}
