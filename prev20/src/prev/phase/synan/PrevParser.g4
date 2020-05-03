parser grammar PrevParser;

@header {

	package prev.phase.synan;
	
	import java.util.*;
	
	import prev.common.report.*;
	import prev.phase.lexan.*;

	import prev.data.ast.tree.decl.*;
    import prev.data.ast.tree.expr.*;
    import prev.data.ast.tree.stmt.*;
    import prev.data.ast.tree.type.*;
    import prev.data.ast.tree.*;

	import prev.phase.lexan.LexAn.PrevToken;

}

options{
    tokenVocab=PrevLexer;
}


source
	returns [AstTrees <AstDecl> ast]
	: decl source_p EOF
	{
		Vector <AstDecl> ds = new Vector <AstDecl>();
		ds.add($decl.ast);
		ds.addAll($source_p.ast);
		$ast = new AstTrees<AstDecl>(ds);
	}
	;

source_p
	returns [Vector <AstDecl> ast]
	: decl source_p
	{
		Vector <AstDecl> ds = new Vector <AstDecl>();
		ds.add($decl.ast);
		ds.addAll($source_p.ast);
		$ast = ds;
	}
	|
	{
		$ast = new Vector<AstDecl>();
	}
	;

decl
	returns [AstDecl ast]
	: KW_TYP IDENTIFIER SIM_IS type
	{
		$ast = new AstTypeDecl(new Location((PrevToken)$KW_TYP, $type.ast), $IDENTIFIER.text, $type.ast);
	}
	| KW_VAR IDENTIFIER SIM_COL type
	{
		$ast = new AstVarDecl(new Location((PrevToken)$KW_VAR, $type.ast), $IDENTIFIER.text, $type.ast);
	}
	| KW_FUN IDENTIFIER SIM_LPAR decl_p SIM_RPAR SIM_COL type SIM_IS declaration_binder
	{
		$ast = new AstFunDecl(new Location((PrevToken)$KW_FUN, $declaration_binder.ast), $IDENTIFIER.text, $decl_p.ast, $type.ast, $declaration_binder.ast);
	}
	;

decl_p
	returns [AstTrees <AstParDecl> ast]
	: 
	{
		$ast = new AstTrees <AstParDecl> () ;
	}
	| IDENTIFIER SIM_COL type decl_args
	{
		Vector <AstParDecl> da = new Vector <AstParDecl>();
		da.add(new AstParDecl(new Location((PrevToken)$IDENTIFIER, $type.ast),$IDENTIFIER.text, $type.ast));
		da.addAll($decl_args.ast);
		$ast = new AstTrees<AstParDecl>(da);
	}
	;

decl_args
	returns [Vector <AstParDecl> ast]
	: SIM_COM IDENTIFIER SIM_COL type decl_args
	{
		Vector <AstParDecl> da = new Vector <AstParDecl>();
		da.add(new AstParDecl(new Location((PrevToken)$IDENTIFIER, $type.ast), $IDENTIFIER.text, $type.ast));
		da.addAll($decl_args.ast);
		$ast = da;
	}
	| 
	{
		$ast = new Vector <AstParDecl> () ;
	}
	;

type
	returns [AstType ast]
	: KW_BOOLEAN { AstType t = new AstAtomType(new Location((PrevToken)$KW_BOOLEAN), AstAtomType.Type.BOOLEAN); }
	{
		$ast = t;
	}
	|  KW_CHAR { AstType t = new AstAtomType(new Location((PrevToken)$KW_CHAR), AstAtomType.Type.CHAR); }
	{
		$ast = t;
	}
	| KW_INTEGER { AstType t = new AstAtomType(new Location((PrevToken)$KW_INTEGER), AstAtomType.Type.INTEGER); }
	{
		$ast = t;
	}
	| KW_VOID { AstType t = new AstAtomType(new Location((PrevToken)$KW_VOID), AstAtomType.Type.VOID); }
	{
		$ast = t;
	}
	| IDENTIFIER { AstType t = new AstNameType(new Location((PrevToken)$IDENTIFIER), $IDENTIFIER.text); }
	{
		$ast = t;
	}
	|SIM_TOP type { AstPtrType t = new AstPtrType (new Location((PrevToken)$SIM_TOP, $type.ast), $type.ast); }
	{
		$ast = t;
	}
	| SIM_LSQLBR IDENTIFIER SIM_COL type type_args SIM_RSQLBR {
		Vector v = new Vector<AstCompDecl>();
		AstCompDecl c = new AstCompDecl(new Location((PrevToken)$IDENTIFIER, $type.ast), $IDENTIFIER.text, $type.ast);
		v.add(c);
		v.addAll($type_args.ast);
		AstRecType t = new AstRecType(new Location((PrevToken)$SIM_LSQLBR, (PrevToken)$SIM_RSQLBR), new AstTrees<AstCompDecl>(v));
		$ast = t;
	}
	{
		$ast = t;
	}
	|SIM_LPAR type SIM_RPAR {AstType t = $type.ast; }
	{
		$ast = t;
	}
	| SIM_LSQRBR declaration_binder SIM_RSQRBR type { AstArrType t1 = new AstArrType(new Location((PrevToken)$SIM_LSQRBR, (PrevToken)$SIM_RSQRBR), $type.ast, $declaration_binder.ast); }
    {
        $ast = t1;
    }
	;

