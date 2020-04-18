package prev.phase.imclin;

import java.util.*;

import prev.data.ast.tree.decl.*;
import prev.data.ast.tree.expr.*;
import prev.data.ast.visitor.*;
import prev.data.mem.*;
import prev.data.imc.code.expr.*;
import prev.data.imc.code.stmt.*;
import prev.data.lin.*;
import prev.phase.imcgen.ImcGen;
import prev.phase.memory.*;

public class ChunkGenerator extends AstFullVisitor<Object, Object> {

	@Override
	public Object visit(AstAtomExpr atomExpr, Object arg) {
		switch (atomExpr.type()) {
		case STRING:
			MemAbsAccess absAccess = Memory.strings.get(atomExpr);
			ImcLin.addDataChunk(new LinDataChunk(absAccess));
			break;
		default:
			break;
		}
		return null;
	}

	@Override
	public Object visit(AstFunDecl funDecl, Object arg) {
		funDecl.expr().accept(this, arg);

		MemFrame frame = Memory.frames.get(funDecl);
		MemLabel entryLabel = new MemLabel();
		MemLabel exitLabel = new MemLabel();
		
		Vector<ImcStmt> canonStmts = new Vector<ImcStmt>();
		canonStmts.add(new ImcLABEL(entryLabel));
		ImcExpr bodyExpr = ImcGen.exprImc.get(funDecl.expr());
		ImcStmt bodyStmt = new ImcMOVE(new ImcTEMP(frame.RV), bodyExpr);
		canonStmts.addAll(bodyStmt.accept(new StmtCanonizer(), null));
		canonStmts.add(new ImcJUMP(exitLabel));
		
		Vector<ImcStmt> linearStmts = linearize (canonStmts);
		ImcLin.addCodeChunk(new LinCodeChunk(frame, linearStmts, entryLabel, exitLabel));
		
		return null;
	}

	@Override
	public Object visit(AstVarDecl varDecl, Object arg) {
		MemAccess access = Memory.accesses.get(varDecl);
		if (access instanceof MemAbsAccess) {
			MemAbsAccess absAccess = (MemAbsAccess) access;
			ImcLin.addDataChunk(new LinDataChunk(absAccess));
		}
		return null;
	}
	
	private Vector<ImcStmt> linearize(Vector<ImcStmt> stmts) {

		HashMap <MemLabel, Integer> hash = new HashMap <MemLabel, Integer>();
		Vector<ImcStmt> newStmts = new Vector <ImcStmt>();

		boolean isOK = false;

		for (int i = 0; i<stmts.size(); i++){
			ImcStmt l = stmts.get(i);
			if (l instanceof ImcLABEL){
				if (isOK){
					stmts.add(i, new ImcJUMP(((ImcLABEL)l).label));
					newStmts.add(new ImcJUMP(((ImcLABEL)l).label));
					i++;
				}
				isOK = true;
				hash.put(((ImcLABEL)l).label, i);
			}
			else if (l instanceof ImcJUMP || l instanceof ImcCJUMP){
				isOK = false;
			}
			newStmts.add(l);
		}

		for (int i = 0; i<newStmts.size(); i++){

			ImcStmt s = newStmts.get(i);

			if (s instanceof ImcCJUMP){
				int x = hash.get(((ImcCJUMP) s).negLabel) + 1;
				int count = i + 1;
				while (x < stmts.size() && !(stmts.get(x) instanceof ImcLABEL)){
					newStmts.add(count, stmts.get(x));
					x++;
					count++;
				}
			}
		}

		return newStmts;

	}

}
