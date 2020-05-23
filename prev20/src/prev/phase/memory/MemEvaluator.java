package prev.phase.memory;

import prev.data.ast.tree.*;
import prev.data.ast.tree.decl.*;
import prev.data.ast.tree.expr.*;
import prev.data.ast.tree.type.*;
import prev.data.ast.visitor.*;
import prev.data.imc.code.expr.ImcExpr;
import prev.data.semtype.*;
import prev.data.mem.*;
import prev.phase.imcgen.ImcGen;
import prev.phase.seman.*;

import static prev.phase.seman.SemAn.*;

/**
 * Computing memory layout: frames and accesses.
 */
public class MemEvaluator extends AstFullVisitor<Object, MemEvaluator.Context> {

	/**
	 * The context {@link MemEvaluator} uses while computing function frames and
	 * variable accesses.
	 */
	protected abstract class Context {
	}

	/**
	 * Functional context, i.e., used when traversing function and building a new
	 * frame, parameter accesses and variable accesses.
	 */
	private class FunContext extends Context {
		public int depth = 0;
		public long locsSize = 0;
		public long argsSize = 0;
		public long parsSize = new SemPointer(new SemVoid()).size();
	}

	/**
	 * Record context, i.e., used when traversing record definition and computing
	 * record component accesses.
	 */
	private class RecContext extends Context {
		public long compsSize = 0;
	}

	@Override
	public Object visit(AstFunDecl funDecl, MemEvaluator.Context c){

		FunContext newC = new FunContext();

		if (c != null) {
			FunContext context = (FunContext) c;
			newC.depth = context.depth + 1;
		}

		for (AstParDecl parDecl: funDecl.pars()){
			parDecl.accept(this, newC);
		}

		funDecl.expr().accept(this, newC);

		MemFrame memFrame;

		if (c == null)
			 memFrame = new MemFrame(new MemLabel(funDecl.name()),newC.depth, newC.locsSize, newC.argsSize);
		else
			memFrame = new MemFrame(new MemLabel(),newC.depth, newC.locsSize, newC.argsSize);

		Memory.frames.put(funDecl, memFrame);

		return memFrame;

	}

	@Override
	public Object visit(AstCallExpr callExpr, MemEvaluator.Context c){

		long size = 0;

		if (callExpr.args() != null) {
			callExpr.args().accept(this, c);

			for (AstExpr expr : callExpr.args()) {
				expr.accept(this, c);
				SemType t = ofType.get(expr).actualType();
				size += t.size();
			}
		}

		if (((FunContext)c).argsSize < size + 8)
			((FunContext)c).argsSize = size + 8;

		return null;
	}

	@Override
	public Object visit(AstParDecl parDecl, MemEvaluator.Context c){
		SemType t = (SemType) parDecl.type().accept(this, c);
		Memory.accesses.put(parDecl, new MemRelAccess(t.size(), ((FunContext) c).parsSize, ((FunContext) c).depth));
		((FunContext) c).parsSize += t.size();
		return null;
	}

	@Override
	public Object visit(AstVarDecl varDecl, MemEvaluator.Context c){
		SemType t = (SemType) varDecl.type().accept(this, c);
		if (c != null){
			((FunContext) c).locsSize += t.size();
			Memory.accesses.put(varDecl, new MemRelAccess(t.size(), -((FunContext) c).locsSize, ((FunContext) c).depth));
		}
		else {
			Memory.accesses.put(varDecl, new MemAbsAccess(t.size(), new MemLabel(varDecl.name())));
		}
		return null;
	}

	@Override
	public Object visit(AstPfxExpr pfxExpr, Context ctx) {
		switch (pfxExpr.oper()) {
			case DEL:
			case NEW:
				FunContext _ctx = (FunContext) ctx;
				if (_ctx.argsSize < 8)
					_ctx.argsSize = 8;
				break;
			case ADD:
			case SUB:
			case NOT:
			case PTR:
				break;
		}

		return null;
	}

	@Override
	public Object visit(AstAtomExpr atomExpr, MemEvaluator.Context c) {
		if (atomExpr.type() == AstAtomExpr.Type.STRING) {
			Memory.strings.put(atomExpr, new MemAbsAccess(new SemChar().size() * atomExpr.value().length(), new MemLabel(), atomExpr.value()));
		}
		return null;
	}

	@Override
	public SemType visit(AstAtomType atomType, MemEvaluator.Context c) {
			return isType.get(atomType);
	}

	@Override
	public SemType visit(AstArrType arrType, MemEvaluator.Context c){
		return isType.get(arrType);
	}

	@Override
	public SemType visit(AstPtrType ptrType, MemEvaluator.Context c) {
		return isType.get(ptrType);
	}

	@Override
	public SemType visit(AstRecType recType, MemEvaluator.Context c){
		return isType.get(recType);
	}

	@Override
	public SemType visit(AstNameType nameType, MemEvaluator.Context c){
		return isType.get(nameType);
	}

}