type_args
	returns [Vector<AstCompDecl> ast]
	: SIM_COM IDENTIFIER SIM_COL type type_args
	{
		Vector v = new Vector<AstCompDecl>();
		AstCompDecl c = new AstCompDecl(new Location((PrevToken)$IDENTIFIER, $type.ast), $IDENTIFIER.text, $type.ast);
		v.add(c);
		v.addAll($type_args.ast);
		$ast = v;
	}
	| 
	{
		$ast = new Vector<AstCompDecl>();
	}
	;

declaration_binder
	returns [AstExpr ast]
	: disjunctive { AstExpr e = $disjunctive.ast; } declaration_binder_p[e]
	{
		$ast = $declaration_binder_p.ast;
	}
	;

declaration_binder_p [AstExpr e] returns [AstExpr ast]
	: KW_WHERE SIM_LSQLBR decl source_p SIM_RSQLBR {
		Vector <AstDecl> ds = new Vector <AstDecl>();
		ds.add($decl.ast);
		ds.addAll($source_p.ast);
		AstTrees a = new AstTrees<AstDecl>(ds);
		AstWhereExpr e1 = new AstWhereExpr(new Location($e, (PrevToken)$SIM_RSQLBR), $e, a);
	} declaration_binder_p [e1]
	{
		$ast = $declaration_binder_p.ast;
	}
	|
	{
		$ast = $e;
	}
	;

disjunctive
	returns [AstExpr ast]
	: conjunctive {
		AstExpr e = $conjunctive.ast;
	} disjunctive_p[e] {
		$ast = $disjunctive_p.ast;
	}
	;

disjunctive_p [AstExpr e] returns [AstExpr ast]
	: SIM_LINE conjunctive {
		AstBinExpr ne = new AstBinExpr(new Location($e, $conjunctive.ast), AstBinExpr.Oper.OR, $e, $conjunctive.ast);
	} disjunctive_p[ne] 
	{
		$ast = $disjunctive_p.ast;
	}
	| {
		$ast = $e;
	}
	;

conjunctive
	returns [AstExpr ast]
	: relational {AstExpr e = $relational.ast;} conjunctive_p[e] 
	{
		$ast = $conjunctive_p.ast;
	}
	;

conjunctive_p [AstExpr e] returns [AstExpr ast]
	: SIM_AND relational {
		AstBinExpr ne = new AstBinExpr(new Location($e, $relational.ast), AstBinExpr.Oper.AND, $e, $relational.ast);
	} conjunctive_p[ne]
	{
		$ast = $conjunctive_p.ast;
	}
	|
	{
		$ast = $e;
	}
	;

relational
	returns [AstExpr ast]
	: additive {AstExpr e = $additive.ast;} relational_p[e]
	{
		$ast = $relational_p.ast;
	} 
	;

relational_p [AstExpr e] returns [AstExpr ast]
	: SIM_EQU additive
	{
		$ast = new AstBinExpr(new Location($e, $additive.ast), AstBinExpr.Oper.EQU, $e, $additive.ast);
	}
	| SIM_NEQU additive
	{
		$ast = new AstBinExpr(new Location($e, $additive.ast), AstBinExpr.Oper.NEQ, $e, $additive.ast);
	}
	| SIM_LT additive
	{
		$ast = new AstBinExpr(new Location($e, $additive.ast), AstBinExpr.Oper.LTH, $e, $additive.ast);
	}
	| SIM_GT additive
	{
		$ast = new AstBinExpr(new Location($e, $additive.ast), AstBinExpr.Oper.GTH, $e, $additive.ast);
	}
	| SIM_LTEQU additive
	{
		$ast = new AstBinExpr(new Location($e, $additive.ast), AstBinExpr.Oper.LEQ, $e, $additive.ast);
	}
	| SIM_GTEQU additive
	{
		$ast = new AstBinExpr(new Location($e, $additive.ast), AstBinExpr.Oper.GEQ, $e, $additive.ast);
	}
	|
	{
		$ast = $e;
	}
	;

additive
	returns [AstExpr ast]
	: multiplicative { AstExpr e = $multiplicative.ast; } additive_p[e]
	{
		$ast = $additive_p.ast;
	}
	;

additive_p [AstExpr e] returns [AstExpr ast] 
	: SIM_PLUS multiplicative {
		AstBinExpr ne = new AstBinExpr(new Location($e, $multiplicative.ast), AstBinExpr.Oper.ADD, $e, $multiplicative.ast);
	} additive_p[ne]
	{
		$ast = $additive_p.ast;
	}
	| SIM_MINUS multiplicative {
		AstBinExpr ne = new AstBinExpr(new Location($e, $multiplicative.ast), AstBinExpr.Oper.SUB, $e, $multiplicative.ast);
	} additive_p[ne]
	{
		$ast = $additive_p.ast;
	}
	|
	{
		$ast = $e;
	}
	;

multiplicative
	returns [AstExpr ast]
	: prefix {AstExpr e = $prefix.ast;} multiplicative_p[e]
	{
		$ast = $multiplicative_p.ast;
	}
	;

multiplicative_p [AstExpr e] returns [AstExpr ast]
	: SIM_STAR prefix {
		AstBinExpr ne = new AstBinExpr(new Location($e, $prefix.ast), AstBinExpr.Oper.MUL, $e, $prefix.ast);
	} multiplicative_p[ne]
	{
		$ast = $multiplicative_p.ast;
	}
	| SIM_SLH prefix {
		AstBinExpr ne = new AstBinExpr(new Location($e, $prefix.ast), AstBinExpr.Oper.DIV, $e, $prefix.ast);
	} multiplicative_p[ne]
	{
		$ast = $multiplicative_p.ast;
	}
	| SIM_PRCNT prefix {
		AstBinExpr ne = new AstBinExpr(new Location($e, $prefix.ast), AstBinExpr.Oper.MOD, $e, $prefix.ast);
	} multiplicative_p[ne]
	{
		$ast = $multiplicative_p.ast;
	}
	|
	{
		$ast = $e;
	}
	;

prefix
	returns [AstExpr ast]
	: SIM_EKSP prefix
	{
		AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)$SIM_EKSP, $prefix.ast), AstPfxExpr.Oper.NOT, $prefix.ast);
		$ast = ne;
	}
	| SIM_PLUS prefix
	{
		AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)$SIM_PLUS, $prefix.ast), AstPfxExpr.Oper.ADD, $prefix.ast);
		$ast = ne;
	}
	| SIM_MINUS prefix
	{
		AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)$SIM_MINUS, $prefix.ast), AstPfxExpr.Oper.SUB, $prefix.ast);
		$ast = ne;
	}
	| SIM_TOP prefix
	{
		AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)$SIM_TOP, $prefix.ast), AstPfxExpr.Oper.PTR, $prefix.ast);
		$ast = ne;
	}
	| KW_NEW prefix
	{
		AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)$KW_NEW , $prefix.ast), AstPfxExpr.Oper.NEW , $prefix.ast);
		$ast = ne;
	}
	| KW_DEL prefix
	{
		AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)$KW_DEL, $prefix.ast), AstPfxExpr.Oper.DEL, $prefix.ast);
		$ast = ne;
	}
	| postfix
	{
		$ast = $postfix.ast;
	}
	;

postfix
	returns [AstExpr ast]
	: expr {AstExpr e = $expr.ast;} postfix_p[e]
	{
		$ast = $postfix_p.ast;
	}
	;

postfix_p [AstExpr e] returns [AstExpr ast]
	: SIM_LSQRBR declaration_binder SIM_RSQRBR {
		AstArrExpr ne = new AstArrExpr (new Location($e, (PrevToken)$SIM_RSQRBR), $e, $declaration_binder.ast);
	} postfix_p[ne]
	{
		$ast = $postfix_p.ast;
	}
	| SIM_TOP {AstSfxExpr ne = new AstSfxExpr (new Location($e, (PrevToken)$SIM_TOP), AstSfxExpr.Oper.PTR, $e);} postfix_p[ne]
	{
		$ast = $postfix_p.ast;
	}
	| SIM_DOT IDENTIFIER {
		AstNameExpr ne1 = new AstNameExpr(new Location($e, (PrevToken)$IDENTIFIER), $IDENTIFIER.text);
		AstRecExpr ne2 = new AstRecExpr(new Location($e, (PrevToken)$IDENTIFIER), $e, ne1);
	} postfix_p[ne2]
	{
		$ast = $postfix_p.ast;
	}
	|
	{
		$ast = $e;
	}
	;

expr
	returns [AstExpr ast]
	: CONST_CHAR
	{
		$ast = new AstAtomExpr(new Location((PrevToken)$CONST_CHAR), AstAtomExpr.Type.CHAR, $CONST_CHAR.text);
	}
	| CONST_STRING
	{
		$ast = new AstAtomExpr(new Location((PrevToken)$CONST_STRING), AstAtomExpr.Type.STRING, $CONST_STRING.text);
	}
	| CONST_INTEGER
	{
		$ast = new AstAtomExpr(new Location((PrevToken)$CONST_INTEGER), AstAtomExpr.Type.INTEGER, $CONST_INTEGER.text);
	}
	| CONST_LITERAL
	{
		$ast = new AstAtomExpr(new Location((PrevToken)$CONST_LITERAL), AstAtomExpr.Type.POINTER, $CONST_LITERAL.text);
	}
	| CONST_BOOLEAN
	{
		$ast = new AstAtomExpr(new Location((PrevToken)$CONST_BOOLEAN), AstAtomExpr.Type.BOOLEAN, $CONST_BOOLEAN.text);
	}
	| CONST_VOID
	{
		$ast = new AstAtomExpr(new Location((PrevToken)$CONST_VOID), AstAtomExpr.Type.VOID, $CONST_VOID.text);
	}
	| IDENTIFIER expr_p[$IDENTIFIER.text, (PrevToken)$IDENTIFIER]
	{
		if ($expr_p.ast instanceof AstCallExpr){
			$ast = $expr_p.ast;
		}
		else {
			$ast = new AstNameExpr(new Location((PrevToken)$IDENTIFIER), $IDENTIFIER.text);
		}
	}
	| SIM_LSQLBR stmnt SIM_SCOL stmnt_args SIM_RSQLBR
	{
		Vector<AstStmt> s = new Vector<AstStmt>();
		s.add($stmnt.ast);
		s.addAll($stmnt_args.ast);
		$ast = new AstStmtExpr(new Location((PrevToken)$SIM_LSQLBR, (PrevToken)$SIM_RSQLBR), new AstTrees<AstStmt>(s));
	}
	| SIM_LPAR declaration_binder {AstExpr e = $declaration_binder.ast;} expr_pp[e] SIM_RPAR
	{
		if ($expr_pp.ast instanceof AstCastExpr){
			$ast = $expr_pp.ast;
		}
		else {
			$ast = $declaration_binder.ast;
		}
	}
	;

expr_p [String s, PrevToken identifier]
	returns [AstExpr ast]
	:
	{
		$ast = null;
	}
	| SIM_LPAR declaration_binder expr_args SIM_RPAR
	{
		Vector<AstExpr> a = new Vector<AstExpr>();
		a.add($declaration_binder.ast);
		a.addAll($expr_args.ast);
		AstTrees na = new AstTrees<AstExpr>(a);
		$ast = new AstCallExpr(new Location(identifier, (PrevToken)$SIM_RPAR), s, na);
	}
	| SIM_LPAR SIM_RPAR
	{
		$ast = new AstCallExpr(new Location(identifier, (PrevToken)$SIM_RPAR), s, new AstTrees<AstExpr>());
	}
	;

expr_pp [AstExpr e]
	returns [AstExpr ast]
	: SIM_COL type
	{
		$ast = new AstCastExpr(new Location($e, $type.ast), $e, $type.ast);
	}
	|
	{
		$ast = $e;
	}
	;

expr_args
	returns [Vector<AstExpr> ast]
	: SIM_COM declaration_binder expr_args
	{
		Vector<AstExpr> a = new Vector<AstExpr>();
		a.add($declaration_binder.ast);
		a.addAll($expr_args.ast);
		$ast = a;
	}
	|
	{
		$ast = new Vector<AstExpr>();
	}
	;

stmnt_args
	returns [Vector<AstStmt> ast]
	: stmnt SIM_SCOL stmnt_args
	{
		Vector<AstStmt> s = new Vector<AstStmt>();
		s.add($stmnt.ast);
		s.addAll($stmnt_args.ast);
		$ast = s;
	}
	|
	{
		$ast = new Vector<AstStmt>();
	}
	;

stmnt
	returns [AstStmt ast]
	: declaration_binder {AstExpr e = $declaration_binder.ast;} stmnt_p[e]
	{
		$ast = $stmnt_p.ast;
	}
	| KW_IF declaration_binder KW_THEN s1=stmnt KW_ELSE s2=stmnt
	{
		$ast = new AstIfStmt(new Location((PrevToken)$KW_IF, $s2.ast), $declaration_binder.ast, $s1.ast, $s2.ast);
	}
	| KW_WHILE declaration_binder KW_DO stmnt
	{
		$ast = new AstWhileStmt(new Location((PrevToken)$KW_WHILE, $stmnt.ast), $declaration_binder.ast, $stmnt.ast);
	}
	;

stmnt_p [AstExpr e]
	returns [AstStmt ast]
	: 
	{
		$ast = new AstExprStmt(new Location($e), $e);
	}
	| SIM_IS declaration_binder
	{
		$ast = new AstAssignStmt(new Location($e, $declaration_binder.ast), $e, $declaration_binder.ast);
	}
	;