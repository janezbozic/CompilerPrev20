// Generated from synan/PrevParser.g4 by ANTLR 4.8


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


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrevParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, CONST_CHAR=2, CONST_STRING=3, CONST_INTEGER=4, CONST_LITERAL=5, 
		KW_BOOLEAN=6, KW_CHAR=7, KW_DEL=8, KW_DO=9, KW_ELSE=10, KW_FUN=11, KW_IF=12, 
		KW_INTEGER=13, KW_NEW=14, KW_THEN=15, KW_TYP=16, KW_VAR=17, KW_VOID=18, 
		KW_WHERE=19, KW_WHILE=20, CONST_BOOLEAN=21, CONST_VOID=22, IDENTIFIER=23, 
		SIM_LPAR=24, SIM_RPAR=25, SIM_LSQLBR=26, SIM_RSQLBR=27, SIM_LSQRBR=28, 
		SIM_RSQRBR=29, SIM_DOT=30, SIM_COM=31, SIM_COL=32, SIM_SCOL=33, SIM_AND=34, 
		SIM_LINE=35, SIM_EKSP=36, SIM_EQU=37, SIM_NEQU=38, SIM_LT=39, SIM_GT=40, 
		SIM_LTEQU=41, SIM_GTEQU=42, SIM_STAR=43, SIM_SLH=44, SIM_PRCNT=45, SIM_PLUS=46, 
		SIM_MINUS=47, SIM_TOP=48, SIM_IS=49, SPACE=50, TAB=51, ERROR=52;
	public static final int
		RULE_source = 0, RULE_source_p = 1, RULE_decl = 2, RULE_decl_p = 3, RULE_decl_args = 4, 
		RULE_type = 5, RULE_type_p = 6, RULE_type_args = 7, RULE_declaration_binder = 8, 
		RULE_declaration_binder_p = 9, RULE_disjunctive = 10, RULE_disjunctive_p = 11, 
		RULE_conjunctive = 12, RULE_conjunctive_p = 13, RULE_relational = 14, 
		RULE_relational_p = 15, RULE_additive = 16, RULE_additive_p = 17, RULE_multiplicative = 18, 
		RULE_multiplicative_p = 19, RULE_prefix = 20, RULE_postfix = 21, RULE_postfix_p = 22, 
		RULE_expr = 23, RULE_expr_p = 24, RULE_expr_pp = 25, RULE_expr_args = 26, 
		RULE_stmnt_args = 27, RULE_stmnt = 28, RULE_stmnt_p = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"source", "source_p", "decl", "decl_p", "decl_args", "type", "type_p", 
			"type_args", "declaration_binder", "declaration_binder_p", "disjunctive", 
			"disjunctive_p", "conjunctive", "conjunctive_p", "relational", "relational_p", 
			"additive", "additive_p", "multiplicative", "multiplicative_p", "prefix", 
			"postfix", "postfix_p", "expr", "expr_p", "expr_pp", "expr_args", "stmnt_args", 
			"stmnt", "stmnt_p"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'nil'", "'boolean'", "'char'", "'del'", 
			"'do'", "'else'", "'fun'", "'if'", "'integer'", "'new'", "'then'", "'typ'", 
			"'var'", "'void'", "'where'", "'while'", null, "'none'", null, "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "'.'", "','", "':'", "';'", "'&'", 
			"'|'", "'!'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'*'", "'/'", 
			"'%'", "'+'", "'-'", "'^'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "CONST_CHAR", "CONST_STRING", "CONST_INTEGER", "CONST_LITERAL", 
			"KW_BOOLEAN", "KW_CHAR", "KW_DEL", "KW_DO", "KW_ELSE", "KW_FUN", "KW_IF", 
			"KW_INTEGER", "KW_NEW", "KW_THEN", "KW_TYP", "KW_VAR", "KW_VOID", "KW_WHERE", 
			"KW_WHILE", "CONST_BOOLEAN", "CONST_VOID", "IDENTIFIER", "SIM_LPAR", 
			"SIM_RPAR", "SIM_LSQLBR", "SIM_RSQLBR", "SIM_LSQRBR", "SIM_RSQRBR", "SIM_DOT", 
			"SIM_COM", "SIM_COL", "SIM_SCOL", "SIM_AND", "SIM_LINE", "SIM_EKSP", 
			"SIM_EQU", "SIM_NEQU", "SIM_LT", "SIM_GT", "SIM_LTEQU", "SIM_GTEQU", 
			"SIM_STAR", "SIM_SLH", "SIM_PRCNT", "SIM_PLUS", "SIM_MINUS", "SIM_TOP", 
			"SIM_IS", "SPACE", "TAB", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PrevParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PrevParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SourceContext extends ParserRuleContext {
		public AstTrees <AstDecl> ast;
		public DeclContext decl;
		public Source_pContext source_p;
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Source_pContext source_p() {
			return getRuleContext(Source_pContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PrevParser.EOF, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			((SourceContext)_localctx).decl = decl();
			setState(61);
			((SourceContext)_localctx).source_p = source_p();
			setState(62);
			match(EOF);

					Vector <AstDecl> ds = new Vector <AstDecl>();
					ds.add(((SourceContext)_localctx).decl.ast);
					ds.addAll(((SourceContext)_localctx).source_p.ast);
					((SourceContext)_localctx).ast =  new AstTrees<AstDecl>(ds);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Source_pContext extends ParserRuleContext {
		public Vector <AstDecl> ast;
		public DeclContext decl;
		public Source_pContext source_p;
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Source_pContext source_p() {
			return getRuleContext(Source_pContext.class,0);
		}
		public Source_pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source_p; }
	}

	public final Source_pContext source_p() throws RecognitionException {
		Source_pContext _localctx = new Source_pContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_source_p);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_FUN:
			case KW_TYP:
			case KW_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((Source_pContext)_localctx).decl = decl();
				setState(66);
				((Source_pContext)_localctx).source_p = source_p();

						Vector <AstDecl> ds = new Vector <AstDecl>();
						ds.add(((Source_pContext)_localctx).decl.ast);
						ds.addAll(((Source_pContext)_localctx).source_p.ast);
						((Source_pContext)_localctx).ast =  ds;
					
				}
				break;
			case EOF:
			case SIM_RSQLBR:
				enterOuterAlt(_localctx, 2);
				{

						((Source_pContext)_localctx).ast =  new Vector<AstDecl>();
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public AstDecl ast;
		public Token KW_TYP;
		public Token IDENTIFIER;
		public TypeContext type;
		public Token KW_VAR;
		public Token KW_FUN;
		public Decl_pContext decl_p;
		public Declaration_binderContext declaration_binder;
		public TerminalNode KW_TYP() { return getToken(PrevParser.KW_TYP, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PrevParser.IDENTIFIER, 0); }
		public TerminalNode SIM_IS() { return getToken(PrevParser.SIM_IS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode KW_VAR() { return getToken(PrevParser.KW_VAR, 0); }
		public TerminalNode SIM_COL() { return getToken(PrevParser.SIM_COL, 0); }
		public TerminalNode KW_FUN() { return getToken(PrevParser.KW_FUN, 0); }
		public TerminalNode SIM_LPAR() { return getToken(PrevParser.SIM_LPAR, 0); }
		public Decl_pContext decl_p() {
			return getRuleContext(Decl_pContext.class,0);
		}
		public TerminalNode SIM_RPAR() { return getToken(PrevParser.SIM_RPAR, 0); }
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_TYP:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				((DeclContext)_localctx).KW_TYP = match(KW_TYP);
				setState(73);
				((DeclContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(74);
				match(SIM_IS);
				setState(75);
				((DeclContext)_localctx).type = type();

						((DeclContext)_localctx).ast =  new AstTypeDecl(new Location((PrevToken)((DeclContext)_localctx).KW_TYP, ((DeclContext)_localctx).type.ast), (((DeclContext)_localctx).IDENTIFIER!=null?((DeclContext)_localctx).IDENTIFIER.getText():null), ((DeclContext)_localctx).type.ast);
					
				}
				break;
			case KW_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				((DeclContext)_localctx).KW_VAR = match(KW_VAR);
				setState(79);
				((DeclContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(80);
				match(SIM_COL);
				setState(81);
				((DeclContext)_localctx).type = type();

						((DeclContext)_localctx).ast =  new AstVarDecl(new Location((PrevToken)((DeclContext)_localctx).KW_VAR, ((DeclContext)_localctx).type.ast), (((DeclContext)_localctx).IDENTIFIER!=null?((DeclContext)_localctx).IDENTIFIER.getText():null), ((DeclContext)_localctx).type.ast);
					
				}
				break;
			case KW_FUN:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				((DeclContext)_localctx).KW_FUN = match(KW_FUN);
				setState(85);
				((DeclContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(86);
				match(SIM_LPAR);
				setState(87);
				((DeclContext)_localctx).decl_p = decl_p();
				setState(88);
				match(SIM_RPAR);
				setState(89);
				match(SIM_COL);
				setState(90);
				((DeclContext)_localctx).type = type();
				setState(91);
				match(SIM_IS);
				setState(92);
				((DeclContext)_localctx).declaration_binder = declaration_binder();

						((DeclContext)_localctx).ast =  new AstFunDecl(new Location((PrevToken)((DeclContext)_localctx).KW_FUN, ((DeclContext)_localctx).declaration_binder.ast), (((DeclContext)_localctx).IDENTIFIER!=null?((DeclContext)_localctx).IDENTIFIER.getText():null), ((DeclContext)_localctx).decl_p.ast, ((DeclContext)_localctx).type.ast, ((DeclContext)_localctx).declaration_binder.ast);
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_pContext extends ParserRuleContext {
		public AstTrees <AstParDecl> ast;
		public Token IDENTIFIER;
		public TypeContext type;
		public Decl_argsContext decl_args;
		public TerminalNode IDENTIFIER() { return getToken(PrevParser.IDENTIFIER, 0); }
		public TerminalNode SIM_COL() { return getToken(PrevParser.SIM_COL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Decl_argsContext decl_args() {
			return getRuleContext(Decl_argsContext.class,0);
		}
		public Decl_pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_p; }
	}

	public final Decl_pContext decl_p() throws RecognitionException {
		Decl_pContext _localctx = new Decl_pContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl_p);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_RPAR:
				enterOuterAlt(_localctx, 1);
				{

						((Decl_pContext)_localctx).ast =  new AstTrees <AstParDecl> () ;
					
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				((Decl_pContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(99);
				match(SIM_COL);
				setState(100);
				((Decl_pContext)_localctx).type = type();
				setState(101);
				((Decl_pContext)_localctx).decl_args = decl_args();

						Vector <AstParDecl> da = new Vector <AstParDecl>();
						da.add(new AstParDecl(new Location((PrevToken)((Decl_pContext)_localctx).IDENTIFIER, ((Decl_pContext)_localctx).type.ast),(((Decl_pContext)_localctx).IDENTIFIER!=null?((Decl_pContext)_localctx).IDENTIFIER.getText():null), ((Decl_pContext)_localctx).type.ast));
						da.addAll(((Decl_pContext)_localctx).decl_args.ast);
						((Decl_pContext)_localctx).ast =  new AstTrees<AstParDecl>(da);
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_argsContext extends ParserRuleContext {
		public Vector <AstParDecl> ast;
		public Token IDENTIFIER;
		public TypeContext type;
		public Decl_argsContext decl_args;
		public TerminalNode SIM_COM() { return getToken(PrevParser.SIM_COM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PrevParser.IDENTIFIER, 0); }
		public TerminalNode SIM_COL() { return getToken(PrevParser.SIM_COL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Decl_argsContext decl_args() {
			return getRuleContext(Decl_argsContext.class,0);
		}
		public Decl_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_args; }
	}

	public final Decl_argsContext decl_args() throws RecognitionException {
		Decl_argsContext _localctx = new Decl_argsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl_args);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_COM:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(SIM_COM);
				setState(107);
				((Decl_argsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(108);
				match(SIM_COL);
				setState(109);
				((Decl_argsContext)_localctx).type = type();
				setState(110);
				((Decl_argsContext)_localctx).decl_args = decl_args();

						Vector <AstParDecl> da = new Vector <AstParDecl>();
						da.add(new AstParDecl(new Location((PrevToken)((Decl_argsContext)_localctx).IDENTIFIER, ((Decl_argsContext)_localctx).type.ast), (((Decl_argsContext)_localctx).IDENTIFIER!=null?((Decl_argsContext)_localctx).IDENTIFIER.getText():null), ((Decl_argsContext)_localctx).type.ast));
						da.addAll(((Decl_argsContext)_localctx).decl_args.ast);
						((Decl_argsContext)_localctx).ast =  da;
					
				}
				break;
			case SIM_RPAR:
				enterOuterAlt(_localctx, 2);
				{

						((Decl_argsContext)_localctx).ast =  new Vector <AstParDecl> () ;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public AstType ast;
		public Token KW_BOOLEAN;
		public Type_pContext type_p;
		public Token KW_CHAR;
		public Token KW_INTEGER;
		public Token KW_VOID;
		public Token IDENTIFIER;
		public Token SIM_TOP;
		public TypeContext type;
		public Token SIM_LSQLBR;
		public Type_argsContext type_args;
		public Token SIM_RSQLBR;
		public TerminalNode KW_BOOLEAN() { return getToken(PrevParser.KW_BOOLEAN, 0); }
		public Type_pContext type_p() {
			return getRuleContext(Type_pContext.class,0);
		}
		public TerminalNode KW_CHAR() { return getToken(PrevParser.KW_CHAR, 0); }
		public TerminalNode KW_INTEGER() { return getToken(PrevParser.KW_INTEGER, 0); }
		public TerminalNode KW_VOID() { return getToken(PrevParser.KW_VOID, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PrevParser.IDENTIFIER, 0); }
		public TerminalNode SIM_TOP() { return getToken(PrevParser.SIM_TOP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SIM_LSQLBR() { return getToken(PrevParser.SIM_LSQLBR, 0); }
		public TerminalNode SIM_COL() { return getToken(PrevParser.SIM_COL, 0); }
		public Type_argsContext type_args() {
			return getRuleContext(Type_argsContext.class,0);
		}
		public TerminalNode SIM_RSQLBR() { return getToken(PrevParser.SIM_RSQLBR, 0); }
		public TerminalNode SIM_LPAR() { return getToken(PrevParser.SIM_LPAR, 0); }
		public TerminalNode SIM_RPAR() { return getToken(PrevParser.SIM_RPAR, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((TypeContext)_localctx).KW_BOOLEAN = match(KW_BOOLEAN);
				 AstType t = new AstAtomType(new Location((PrevToken)((TypeContext)_localctx).KW_BOOLEAN), AstAtomType.Type.BOOLEAN); 
				setState(118);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((TypeContext)_localctx).KW_CHAR = match(KW_CHAR);
				 AstType t = new AstAtomType(new Location((PrevToken)((TypeContext)_localctx).KW_CHAR), AstAtomType.Type.CHAR); 
				setState(123);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			case KW_INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				((TypeContext)_localctx).KW_INTEGER = match(KW_INTEGER);
				 AstType t = new AstAtomType(new Location((PrevToken)((TypeContext)_localctx).KW_INTEGER), AstAtomType.Type.INTEGER); 
				setState(128);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			case KW_VOID:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				((TypeContext)_localctx).KW_VOID = match(KW_VOID);
				 AstType t = new AstAtomType(new Location((PrevToken)((TypeContext)_localctx).KW_VOID), AstAtomType.Type.VOID); 
				setState(133);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				((TypeContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 AstType t = new AstNameType(new Location((PrevToken)((TypeContext)_localctx).IDENTIFIER), (((TypeContext)_localctx).IDENTIFIER!=null?((TypeContext)_localctx).IDENTIFIER.getText():null)); 
				setState(138);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			case SIM_TOP:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				((TypeContext)_localctx).SIM_TOP = match(SIM_TOP);
				setState(142);
				((TypeContext)_localctx).type = type();
				 AstPtrType t = new AstPtrType (new Location((PrevToken)((TypeContext)_localctx).SIM_TOP, ((TypeContext)_localctx).type.ast), ((TypeContext)_localctx).type.ast); 
				setState(144);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			case SIM_LSQLBR:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				((TypeContext)_localctx).SIM_LSQLBR = match(SIM_LSQLBR);
				setState(148);
				((TypeContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(149);
				match(SIM_COL);
				setState(150);
				((TypeContext)_localctx).type = type();
				setState(151);
				((TypeContext)_localctx).type_args = type_args();
				setState(152);
				((TypeContext)_localctx).SIM_RSQLBR = match(SIM_RSQLBR);

						Vector v = new Vector<AstCompDecl>();
						AstCompDecl c = new AstCompDecl(new Location((PrevToken)((TypeContext)_localctx).IDENTIFIER, ((TypeContext)_localctx).type.ast), (((TypeContext)_localctx).IDENTIFIER!=null?((TypeContext)_localctx).IDENTIFIER.getText():null), ((TypeContext)_localctx).type.ast);
						v.add(c);
						v.addAll(((TypeContext)_localctx).type_args.ast);
						AstRecType t = new AstRecType(new Location((PrevToken)((TypeContext)_localctx).SIM_LSQLBR, (PrevToken)((TypeContext)_localctx).SIM_RSQLBR), new AstTrees<AstCompDecl>(v));
						((TypeContext)_localctx).ast =  t;
					
				setState(154);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			case SIM_LPAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(157);
				match(SIM_LPAR);
				setState(158);
				((TypeContext)_localctx).type = type();
				setState(159);
				match(SIM_RPAR);
				AstType t = ((TypeContext)_localctx).type.ast; 
				setState(161);
				((TypeContext)_localctx).type_p = type_p(t);

						((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_p.ast;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_pContext extends ParserRuleContext {
		public AstType t;
		public AstType ast;
		public Declaration_binderContext declaration_binder;
		public Token SIM_RSQRBR;
		public Type_pContext type_p;
		public TerminalNode SIM_LSQRBR() { return getToken(PrevParser.SIM_LSQRBR, 0); }
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public TerminalNode SIM_RSQRBR() { return getToken(PrevParser.SIM_RSQRBR, 0); }
		public Type_pContext type_p() {
			return getRuleContext(Type_pContext.class,0);
		}
		public Type_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Type_pContext(ParserRuleContext parent, int invokingState, AstType t) {
			super(parent, invokingState);
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_type_p; }
	}

	public final Type_pContext type_p(AstType t) throws RecognitionException {
		Type_pContext _localctx = new Type_pContext(_ctx, getState(), t);
		enterRule(_localctx, 12, RULE_type_p);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(SIM_LSQRBR);
				setState(167);
				((Type_pContext)_localctx).declaration_binder = declaration_binder();
				setState(168);
				((Type_pContext)_localctx).SIM_RSQRBR = match(SIM_RSQRBR);
				 AstArrType t1 = new AstArrType(new Location(_localctx.t, (PrevToken)((Type_pContext)_localctx).SIM_RSQRBR), _localctx.t, ((Type_pContext)_localctx).declaration_binder.ast); 
				setState(170);
				((Type_pContext)_localctx).type_p = type_p(t1);

						((Type_pContext)_localctx).ast =  ((Type_pContext)_localctx).type_p.ast;
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{

						((Type_pContext)_localctx).ast =  _localctx.t;
					
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_argsContext extends ParserRuleContext {
		public Vector<AstCompDecl> ast;
		public Token IDENTIFIER;
		public TypeContext type;
		public Type_argsContext type_args;
		public TerminalNode SIM_COM() { return getToken(PrevParser.SIM_COM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PrevParser.IDENTIFIER, 0); }
		public TerminalNode SIM_COL() { return getToken(PrevParser.SIM_COL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Type_argsContext type_args() {
			return getRuleContext(Type_argsContext.class,0);
		}
		public Type_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_args; }
	}

	public final Type_argsContext type_args() throws RecognitionException {
		Type_argsContext _localctx = new Type_argsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type_args);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_COM:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(SIM_COM);
				setState(177);
				((Type_argsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(178);
				match(SIM_COL);
				setState(179);
				((Type_argsContext)_localctx).type = type();
				setState(180);
				((Type_argsContext)_localctx).type_args = type_args();

						Vector v = new Vector<AstCompDecl>();
						AstCompDecl c = new AstCompDecl(new Location((PrevToken)((Type_argsContext)_localctx).IDENTIFIER, ((Type_argsContext)_localctx).type.ast), (((Type_argsContext)_localctx).IDENTIFIER!=null?((Type_argsContext)_localctx).IDENTIFIER.getText():null), ((Type_argsContext)_localctx).type.ast);
						v.add(c);
						v.addAll(((Type_argsContext)_localctx).type_args.ast);
						((Type_argsContext)_localctx).ast =  v;
					
				}
				break;
			case SIM_RSQLBR:
				enterOuterAlt(_localctx, 2);
				{

						((Type_argsContext)_localctx).ast =  new Vector<AstCompDecl>();
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaration_binderContext extends ParserRuleContext {
		public AstExpr ast;
		public DisjunctiveContext disjunctive;
		public Declaration_binder_pContext declaration_binder_p;
		public DisjunctiveContext disjunctive() {
			return getRuleContext(DisjunctiveContext.class,0);
		}
		public Declaration_binder_pContext declaration_binder_p() {
			return getRuleContext(Declaration_binder_pContext.class,0);
		}
		public Declaration_binderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_binder; }
	}

	public final Declaration_binderContext declaration_binder() throws RecognitionException {
		Declaration_binderContext _localctx = new Declaration_binderContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration_binder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			((Declaration_binderContext)_localctx).disjunctive = disjunctive();
			 AstExpr e = ((Declaration_binderContext)_localctx).disjunctive.ast; 
			setState(188);
			((Declaration_binderContext)_localctx).declaration_binder_p = declaration_binder_p(e);

					((Declaration_binderContext)_localctx).ast =  ((Declaration_binderContext)_localctx).declaration_binder_p.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaration_binder_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public DeclContext decl;
		public Source_pContext source_p;
		public Token SIM_RSQLBR;
		public Declaration_binder_pContext declaration_binder_p;
		public TerminalNode KW_WHERE() { return getToken(PrevParser.KW_WHERE, 0); }
		public TerminalNode SIM_LSQLBR() { return getToken(PrevParser.SIM_LSQLBR, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Source_pContext source_p() {
			return getRuleContext(Source_pContext.class,0);
		}
		public TerminalNode SIM_RSQLBR() { return getToken(PrevParser.SIM_RSQLBR, 0); }
		public Declaration_binder_pContext declaration_binder_p() {
			return getRuleContext(Declaration_binder_pContext.class,0);
		}
		public Declaration_binder_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Declaration_binder_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_declaration_binder_p; }
	}

	public final Declaration_binder_pContext declaration_binder_p(AstExpr e) throws RecognitionException {
		Declaration_binder_pContext _localctx = new Declaration_binder_pContext(_ctx, getState(), e);
		enterRule(_localctx, 18, RULE_declaration_binder_p);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_WHERE:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(KW_WHERE);
				setState(192);
				match(SIM_LSQLBR);
				setState(193);
				((Declaration_binder_pContext)_localctx).decl = decl();
				setState(194);
				((Declaration_binder_pContext)_localctx).source_p = source_p();
				setState(195);
				((Declaration_binder_pContext)_localctx).SIM_RSQLBR = match(SIM_RSQLBR);

						Vector <AstDecl> ds = new Vector <AstDecl>();
						ds.add(((Declaration_binder_pContext)_localctx).decl.ast);
						ds.addAll(((Declaration_binder_pContext)_localctx).source_p.ast);
						AstTrees a = new AstTrees<AstDecl>(ds);
						AstWhereExpr e1 = new AstWhereExpr(new Location(_localctx.e, (PrevToken)((Declaration_binder_pContext)_localctx).SIM_RSQLBR), _localctx.e, a);
					
				setState(197);
				((Declaration_binder_pContext)_localctx).declaration_binder_p = declaration_binder_p(e1);

						((Declaration_binder_pContext)_localctx).ast =  ((Declaration_binder_pContext)_localctx).declaration_binder_p.ast;
					
				}
				break;
			case EOF:
			case KW_DO:
			case KW_ELSE:
			case KW_FUN:
			case KW_THEN:
			case KW_TYP:
			case KW_VAR:
			case SIM_RPAR:
			case SIM_RSQLBR:
			case SIM_RSQRBR:
			case SIM_COM:
			case SIM_COL:
			case SIM_SCOL:
			case SIM_IS:
				enterOuterAlt(_localctx, 2);
				{

						((Declaration_binder_pContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctiveContext extends ParserRuleContext {
		public AstExpr ast;
		public ConjunctiveContext conjunctive;
		public Disjunctive_pContext disjunctive_p;
		public ConjunctiveContext conjunctive() {
			return getRuleContext(ConjunctiveContext.class,0);
		}
		public Disjunctive_pContext disjunctive_p() {
			return getRuleContext(Disjunctive_pContext.class,0);
		}
		public DisjunctiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctive; }
	}

	public final DisjunctiveContext disjunctive() throws RecognitionException {
		DisjunctiveContext _localctx = new DisjunctiveContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_disjunctive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			((DisjunctiveContext)_localctx).conjunctive = conjunctive();

					AstExpr e = ((DisjunctiveContext)_localctx).conjunctive.ast;
				
			setState(205);
			((DisjunctiveContext)_localctx).disjunctive_p = disjunctive_p(e);

					((DisjunctiveContext)_localctx).ast =  ((DisjunctiveContext)_localctx).disjunctive_p.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Disjunctive_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public ConjunctiveContext conjunctive;
		public Disjunctive_pContext disjunctive_p;
		public TerminalNode SIM_LINE() { return getToken(PrevParser.SIM_LINE, 0); }
		public ConjunctiveContext conjunctive() {
			return getRuleContext(ConjunctiveContext.class,0);
		}
		public Disjunctive_pContext disjunctive_p() {
			return getRuleContext(Disjunctive_pContext.class,0);
		}
		public Disjunctive_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Disjunctive_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_disjunctive_p; }
	}

	public final Disjunctive_pContext disjunctive_p(AstExpr e) throws RecognitionException {
		Disjunctive_pContext _localctx = new Disjunctive_pContext(_ctx, getState(), e);
		enterRule(_localctx, 22, RULE_disjunctive_p);
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_LINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(SIM_LINE);
				setState(209);
				((Disjunctive_pContext)_localctx).conjunctive = conjunctive();

						AstBinExpr ne = new AstBinExpr(new Location(_localctx.e, ((Disjunctive_pContext)_localctx).conjunctive.ast), AstBinExpr.Oper.OR, _localctx.e, ((Disjunctive_pContext)_localctx).conjunctive.ast);
					
				setState(211);
				((Disjunctive_pContext)_localctx).disjunctive_p = disjunctive_p(ne);

						((Disjunctive_pContext)_localctx).ast =  ((Disjunctive_pContext)_localctx).disjunctive_p.ast;
					
				}
				break;
			case EOF:
			case KW_DO:
			case KW_ELSE:
			case KW_FUN:
			case KW_THEN:
			case KW_TYP:
			case KW_VAR:
			case KW_WHERE:
			case SIM_RPAR:
			case SIM_RSQLBR:
			case SIM_RSQRBR:
			case SIM_COM:
			case SIM_COL:
			case SIM_SCOL:
			case SIM_IS:
				enterOuterAlt(_localctx, 2);
				{

						((Disjunctive_pContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctiveContext extends ParserRuleContext {
		public AstExpr ast;
		public RelationalContext relational;
		public Conjunctive_pContext conjunctive_p;
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public Conjunctive_pContext conjunctive_p() {
			return getRuleContext(Conjunctive_pContext.class,0);
		}
		public ConjunctiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunctive; }
	}

	public final ConjunctiveContext conjunctive() throws RecognitionException {
		ConjunctiveContext _localctx = new ConjunctiveContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_conjunctive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			((ConjunctiveContext)_localctx).relational = relational();
			AstExpr e = ((ConjunctiveContext)_localctx).relational.ast;
			setState(219);
			((ConjunctiveContext)_localctx).conjunctive_p = conjunctive_p(e);

					((ConjunctiveContext)_localctx).ast =  ((ConjunctiveContext)_localctx).conjunctive_p.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conjunctive_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public RelationalContext relational;
		public Conjunctive_pContext conjunctive_p;
		public TerminalNode SIM_AND() { return getToken(PrevParser.SIM_AND, 0); }
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public Conjunctive_pContext conjunctive_p() {
			return getRuleContext(Conjunctive_pContext.class,0);
		}
		public Conjunctive_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Conjunctive_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_conjunctive_p; }
	}

	public final Conjunctive_pContext conjunctive_p(AstExpr e) throws RecognitionException {
		Conjunctive_pContext _localctx = new Conjunctive_pContext(_ctx, getState(), e);
		enterRule(_localctx, 26, RULE_conjunctive_p);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(SIM_AND);
				setState(223);
				((Conjunctive_pContext)_localctx).relational = relational();

						AstBinExpr ne = new AstBinExpr(new Location(_localctx.e, ((Conjunctive_pContext)_localctx).relational.ast), AstBinExpr.Oper.AND, _localctx.e, ((Conjunctive_pContext)_localctx).relational.ast);
					
				setState(225);
				((Conjunctive_pContext)_localctx).conjunctive_p = conjunctive_p(ne);

						((Conjunctive_pContext)_localctx).ast =  ((Conjunctive_pContext)_localctx).conjunctive_p.ast;
					
				}
				break;
			case EOF:
			case KW_DO:
			case KW_ELSE:
			case KW_FUN:
			case KW_THEN:
			case KW_TYP:
			case KW_VAR:
			case KW_WHERE:
			case SIM_RPAR:
			case SIM_RSQLBR:
			case SIM_RSQRBR:
			case SIM_COM:
			case SIM_COL:
			case SIM_SCOL:
			case SIM_LINE:
			case SIM_IS:
				enterOuterAlt(_localctx, 2);
				{

						((Conjunctive_pContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalContext extends ParserRuleContext {
		public AstExpr ast;
		public AdditiveContext additive;
		public Relational_pContext relational_p;
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public Relational_pContext relational_p() {
			return getRuleContext(Relational_pContext.class,0);
		}
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_relational);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			((RelationalContext)_localctx).additive = additive();
			AstExpr e = ((RelationalContext)_localctx).additive.ast;
			setState(233);
			((RelationalContext)_localctx).relational_p = relational_p(e);

					((RelationalContext)_localctx).ast =  ((RelationalContext)_localctx).relational_p.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relational_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public AdditiveContext additive;
		public TerminalNode SIM_EQU() { return getToken(PrevParser.SIM_EQU, 0); }
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public TerminalNode SIM_NEQU() { return getToken(PrevParser.SIM_NEQU, 0); }
		public TerminalNode SIM_LT() { return getToken(PrevParser.SIM_LT, 0); }
		public TerminalNode SIM_GT() { return getToken(PrevParser.SIM_GT, 0); }
		public TerminalNode SIM_LTEQU() { return getToken(PrevParser.SIM_LTEQU, 0); }
		public TerminalNode SIM_GTEQU() { return getToken(PrevParser.SIM_GTEQU, 0); }
		public Relational_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Relational_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_relational_p; }
	}

	public final Relational_pContext relational_p(AstExpr e) throws RecognitionException {
		Relational_pContext _localctx = new Relational_pContext(_ctx, getState(), e);
		enterRule(_localctx, 30, RULE_relational_p);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_EQU:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(SIM_EQU);
				setState(237);
				((Relational_pContext)_localctx).additive = additive();

						((Relational_pContext)_localctx).ast =  new AstBinExpr(new Location(_localctx.e, ((Relational_pContext)_localctx).additive.ast), AstBinExpr.Oper.EQU, _localctx.e, ((Relational_pContext)_localctx).additive.ast);
					
				}
				break;
			case SIM_NEQU:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(SIM_NEQU);
				setState(241);
				((Relational_pContext)_localctx).additive = additive();

						((Relational_pContext)_localctx).ast =  new AstBinExpr(new Location(_localctx.e, ((Relational_pContext)_localctx).additive.ast), AstBinExpr.Oper.NEQ, _localctx.e, ((Relational_pContext)_localctx).additive.ast);
					
				}
				break;
			case SIM_LT:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				match(SIM_LT);
				setState(245);
				((Relational_pContext)_localctx).additive = additive();

						((Relational_pContext)_localctx).ast =  new AstBinExpr(new Location(_localctx.e, ((Relational_pContext)_localctx).additive.ast), AstBinExpr.Oper.LTH, _localctx.e, ((Relational_pContext)_localctx).additive.ast);
					
				}
				break;
			case SIM_GT:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				match(SIM_GT);
				setState(249);
				((Relational_pContext)_localctx).additive = additive();

						((Relational_pContext)_localctx).ast =  new AstBinExpr(new Location(_localctx.e, ((Relational_pContext)_localctx).additive.ast), AstBinExpr.Oper.GTH, _localctx.e, ((Relational_pContext)_localctx).additive.ast);
					
				}
				break;
			case SIM_LTEQU:
				enterOuterAlt(_localctx, 5);
				{
				setState(252);
				match(SIM_LTEQU);
				setState(253);
				((Relational_pContext)_localctx).additive = additive();

						((Relational_pContext)_localctx).ast =  new AstBinExpr(new Location(_localctx.e, ((Relational_pContext)_localctx).additive.ast), AstBinExpr.Oper.LEQ, _localctx.e, ((Relational_pContext)_localctx).additive.ast);
					
				}
				break;
			case SIM_GTEQU:
				enterOuterAlt(_localctx, 6);
				{
				setState(256);
				match(SIM_GTEQU);
				setState(257);
				((Relational_pContext)_localctx).additive = additive();

						((Relational_pContext)_localctx).ast =  new AstBinExpr(new Location(_localctx.e, ((Relational_pContext)_localctx).additive.ast), AstBinExpr.Oper.GEQ, _localctx.e, ((Relational_pContext)_localctx).additive.ast);
					
				}
				break;
			case EOF:
			case KW_DO:
			case KW_ELSE:
			case KW_FUN:
			case KW_THEN:
			case KW_TYP:
			case KW_VAR:
			case KW_WHERE:
			case SIM_RPAR:
			case SIM_RSQLBR:
			case SIM_RSQRBR:
			case SIM_COM:
			case SIM_COL:
			case SIM_SCOL:
			case SIM_AND:
			case SIM_LINE:
			case SIM_IS:
				enterOuterAlt(_localctx, 7);
				{

						((Relational_pContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveContext extends ParserRuleContext {
		public AstExpr ast;
		public MultiplicativeContext multiplicative;
		public Additive_pContext additive_p;
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public Additive_pContext additive_p() {
			return getRuleContext(Additive_pContext.class,0);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_additive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			((AdditiveContext)_localctx).multiplicative = multiplicative();
			 AstExpr e = ((AdditiveContext)_localctx).multiplicative.ast; 
			setState(265);
			((AdditiveContext)_localctx).additive_p = additive_p(e);

					((AdditiveContext)_localctx).ast =  ((AdditiveContext)_localctx).additive_p.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Additive_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public MultiplicativeContext multiplicative;
		public Additive_pContext additive_p;
		public TerminalNode SIM_PLUS() { return getToken(PrevParser.SIM_PLUS, 0); }
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public Additive_pContext additive_p() {
			return getRuleContext(Additive_pContext.class,0);
		}
		public TerminalNode SIM_MINUS() { return getToken(PrevParser.SIM_MINUS, 0); }
		public Additive_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Additive_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_additive_p; }
	}

	public final Additive_pContext additive_p(AstExpr e) throws RecognitionException {
		Additive_pContext _localctx = new Additive_pContext(_ctx, getState(), e);
		enterRule(_localctx, 34, RULE_additive_p);
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(SIM_PLUS);
				setState(269);
				((Additive_pContext)_localctx).multiplicative = multiplicative();

						AstBinExpr ne = new AstBinExpr(new Location(_localctx.e, ((Additive_pContext)_localctx).multiplicative.ast), AstBinExpr.Oper.ADD, _localctx.e, ((Additive_pContext)_localctx).multiplicative.ast);
					
				setState(271);
				((Additive_pContext)_localctx).additive_p = additive_p(ne);

						((Additive_pContext)_localctx).ast =  ((Additive_pContext)_localctx).additive_p.ast;
					
				}
				break;
			case SIM_MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				match(SIM_MINUS);
				setState(275);
				((Additive_pContext)_localctx).multiplicative = multiplicative();

						AstBinExpr ne = new AstBinExpr(new Location(_localctx.e, ((Additive_pContext)_localctx).multiplicative.ast), AstBinExpr.Oper.SUB, _localctx.e, ((Additive_pContext)_localctx).multiplicative.ast);
					
				setState(277);
				((Additive_pContext)_localctx).additive_p = additive_p(ne);

						((Additive_pContext)_localctx).ast =  ((Additive_pContext)_localctx).additive_p.ast;
					
				}
				break;
			case EOF:
			case KW_DO:
			case KW_ELSE:
			case KW_FUN:
			case KW_THEN:
			case KW_TYP:
			case KW_VAR:
			case KW_WHERE:
			case SIM_RPAR:
			case SIM_RSQLBR:
			case SIM_RSQRBR:
			case SIM_COM:
			case SIM_COL:
			case SIM_SCOL:
			case SIM_AND:
			case SIM_LINE:
			case SIM_EQU:
			case SIM_NEQU:
			case SIM_LT:
			case SIM_GT:
			case SIM_LTEQU:
			case SIM_GTEQU:
			case SIM_IS:
				enterOuterAlt(_localctx, 3);
				{

						((Additive_pContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeContext extends ParserRuleContext {
		public AstExpr ast;
		public PrefixContext prefix;
		public Multiplicative_pContext multiplicative_p;
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public Multiplicative_pContext multiplicative_p() {
			return getRuleContext(Multiplicative_pContext.class,0);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multiplicative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			((MultiplicativeContext)_localctx).prefix = prefix();
			AstExpr e = ((MultiplicativeContext)_localctx).prefix.ast;
			setState(285);
			((MultiplicativeContext)_localctx).multiplicative_p = multiplicative_p(e);

					((MultiplicativeContext)_localctx).ast =  ((MultiplicativeContext)_localctx).multiplicative_p.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiplicative_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public PrefixContext prefix;
		public Multiplicative_pContext multiplicative_p;
		public TerminalNode SIM_STAR() { return getToken(PrevParser.SIM_STAR, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public Multiplicative_pContext multiplicative_p() {
			return getRuleContext(Multiplicative_pContext.class,0);
		}
		public TerminalNode SIM_SLH() { return getToken(PrevParser.SIM_SLH, 0); }
		public TerminalNode SIM_PRCNT() { return getToken(PrevParser.SIM_PRCNT, 0); }
		public Multiplicative_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Multiplicative_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_p; }
	}

	public final Multiplicative_pContext multiplicative_p(AstExpr e) throws RecognitionException {
		Multiplicative_pContext _localctx = new Multiplicative_pContext(_ctx, getState(), e);
		enterRule(_localctx, 38, RULE_multiplicative_p);
		try {
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(SIM_STAR);
				setState(289);
				((Multiplicative_pContext)_localctx).prefix = prefix();

						AstBinExpr ne = new AstBinExpr(new Location(_localctx.e, ((Multiplicative_pContext)_localctx).prefix.ast), AstBinExpr.Oper.MUL, _localctx.e, ((Multiplicative_pContext)_localctx).prefix.ast);
					
				setState(291);
				((Multiplicative_pContext)_localctx).multiplicative_p = multiplicative_p(ne);

						((Multiplicative_pContext)_localctx).ast =  ((Multiplicative_pContext)_localctx).multiplicative_p.ast;
					
				}
				break;
			case SIM_SLH:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(SIM_SLH);
				setState(295);
				((Multiplicative_pContext)_localctx).prefix = prefix();

						AstBinExpr ne = new AstBinExpr(new Location(_localctx.e, ((Multiplicative_pContext)_localctx).prefix.ast), AstBinExpr.Oper.DIV, _localctx.e, ((Multiplicative_pContext)_localctx).prefix.ast);
					
				setState(297);
				((Multiplicative_pContext)_localctx).multiplicative_p = multiplicative_p(ne);

						((Multiplicative_pContext)_localctx).ast =  ((Multiplicative_pContext)_localctx).multiplicative_p.ast;
					
				}
				break;
			case SIM_PRCNT:
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
				match(SIM_PRCNT);
				setState(301);
				((Multiplicative_pContext)_localctx).prefix = prefix();

						AstBinExpr ne = new AstBinExpr(new Location(_localctx.e, ((Multiplicative_pContext)_localctx).prefix.ast), AstBinExpr.Oper.MOD, _localctx.e, ((Multiplicative_pContext)_localctx).prefix.ast);
					
				setState(303);
				((Multiplicative_pContext)_localctx).multiplicative_p = multiplicative_p(ne);

						((Multiplicative_pContext)_localctx).ast =  ((Multiplicative_pContext)_localctx).multiplicative_p.ast;
					
				}
				break;
			case EOF:
			case KW_DO:
			case KW_ELSE:
			case KW_FUN:
			case KW_THEN:
			case KW_TYP:
			case KW_VAR:
			case KW_WHERE:
			case SIM_RPAR:
			case SIM_RSQLBR:
			case SIM_RSQRBR:
			case SIM_COM:
			case SIM_COL:
			case SIM_SCOL:
			case SIM_AND:
			case SIM_LINE:
			case SIM_EQU:
			case SIM_NEQU:
			case SIM_LT:
			case SIM_GT:
			case SIM_LTEQU:
			case SIM_GTEQU:
			case SIM_PLUS:
			case SIM_MINUS:
			case SIM_IS:
				enterOuterAlt(_localctx, 4);
				{

						((Multiplicative_pContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public AstExpr ast;
		public Token SIM_EKSP;
		public PrefixContext prefix;
		public Token SIM_PLUS;
		public Token SIM_MINUS;
		public Token SIM_TOP;
		public Token KW_NEW;
		public Token KW_DEL;
		public PostfixContext postfix;
		public TerminalNode SIM_EKSP() { return getToken(PrevParser.SIM_EKSP, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public TerminalNode SIM_PLUS() { return getToken(PrevParser.SIM_PLUS, 0); }
		public TerminalNode SIM_MINUS() { return getToken(PrevParser.SIM_MINUS, 0); }
		public TerminalNode SIM_TOP() { return getToken(PrevParser.SIM_TOP, 0); }
		public TerminalNode KW_NEW() { return getToken(PrevParser.KW_NEW, 0); }
		public TerminalNode KW_DEL() { return getToken(PrevParser.KW_DEL, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_prefix);
		try {
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_EKSP:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				((PrefixContext)_localctx).SIM_EKSP = match(SIM_EKSP);
				setState(310);
				((PrefixContext)_localctx).prefix = prefix();

						AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)((PrefixContext)_localctx).SIM_EKSP, ((PrefixContext)_localctx).prefix.ast), AstPfxExpr.Oper.NOT, ((PrefixContext)_localctx).prefix.ast);
						((PrefixContext)_localctx).ast =  ne;
					
				}
				break;
			case SIM_PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				((PrefixContext)_localctx).SIM_PLUS = match(SIM_PLUS);
				setState(314);
				((PrefixContext)_localctx).prefix = prefix();

						AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)((PrefixContext)_localctx).SIM_PLUS, ((PrefixContext)_localctx).prefix.ast), AstPfxExpr.Oper.ADD, ((PrefixContext)_localctx).prefix.ast);
						((PrefixContext)_localctx).ast =  ne;
					
				}
				break;
			case SIM_MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				((PrefixContext)_localctx).SIM_MINUS = match(SIM_MINUS);
				setState(318);
				((PrefixContext)_localctx).prefix = prefix();

						AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)((PrefixContext)_localctx).SIM_MINUS, ((PrefixContext)_localctx).prefix.ast), AstPfxExpr.Oper.SUB, ((PrefixContext)_localctx).prefix.ast);
						((PrefixContext)_localctx).ast =  ne;
					
				}
				break;
			case SIM_TOP:
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				((PrefixContext)_localctx).SIM_TOP = match(SIM_TOP);
				setState(322);
				((PrefixContext)_localctx).prefix = prefix();

						AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)((PrefixContext)_localctx).SIM_TOP, ((PrefixContext)_localctx).prefix.ast), AstPfxExpr.Oper.PTR, ((PrefixContext)_localctx).prefix.ast);
						((PrefixContext)_localctx).ast =  ne;
					
				}
				break;
			case KW_NEW:
				enterOuterAlt(_localctx, 5);
				{
				setState(325);
				((PrefixContext)_localctx).KW_NEW = match(KW_NEW);
				setState(326);
				((PrefixContext)_localctx).prefix = prefix();

						AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)((PrefixContext)_localctx).KW_NEW , ((PrefixContext)_localctx).prefix.ast), AstPfxExpr.Oper.NEW , ((PrefixContext)_localctx).prefix.ast);
						((PrefixContext)_localctx).ast =  ne;
					
				}
				break;
			case KW_DEL:
				enterOuterAlt(_localctx, 6);
				{
				setState(329);
				((PrefixContext)_localctx).KW_DEL = match(KW_DEL);
				setState(330);
				((PrefixContext)_localctx).prefix = prefix();

						AstPfxExpr ne = new AstPfxExpr(new Location((PrevToken)((PrefixContext)_localctx).KW_DEL, ((PrefixContext)_localctx).prefix.ast), AstPfxExpr.Oper.DEL, ((PrefixContext)_localctx).prefix.ast);
						((PrefixContext)_localctx).ast =  ne;
					
				}
				break;
			case CONST_CHAR:
			case CONST_STRING:
			case CONST_INTEGER:
			case CONST_LITERAL:
			case CONST_BOOLEAN:
			case CONST_VOID:
			case IDENTIFIER:
			case SIM_LPAR:
			case SIM_LSQLBR:
				enterOuterAlt(_localctx, 7);
				{
				setState(333);
				((PrefixContext)_localctx).postfix = postfix();

						((PrefixContext)_localctx).ast =  ((PrefixContext)_localctx).postfix.ast;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public AstExpr ast;
		public ExprContext expr;
		public Postfix_pContext postfix_p;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Postfix_pContext postfix_p() {
			return getRuleContext(Postfix_pContext.class,0);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_postfix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			((PostfixContext)_localctx).expr = expr();
			AstExpr e = ((PostfixContext)_localctx).expr.ast;
			setState(340);
			((PostfixContext)_localctx).postfix_p = postfix_p(e);

					((PostfixContext)_localctx).ast =  ((PostfixContext)_localctx).postfix_p.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public Declaration_binderContext declaration_binder;
		public Token SIM_RSQRBR;
		public Postfix_pContext postfix_p;
		public Token SIM_TOP;
		public Token IDENTIFIER;
		public TerminalNode SIM_LSQRBR() { return getToken(PrevParser.SIM_LSQRBR, 0); }
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public TerminalNode SIM_RSQRBR() { return getToken(PrevParser.SIM_RSQRBR, 0); }
		public Postfix_pContext postfix_p() {
			return getRuleContext(Postfix_pContext.class,0);
		}
		public TerminalNode SIM_TOP() { return getToken(PrevParser.SIM_TOP, 0); }
		public TerminalNode SIM_DOT() { return getToken(PrevParser.SIM_DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PrevParser.IDENTIFIER, 0); }
		public Postfix_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Postfix_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_postfix_p; }
	}

	public final Postfix_pContext postfix_p(AstExpr e) throws RecognitionException {
		Postfix_pContext _localctx = new Postfix_pContext(_ctx, getState(), e);
		enterRule(_localctx, 44, RULE_postfix_p);
		try {
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_LSQRBR:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				match(SIM_LSQRBR);
				setState(344);
				((Postfix_pContext)_localctx).declaration_binder = declaration_binder();
				setState(345);
				((Postfix_pContext)_localctx).SIM_RSQRBR = match(SIM_RSQRBR);

						AstArrExpr ne = new AstArrExpr (new Location(_localctx.e, (PrevToken)((Postfix_pContext)_localctx).SIM_RSQRBR), _localctx.e, ((Postfix_pContext)_localctx).declaration_binder.ast);
					
				setState(347);
				((Postfix_pContext)_localctx).postfix_p = postfix_p(ne);

						((Postfix_pContext)_localctx).ast =  ((Postfix_pContext)_localctx).postfix_p.ast;
					
				}
				break;
			case SIM_TOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				((Postfix_pContext)_localctx).SIM_TOP = match(SIM_TOP);
				AstSfxExpr ne = new AstSfxExpr (new Location(_localctx.e, (PrevToken)((Postfix_pContext)_localctx).SIM_TOP), AstSfxExpr.Oper.PTR, _localctx.e);
				setState(352);
				((Postfix_pContext)_localctx).postfix_p = postfix_p(ne);

						((Postfix_pContext)_localctx).ast =  ((Postfix_pContext)_localctx).postfix_p.ast;
					
				}
				break;
			case SIM_DOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				match(SIM_DOT);
				setState(356);
				((Postfix_pContext)_localctx).IDENTIFIER = match(IDENTIFIER);

						AstNameExpr ne1 = new AstNameExpr(new Location(_localctx.e, (PrevToken)((Postfix_pContext)_localctx).IDENTIFIER), (((Postfix_pContext)_localctx).IDENTIFIER!=null?((Postfix_pContext)_localctx).IDENTIFIER.getText():null));
						AstRecExpr ne2 = new AstRecExpr(new Location(_localctx.e, (PrevToken)((Postfix_pContext)_localctx).IDENTIFIER), _localctx.e, ne1);
					
				setState(358);
				((Postfix_pContext)_localctx).postfix_p = postfix_p(ne2);

						((Postfix_pContext)_localctx).ast =  ((Postfix_pContext)_localctx).postfix_p.ast;
					
				}
				break;
			case EOF:
			case KW_DO:
			case KW_ELSE:
			case KW_FUN:
			case KW_THEN:
			case KW_TYP:
			case KW_VAR:
			case KW_WHERE:
			case SIM_RPAR:
			case SIM_RSQLBR:
			case SIM_RSQRBR:
			case SIM_COM:
			case SIM_COL:
			case SIM_SCOL:
			case SIM_AND:
			case SIM_LINE:
			case SIM_EQU:
			case SIM_NEQU:
			case SIM_LT:
			case SIM_GT:
			case SIM_LTEQU:
			case SIM_GTEQU:
			case SIM_STAR:
			case SIM_SLH:
			case SIM_PRCNT:
			case SIM_PLUS:
			case SIM_MINUS:
			case SIM_IS:
				enterOuterAlt(_localctx, 4);
				{

						((Postfix_pContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AstExpr ast;
		public Token CONST_CHAR;
		public Token CONST_STRING;
		public Token CONST_INTEGER;
		public Token CONST_LITERAL;
		public Token CONST_BOOLEAN;
		public Token CONST_VOID;
		public Token IDENTIFIER;
		public Expr_pContext expr_p;
		public Token SIM_LSQLBR;
		public StmntContext stmnt;
		public Stmnt_argsContext stmnt_args;
		public Token SIM_RSQLBR;
		public Declaration_binderContext declaration_binder;
		public Expr_ppContext expr_pp;
		public TerminalNode CONST_CHAR() { return getToken(PrevParser.CONST_CHAR, 0); }
		public TerminalNode CONST_STRING() { return getToken(PrevParser.CONST_STRING, 0); }
		public TerminalNode CONST_INTEGER() { return getToken(PrevParser.CONST_INTEGER, 0); }
		public TerminalNode CONST_LITERAL() { return getToken(PrevParser.CONST_LITERAL, 0); }
		public TerminalNode CONST_BOOLEAN() { return getToken(PrevParser.CONST_BOOLEAN, 0); }
		public TerminalNode CONST_VOID() { return getToken(PrevParser.CONST_VOID, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PrevParser.IDENTIFIER, 0); }
		public Expr_pContext expr_p() {
			return getRuleContext(Expr_pContext.class,0);
		}
		public TerminalNode SIM_LSQLBR() { return getToken(PrevParser.SIM_LSQLBR, 0); }
		public StmntContext stmnt() {
			return getRuleContext(StmntContext.class,0);
		}
		public TerminalNode SIM_SCOL() { return getToken(PrevParser.SIM_SCOL, 0); }
		public Stmnt_argsContext stmnt_args() {
			return getRuleContext(Stmnt_argsContext.class,0);
		}
		public TerminalNode SIM_RSQLBR() { return getToken(PrevParser.SIM_RSQLBR, 0); }
		public TerminalNode SIM_LPAR() { return getToken(PrevParser.SIM_LPAR, 0); }
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public Expr_ppContext expr_pp() {
			return getRuleContext(Expr_ppContext.class,0);
		}
		public TerminalNode SIM_RPAR() { return getToken(PrevParser.SIM_RPAR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr);
		try {
			setState(394);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				((ExprContext)_localctx).CONST_CHAR = match(CONST_CHAR);

						((ExprContext)_localctx).ast =  new AstAtomExpr(new Location((PrevToken)((ExprContext)_localctx).CONST_CHAR), AstAtomExpr.Type.CHAR, (((ExprContext)_localctx).CONST_CHAR!=null?((ExprContext)_localctx).CONST_CHAR.getText():null));
					
				}
				break;
			case CONST_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				((ExprContext)_localctx).CONST_STRING = match(CONST_STRING);

						((ExprContext)_localctx).ast =  new AstAtomExpr(new Location((PrevToken)((ExprContext)_localctx).CONST_STRING), AstAtomExpr.Type.STRING, (((ExprContext)_localctx).CONST_STRING!=null?((ExprContext)_localctx).CONST_STRING.getText():null));
					
				}
				break;
			case CONST_INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(368);
				((ExprContext)_localctx).CONST_INTEGER = match(CONST_INTEGER);

						((ExprContext)_localctx).ast =  new AstAtomExpr(new Location((PrevToken)((ExprContext)_localctx).CONST_INTEGER), AstAtomExpr.Type.INTEGER, (((ExprContext)_localctx).CONST_INTEGER!=null?((ExprContext)_localctx).CONST_INTEGER.getText():null));
					
				}
				break;
			case CONST_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				((ExprContext)_localctx).CONST_LITERAL = match(CONST_LITERAL);

						((ExprContext)_localctx).ast =  new AstAtomExpr(new Location((PrevToken)((ExprContext)_localctx).CONST_LITERAL), AstAtomExpr.Type.POINTER, (((ExprContext)_localctx).CONST_LITERAL!=null?((ExprContext)_localctx).CONST_LITERAL.getText():null));
					
				}
				break;
			case CONST_BOOLEAN:
				enterOuterAlt(_localctx, 5);
				{
				setState(372);
				((ExprContext)_localctx).CONST_BOOLEAN = match(CONST_BOOLEAN);

						((ExprContext)_localctx).ast =  new AstAtomExpr(new Location((PrevToken)((ExprContext)_localctx).CONST_BOOLEAN), AstAtomExpr.Type.BOOLEAN, (((ExprContext)_localctx).CONST_BOOLEAN!=null?((ExprContext)_localctx).CONST_BOOLEAN.getText():null));
					
				}
				break;
			case CONST_VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(374);
				((ExprContext)_localctx).CONST_VOID = match(CONST_VOID);

						((ExprContext)_localctx).ast =  new AstAtomExpr(new Location((PrevToken)((ExprContext)_localctx).CONST_VOID), AstAtomExpr.Type.VOID, (((ExprContext)_localctx).CONST_VOID!=null?((ExprContext)_localctx).CONST_VOID.getText():null));
					
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 7);
				{
				setState(376);
				((ExprContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(377);
				((ExprContext)_localctx).expr_p = expr_p((((ExprContext)_localctx).IDENTIFIER!=null?((ExprContext)_localctx).IDENTIFIER.getText():null), (PrevToken)((ExprContext)_localctx).IDENTIFIER);

						if (((ExprContext)_localctx).expr_p.ast instanceof AstCallExpr){
							((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr_p.ast;
						}
						else {
							((ExprContext)_localctx).ast =  new AstNameExpr(new Location((PrevToken)((ExprContext)_localctx).IDENTIFIER), (((ExprContext)_localctx).IDENTIFIER!=null?((ExprContext)_localctx).IDENTIFIER.getText():null));
						}
					
				}
				break;
			case SIM_LSQLBR:
				enterOuterAlt(_localctx, 8);
				{
				setState(380);
				((ExprContext)_localctx).SIM_LSQLBR = match(SIM_LSQLBR);
				setState(381);
				((ExprContext)_localctx).stmnt = stmnt();
				setState(382);
				match(SIM_SCOL);
				setState(383);
				((ExprContext)_localctx).stmnt_args = stmnt_args();
				setState(384);
				((ExprContext)_localctx).SIM_RSQLBR = match(SIM_RSQLBR);

						Vector<AstStmt> s = new Vector<AstStmt>();
						s.add(((ExprContext)_localctx).stmnt.ast);
						s.addAll(((ExprContext)_localctx).stmnt_args.ast);
						((ExprContext)_localctx).ast =  new AstStmtExpr(new Location((PrevToken)((ExprContext)_localctx).SIM_LSQLBR, (PrevToken)((ExprContext)_localctx).SIM_RSQLBR), new AstTrees<AstStmt>(s));
					
				}
				break;
			case SIM_LPAR:
				enterOuterAlt(_localctx, 9);
				{
				setState(387);
				match(SIM_LPAR);
				setState(388);
				((ExprContext)_localctx).declaration_binder = declaration_binder();
				AstExpr e = ((ExprContext)_localctx).declaration_binder.ast;
				setState(390);
				((ExprContext)_localctx).expr_pp = expr_pp(e);
				setState(391);
				match(SIM_RPAR);

						if (((ExprContext)_localctx).expr_pp.ast instanceof AstCastExpr){
							((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr_pp.ast;
						}
						else {
							((ExprContext)_localctx).ast =  ((ExprContext)_localctx).declaration_binder.ast;
						}
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_pContext extends ParserRuleContext {
		public String s;
		public PrevToken identifier;
		public AstExpr ast;
		public Declaration_binderContext declaration_binder;
		public Expr_argsContext expr_args;
		public Token SIM_RPAR;
		public TerminalNode SIM_LPAR() { return getToken(PrevParser.SIM_LPAR, 0); }
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public Expr_argsContext expr_args() {
			return getRuleContext(Expr_argsContext.class,0);
		}
		public TerminalNode SIM_RPAR() { return getToken(PrevParser.SIM_RPAR, 0); }
		public Expr_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_pContext(ParserRuleContext parent, int invokingState, String s, PrevToken identifier) {
			super(parent, invokingState);
			this.s = s;
			this.identifier = identifier;
		}
		@Override public int getRuleIndex() { return RULE_expr_p; }
	}

	public final Expr_pContext expr_p(String s,PrevToken identifier) throws RecognitionException {
		Expr_pContext _localctx = new Expr_pContext(_ctx, getState(), s, identifier);
		enterRule(_localctx, 48, RULE_expr_p);
		try {
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{

						((Expr_pContext)_localctx).ast =  null;
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				match(SIM_LPAR);
				setState(398);
				((Expr_pContext)_localctx).declaration_binder = declaration_binder();
				setState(399);
				((Expr_pContext)_localctx).expr_args = expr_args();
				setState(400);
				((Expr_pContext)_localctx).SIM_RPAR = match(SIM_RPAR);

						Vector<AstExpr> a = new Vector<AstExpr>();
						a.add(((Expr_pContext)_localctx).declaration_binder.ast);
						a.addAll(((Expr_pContext)_localctx).expr_args.ast);
						AstTrees na = new AstTrees<AstExpr>(a);
						((Expr_pContext)_localctx).ast =  new AstCallExpr(new Location(identifier, (PrevToken)((Expr_pContext)_localctx).SIM_RPAR), s, na);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(SIM_LPAR);
				setState(404);
				((Expr_pContext)_localctx).SIM_RPAR = match(SIM_RPAR);

						((Expr_pContext)_localctx).ast =  new AstCallExpr(new Location(identifier, (PrevToken)((Expr_pContext)_localctx).SIM_RPAR), s, new AstTrees<AstExpr>());
					
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_ppContext extends ParserRuleContext {
		public AstExpr e;
		public AstExpr ast;
		public TypeContext type;
		public TerminalNode SIM_COL() { return getToken(PrevParser.SIM_COL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Expr_ppContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_ppContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_expr_pp; }
	}

	public final Expr_ppContext expr_pp(AstExpr e) throws RecognitionException {
		Expr_ppContext _localctx = new Expr_ppContext(_ctx, getState(), e);
		enterRule(_localctx, 50, RULE_expr_pp);
		try {
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_COL:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(SIM_COL);
				setState(409);
				((Expr_ppContext)_localctx).type = type();

						((Expr_ppContext)_localctx).ast =  new AstCastExpr(new Location(_localctx.e, ((Expr_ppContext)_localctx).type.ast), _localctx.e, ((Expr_ppContext)_localctx).type.ast);
					
				}
				break;
			case SIM_RPAR:
				enterOuterAlt(_localctx, 2);
				{

						((Expr_ppContext)_localctx).ast =  _localctx.e;
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_argsContext extends ParserRuleContext {
		public Vector<AstExpr> ast;
		public Declaration_binderContext declaration_binder;
		public Expr_argsContext expr_args;
		public TerminalNode SIM_COM() { return getToken(PrevParser.SIM_COM, 0); }
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public Expr_argsContext expr_args() {
			return getRuleContext(Expr_argsContext.class,0);
		}
		public Expr_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_args; }
	}

	public final Expr_argsContext expr_args() throws RecognitionException {
		Expr_argsContext _localctx = new Expr_argsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr_args);
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIM_COM:
				enterOuterAlt(_localctx, 1);
				{
				setState(415);
				match(SIM_COM);
				setState(416);
				((Expr_argsContext)_localctx).declaration_binder = declaration_binder();
				setState(417);
				((Expr_argsContext)_localctx).expr_args = expr_args();

						Vector<AstExpr> a = new Vector<AstExpr>();
						a.add(((Expr_argsContext)_localctx).declaration_binder.ast);
						a.addAll(((Expr_argsContext)_localctx).expr_args.ast);
						((Expr_argsContext)_localctx).ast =  a;
					
				}
				break;
			case SIM_RPAR:
				enterOuterAlt(_localctx, 2);
				{

						((Expr_argsContext)_localctx).ast =  new Vector<AstExpr>();
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmnt_argsContext extends ParserRuleContext {
		public Vector<AstStmt> ast;
		public StmntContext stmnt;
		public Stmnt_argsContext stmnt_args;
		public StmntContext stmnt() {
			return getRuleContext(StmntContext.class,0);
		}
		public TerminalNode SIM_SCOL() { return getToken(PrevParser.SIM_SCOL, 0); }
		public Stmnt_argsContext stmnt_args() {
			return getRuleContext(Stmnt_argsContext.class,0);
		}
		public Stmnt_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmnt_args; }
	}

	public final Stmnt_argsContext stmnt_args() throws RecognitionException {
		Stmnt_argsContext _localctx = new Stmnt_argsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stmnt_args);
		try {
			setState(429);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_CHAR:
			case CONST_STRING:
			case CONST_INTEGER:
			case CONST_LITERAL:
			case KW_DEL:
			case KW_IF:
			case KW_NEW:
			case KW_WHILE:
			case CONST_BOOLEAN:
			case CONST_VOID:
			case IDENTIFIER:
			case SIM_LPAR:
			case SIM_LSQLBR:
			case SIM_EKSP:
			case SIM_PLUS:
			case SIM_MINUS:
			case SIM_TOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				((Stmnt_argsContext)_localctx).stmnt = stmnt();
				setState(424);
				match(SIM_SCOL);
				setState(425);
				((Stmnt_argsContext)_localctx).stmnt_args = stmnt_args();

						Vector<AstStmt> s = new Vector<AstStmt>();
						s.add(((Stmnt_argsContext)_localctx).stmnt.ast);
						s.addAll(((Stmnt_argsContext)_localctx).stmnt_args.ast);
						((Stmnt_argsContext)_localctx).ast =  s;
					
				}
				break;
			case SIM_RSQLBR:
				enterOuterAlt(_localctx, 2);
				{

						((Stmnt_argsContext)_localctx).ast =  new Vector<AstStmt>();
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmntContext extends ParserRuleContext {
		public AstStmt ast;
		public Declaration_binderContext declaration_binder;
		public Stmnt_pContext stmnt_p;
		public Token KW_IF;
		public StmntContext s1;
		public StmntContext s2;
		public Token KW_WHILE;
		public StmntContext stmnt;
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public Stmnt_pContext stmnt_p() {
			return getRuleContext(Stmnt_pContext.class,0);
		}
		public TerminalNode KW_IF() { return getToken(PrevParser.KW_IF, 0); }
		public TerminalNode KW_THEN() { return getToken(PrevParser.KW_THEN, 0); }
		public TerminalNode KW_ELSE() { return getToken(PrevParser.KW_ELSE, 0); }
		public List<StmntContext> stmnt() {
			return getRuleContexts(StmntContext.class);
		}
		public StmntContext stmnt(int i) {
			return getRuleContext(StmntContext.class,i);
		}
		public TerminalNode KW_WHILE() { return getToken(PrevParser.KW_WHILE, 0); }
		public TerminalNode KW_DO() { return getToken(PrevParser.KW_DO, 0); }
		public StmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmnt; }
	}

	public final StmntContext stmnt() throws RecognitionException {
		StmntContext _localctx = new StmntContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_stmnt);
		try {
			setState(450);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_CHAR:
			case CONST_STRING:
			case CONST_INTEGER:
			case CONST_LITERAL:
			case KW_DEL:
			case KW_NEW:
			case CONST_BOOLEAN:
			case CONST_VOID:
			case IDENTIFIER:
			case SIM_LPAR:
			case SIM_LSQLBR:
			case SIM_EKSP:
			case SIM_PLUS:
			case SIM_MINUS:
			case SIM_TOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				((StmntContext)_localctx).declaration_binder = declaration_binder();
				AstExpr e = ((StmntContext)_localctx).declaration_binder.ast;
				setState(433);
				((StmntContext)_localctx).stmnt_p = stmnt_p(e);

						((StmntContext)_localctx).ast =  ((StmntContext)_localctx).stmnt_p.ast;
					
				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				((StmntContext)_localctx).KW_IF = match(KW_IF);
				setState(437);
				((StmntContext)_localctx).declaration_binder = declaration_binder();
				setState(438);
				match(KW_THEN);
				setState(439);
				((StmntContext)_localctx).s1 = stmnt();
				setState(440);
				match(KW_ELSE);
				setState(441);
				((StmntContext)_localctx).s2 = stmnt();

						((StmntContext)_localctx).ast =  new AstIfStmt(new Location((PrevToken)((StmntContext)_localctx).KW_IF, ((StmntContext)_localctx).s2.ast), ((StmntContext)_localctx).declaration_binder.ast, ((StmntContext)_localctx).s1.ast, ((StmntContext)_localctx).s2.ast);
					
				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(444);
				((StmntContext)_localctx).KW_WHILE = match(KW_WHILE);
				setState(445);
				((StmntContext)_localctx).declaration_binder = declaration_binder();
				setState(446);
				match(KW_DO);
				setState(447);
				((StmntContext)_localctx).stmnt = stmnt();

						((StmntContext)_localctx).ast =  new AstWhileStmt(new Location((PrevToken)((StmntContext)_localctx).KW_WHILE, ((StmntContext)_localctx).stmnt.ast), ((StmntContext)_localctx).declaration_binder.ast, ((StmntContext)_localctx).stmnt.ast);
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmnt_pContext extends ParserRuleContext {
		public AstExpr e;
		public AstStmt ast;
		public Declaration_binderContext declaration_binder;
		public TerminalNode SIM_IS() { return getToken(PrevParser.SIM_IS, 0); }
		public Declaration_binderContext declaration_binder() {
			return getRuleContext(Declaration_binderContext.class,0);
		}
		public Stmnt_pContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Stmnt_pContext(ParserRuleContext parent, int invokingState, AstExpr e) {
			super(parent, invokingState);
			this.e = e;
		}
		@Override public int getRuleIndex() { return RULE_stmnt_p; }
	}

	public final Stmnt_pContext stmnt_p(AstExpr e) throws RecognitionException {
		Stmnt_pContext _localctx = new Stmnt_pContext(_ctx, getState(), e);
		enterRule(_localctx, 58, RULE_stmnt_p);
		try {
			setState(457);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE:
			case SIM_SCOL:
				enterOuterAlt(_localctx, 1);
				{

						((Stmnt_pContext)_localctx).ast =  new AstExprStmt(new Location(_localctx.e), _localctx.e);
					
				}
				break;
			case SIM_IS:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				match(SIM_IS);
				setState(454);
				((Stmnt_pContext)_localctx).declaration_binder = declaration_binder();

						((Stmnt_pContext)_localctx).ast =  new AstAssignStmt(new Location(_localctx.e, ((Stmnt_pContext)_localctx).declaration_binder.ast), _localctx.e, ((Stmnt_pContext)_localctx).declaration_binder.ast);
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u01ce\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3I\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4b\n"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5k\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6u\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a7"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00b1\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u00bb\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00cc\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00da\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00e8\n\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0108\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u011c\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0136\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0153\n\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u016d\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u018d\n\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0199\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u01a0\n\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u01a8\n\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\5\35\u01b0\n\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u01c5\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u01cc\n\37\3\37\2\2 \2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\2\2\u01e4"+
		"\2>\3\2\2\2\4H\3\2\2\2\6a\3\2\2\2\bj\3\2\2\2\nt\3\2\2\2\f\u00a6\3\2\2"+
		"\2\16\u00b0\3\2\2\2\20\u00ba\3\2\2\2\22\u00bc\3\2\2\2\24\u00cb\3\2\2\2"+
		"\26\u00cd\3\2\2\2\30\u00d9\3\2\2\2\32\u00db\3\2\2\2\34\u00e7\3\2\2\2\36"+
		"\u00e9\3\2\2\2 \u0107\3\2\2\2\"\u0109\3\2\2\2$\u011b\3\2\2\2&\u011d\3"+
		"\2\2\2(\u0135\3\2\2\2*\u0152\3\2\2\2,\u0154\3\2\2\2.\u016c\3\2\2\2\60"+
		"\u018c\3\2\2\2\62\u0198\3\2\2\2\64\u019f\3\2\2\2\66\u01a7\3\2\2\28\u01af"+
		"\3\2\2\2:\u01c4\3\2\2\2<\u01cb\3\2\2\2>?\5\6\4\2?@\5\4\3\2@A\7\2\2\3A"+
		"B\b\2\1\2B\3\3\2\2\2CD\5\6\4\2DE\5\4\3\2EF\b\3\1\2FI\3\2\2\2GI\b\3\1\2"+
		"HC\3\2\2\2HG\3\2\2\2I\5\3\2\2\2JK\7\22\2\2KL\7\31\2\2LM\7\63\2\2MN\5\f"+
		"\7\2NO\b\4\1\2Ob\3\2\2\2PQ\7\23\2\2QR\7\31\2\2RS\7\"\2\2ST\5\f\7\2TU\b"+
		"\4\1\2Ub\3\2\2\2VW\7\r\2\2WX\7\31\2\2XY\7\32\2\2YZ\5\b\5\2Z[\7\33\2\2"+
		"[\\\7\"\2\2\\]\5\f\7\2]^\7\63\2\2^_\5\22\n\2_`\b\4\1\2`b\3\2\2\2aJ\3\2"+
		"\2\2aP\3\2\2\2aV\3\2\2\2b\7\3\2\2\2ck\b\5\1\2de\7\31\2\2ef\7\"\2\2fg\5"+
		"\f\7\2gh\5\n\6\2hi\b\5\1\2ik\3\2\2\2jc\3\2\2\2jd\3\2\2\2k\t\3\2\2\2lm"+
		"\7!\2\2mn\7\31\2\2no\7\"\2\2op\5\f\7\2pq\5\n\6\2qr\b\6\1\2ru\3\2\2\2s"+
		"u\b\6\1\2tl\3\2\2\2ts\3\2\2\2u\13\3\2\2\2vw\7\b\2\2wx\b\7\1\2xy\5\16\b"+
		"\2yz\b\7\1\2z\u00a7\3\2\2\2{|\7\t\2\2|}\b\7\1\2}~\5\16\b\2~\177\b\7\1"+
		"\2\177\u00a7\3\2\2\2\u0080\u0081\7\17\2\2\u0081\u0082\b\7\1\2\u0082\u0083"+
		"\5\16\b\2\u0083\u0084\b\7\1\2\u0084\u00a7\3\2\2\2\u0085\u0086\7\24\2\2"+
		"\u0086\u0087\b\7\1\2\u0087\u0088\5\16\b\2\u0088\u0089\b\7\1\2\u0089\u00a7"+
		"\3\2\2\2\u008a\u008b\7\31\2\2\u008b\u008c\b\7\1\2\u008c\u008d\5\16\b\2"+
		"\u008d\u008e\b\7\1\2\u008e\u00a7\3\2\2\2\u008f\u0090\7\62\2\2\u0090\u0091"+
		"\5\f\7\2\u0091\u0092\b\7\1\2\u0092\u0093\5\16\b\2\u0093\u0094\b\7\1\2"+
		"\u0094\u00a7\3\2\2\2\u0095\u0096\7\34\2\2\u0096\u0097\7\31\2\2\u0097\u0098"+
		"\7\"\2\2\u0098\u0099\5\f\7\2\u0099\u009a\5\20\t\2\u009a\u009b\7\35\2\2"+
		"\u009b\u009c\b\7\1\2\u009c\u009d\5\16\b\2\u009d\u009e\b\7\1\2\u009e\u00a7"+
		"\3\2\2\2\u009f\u00a0\7\32\2\2\u00a0\u00a1\5\f\7\2\u00a1\u00a2\7\33\2\2"+
		"\u00a2\u00a3\b\7\1\2\u00a3\u00a4\5\16\b\2\u00a4\u00a5\b\7\1\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6v\3\2\2\2\u00a6{\3\2\2\2\u00a6\u0080\3\2\2\2\u00a6\u0085"+
		"\3\2\2\2\u00a6\u008a\3\2\2\2\u00a6\u008f\3\2\2\2\u00a6\u0095\3\2\2\2\u00a6"+
		"\u009f\3\2\2\2\u00a7\r\3\2\2\2\u00a8\u00a9\7\36\2\2\u00a9\u00aa\5\22\n"+
		"\2\u00aa\u00ab\7\37\2\2\u00ab\u00ac\b\b\1\2\u00ac\u00ad\5\16\b\2\u00ad"+
		"\u00ae\b\b\1\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\b\b\1\2\u00b0\u00a8\3\2"+
		"\2\2\u00b0\u00af\3\2\2\2\u00b1\17\3\2\2\2\u00b2\u00b3\7!\2\2\u00b3\u00b4"+
		"\7\31\2\2\u00b4\u00b5\7\"\2\2\u00b5\u00b6\5\f\7\2\u00b6\u00b7\5\20\t\2"+
		"\u00b7\u00b8\b\t\1\2\u00b8\u00bb\3\2\2\2\u00b9\u00bb\b\t\1\2\u00ba\u00b2"+
		"\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\21\3\2\2\2\u00bc\u00bd\5\26\f\2\u00bd"+
		"\u00be\b\n\1\2\u00be\u00bf\5\24\13\2\u00bf\u00c0\b\n\1\2\u00c0\23\3\2"+
		"\2\2\u00c1\u00c2\7\25\2\2\u00c2\u00c3\7\34\2\2\u00c3\u00c4\5\6\4\2\u00c4"+
		"\u00c5\5\4\3\2\u00c5\u00c6\7\35\2\2\u00c6\u00c7\b\13\1\2\u00c7\u00c8\5"+
		"\24\13\2\u00c8\u00c9\b\13\1\2\u00c9\u00cc\3\2\2\2\u00ca\u00cc\b\13\1\2"+
		"\u00cb\u00c1\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\25\3\2\2\2\u00cd\u00ce"+
		"\5\32\16\2\u00ce\u00cf\b\f\1\2\u00cf\u00d0\5\30\r\2\u00d0\u00d1\b\f\1"+
		"\2\u00d1\27\3\2\2\2\u00d2\u00d3\7%\2\2\u00d3\u00d4\5\32\16\2\u00d4\u00d5"+
		"\b\r\1\2\u00d5\u00d6\5\30\r\2\u00d6\u00d7\b\r\1\2\u00d7\u00da\3\2\2\2"+
		"\u00d8\u00da\b\r\1\2\u00d9\u00d2\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\31"+
		"\3\2\2\2\u00db\u00dc\5\36\20\2\u00dc\u00dd\b\16\1\2\u00dd\u00de\5\34\17"+
		"\2\u00de\u00df\b\16\1\2\u00df\33\3\2\2\2\u00e0\u00e1\7$\2\2\u00e1\u00e2"+
		"\5\36\20\2\u00e2\u00e3\b\17\1\2\u00e3\u00e4\5\34\17\2\u00e4\u00e5\b\17"+
		"\1\2\u00e5\u00e8\3\2\2\2\u00e6\u00e8\b\17\1\2\u00e7\u00e0\3\2\2\2\u00e7"+
		"\u00e6\3\2\2\2\u00e8\35\3\2\2\2\u00e9\u00ea\5\"\22\2\u00ea\u00eb\b\20"+
		"\1\2\u00eb\u00ec\5 \21\2\u00ec\u00ed\b\20\1\2\u00ed\37\3\2\2\2\u00ee\u00ef"+
		"\7\'\2\2\u00ef\u00f0\5\"\22\2\u00f0\u00f1\b\21\1\2\u00f1\u0108\3\2\2\2"+
		"\u00f2\u00f3\7(\2\2\u00f3\u00f4\5\"\22\2\u00f4\u00f5\b\21\1\2\u00f5\u0108"+
		"\3\2\2\2\u00f6\u00f7\7)\2\2\u00f7\u00f8\5\"\22\2\u00f8\u00f9\b\21\1\2"+
		"\u00f9\u0108\3\2\2\2\u00fa\u00fb\7*\2\2\u00fb\u00fc\5\"\22\2\u00fc\u00fd"+
		"\b\21\1\2\u00fd\u0108\3\2\2\2\u00fe\u00ff\7+\2\2\u00ff\u0100\5\"\22\2"+
		"\u0100\u0101\b\21\1\2\u0101\u0108\3\2\2\2\u0102\u0103\7,\2\2\u0103\u0104"+
		"\5\"\22\2\u0104\u0105\b\21\1\2\u0105\u0108\3\2\2\2\u0106\u0108\b\21\1"+
		"\2\u0107\u00ee\3\2\2\2\u0107\u00f2\3\2\2\2\u0107\u00f6\3\2\2\2\u0107\u00fa"+
		"\3\2\2\2\u0107\u00fe\3\2\2\2\u0107\u0102\3\2\2\2\u0107\u0106\3\2\2\2\u0108"+
		"!\3\2\2\2\u0109\u010a\5&\24\2\u010a\u010b\b\22\1\2\u010b\u010c\5$\23\2"+
		"\u010c\u010d\b\22\1\2\u010d#\3\2\2\2\u010e\u010f\7\60\2\2\u010f\u0110"+
		"\5&\24\2\u0110\u0111\b\23\1\2\u0111\u0112\5$\23\2\u0112\u0113\b\23\1\2"+
		"\u0113\u011c\3\2\2\2\u0114\u0115\7\61\2\2\u0115\u0116\5&\24\2\u0116\u0117"+
		"\b\23\1\2\u0117\u0118\5$\23\2\u0118\u0119\b\23\1\2\u0119\u011c\3\2\2\2"+
		"\u011a\u011c\b\23\1\2\u011b\u010e\3\2\2\2\u011b\u0114\3\2\2\2\u011b\u011a"+
		"\3\2\2\2\u011c%\3\2\2\2\u011d\u011e\5*\26\2\u011e\u011f\b\24\1\2\u011f"+
		"\u0120\5(\25\2\u0120\u0121\b\24\1\2\u0121\'\3\2\2\2\u0122\u0123\7-\2\2"+
		"\u0123\u0124\5*\26\2\u0124\u0125\b\25\1\2\u0125\u0126\5(\25\2\u0126\u0127"+
		"\b\25\1\2\u0127\u0136\3\2\2\2\u0128\u0129\7.\2\2\u0129\u012a\5*\26\2\u012a"+
		"\u012b\b\25\1\2\u012b\u012c\5(\25\2\u012c\u012d\b\25\1\2\u012d\u0136\3"+
		"\2\2\2\u012e\u012f\7/\2\2\u012f\u0130\5*\26\2\u0130\u0131\b\25\1\2\u0131"+
		"\u0132\5(\25\2\u0132\u0133\b\25\1\2\u0133\u0136\3\2\2\2\u0134\u0136\b"+
		"\25\1\2\u0135\u0122\3\2\2\2\u0135\u0128\3\2\2\2\u0135\u012e\3\2\2\2\u0135"+
		"\u0134\3\2\2\2\u0136)\3\2\2\2\u0137\u0138\7&\2\2\u0138\u0139\5*\26\2\u0139"+
		"\u013a\b\26\1\2\u013a\u0153\3\2\2\2\u013b\u013c\7\60\2\2\u013c\u013d\5"+
		"*\26\2\u013d\u013e\b\26\1\2\u013e\u0153\3\2\2\2\u013f\u0140\7\61\2\2\u0140"+
		"\u0141\5*\26\2\u0141\u0142\b\26\1\2\u0142\u0153\3\2\2\2\u0143\u0144\7"+
		"\62\2\2\u0144\u0145\5*\26\2\u0145\u0146\b\26\1\2\u0146\u0153\3\2\2\2\u0147"+
		"\u0148\7\20\2\2\u0148\u0149\5*\26\2\u0149\u014a\b\26\1\2\u014a\u0153\3"+
		"\2\2\2\u014b\u014c\7\n\2\2\u014c\u014d\5*\26\2\u014d\u014e\b\26\1\2\u014e"+
		"\u0153\3\2\2\2\u014f\u0150\5,\27\2\u0150\u0151\b\26\1\2\u0151\u0153\3"+
		"\2\2\2\u0152\u0137\3\2\2\2\u0152\u013b\3\2\2\2\u0152\u013f\3\2\2\2\u0152"+
		"\u0143\3\2\2\2\u0152\u0147\3\2\2\2\u0152\u014b\3\2\2\2\u0152\u014f\3\2"+
		"\2\2\u0153+\3\2\2\2\u0154\u0155\5\60\31\2\u0155\u0156\b\27\1\2\u0156\u0157"+
		"\5.\30\2\u0157\u0158\b\27\1\2\u0158-\3\2\2\2\u0159\u015a\7\36\2\2\u015a"+
		"\u015b\5\22\n\2\u015b\u015c\7\37\2\2\u015c\u015d\b\30\1\2\u015d\u015e"+
		"\5.\30\2\u015e\u015f\b\30\1\2\u015f\u016d\3\2\2\2\u0160\u0161\7\62\2\2"+
		"\u0161\u0162\b\30\1\2\u0162\u0163\5.\30\2\u0163\u0164\b\30\1\2\u0164\u016d"+
		"\3\2\2\2\u0165\u0166\7 \2\2\u0166\u0167\7\31\2\2\u0167\u0168\b\30\1\2"+
		"\u0168\u0169\5.\30\2\u0169\u016a\b\30\1\2\u016a\u016d\3\2\2\2\u016b\u016d"+
		"\b\30\1\2\u016c\u0159\3\2\2\2\u016c\u0160\3\2\2\2\u016c\u0165\3\2\2\2"+
		"\u016c\u016b\3\2\2\2\u016d/\3\2\2\2\u016e\u016f\7\4\2\2\u016f\u018d\b"+
		"\31\1\2\u0170\u0171\7\5\2\2\u0171\u018d\b\31\1\2\u0172\u0173\7\6\2\2\u0173"+
		"\u018d\b\31\1\2\u0174\u0175\7\7\2\2\u0175\u018d\b\31\1\2\u0176\u0177\7"+
		"\27\2\2\u0177\u018d\b\31\1\2\u0178\u0179\7\30\2\2\u0179\u018d\b\31\1\2"+
		"\u017a\u017b\7\31\2\2\u017b\u017c\5\62\32\2\u017c\u017d\b\31\1\2\u017d"+
		"\u018d\3\2\2\2\u017e\u017f\7\34\2\2\u017f\u0180\5:\36\2\u0180\u0181\7"+
		"#\2\2\u0181\u0182\58\35\2\u0182\u0183\7\35\2\2\u0183\u0184\b\31\1\2\u0184"+
		"\u018d\3\2\2\2\u0185\u0186\7\32\2\2\u0186\u0187\5\22\n\2\u0187\u0188\b"+
		"\31\1\2\u0188\u0189\5\64\33\2\u0189\u018a\7\33\2\2\u018a\u018b\b\31\1"+
		"\2\u018b\u018d\3\2\2\2\u018c\u016e\3\2\2\2\u018c\u0170\3\2\2\2\u018c\u0172"+
		"\3\2\2\2\u018c\u0174\3\2\2\2\u018c\u0176\3\2\2\2\u018c\u0178\3\2\2\2\u018c"+
		"\u017a\3\2\2\2\u018c\u017e\3\2\2\2\u018c\u0185\3\2\2\2\u018d\61\3\2\2"+
		"\2\u018e\u0199\b\32\1\2\u018f\u0190\7\32\2\2\u0190\u0191\5\22\n\2\u0191"+
		"\u0192\5\66\34\2\u0192\u0193\7\33\2\2\u0193\u0194\b\32\1\2\u0194\u0199"+
		"\3\2\2\2\u0195\u0196\7\32\2\2\u0196\u0197\7\33\2\2\u0197\u0199\b\32\1"+
		"\2\u0198\u018e\3\2\2\2\u0198\u018f\3\2\2\2\u0198\u0195\3\2\2\2\u0199\63"+
		"\3\2\2\2\u019a\u019b\7\"\2\2\u019b\u019c\5\f\7\2\u019c\u019d\b\33\1\2"+
		"\u019d\u01a0\3\2\2\2\u019e\u01a0\b\33\1\2\u019f\u019a\3\2\2\2\u019f\u019e"+
		"\3\2\2\2\u01a0\65\3\2\2\2\u01a1\u01a2\7!\2\2\u01a2\u01a3\5\22\n\2\u01a3"+
		"\u01a4\5\66\34\2\u01a4\u01a5\b\34\1\2\u01a5\u01a8\3\2\2\2\u01a6\u01a8"+
		"\b\34\1\2\u01a7\u01a1\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8\67\3\2\2\2\u01a9"+
		"\u01aa\5:\36\2\u01aa\u01ab\7#\2\2\u01ab\u01ac\58\35\2\u01ac\u01ad\b\35"+
		"\1\2\u01ad\u01b0\3\2\2\2\u01ae\u01b0\b\35\1\2\u01af\u01a9\3\2\2\2\u01af"+
		"\u01ae\3\2\2\2\u01b09\3\2\2\2\u01b1\u01b2\5\22\n\2\u01b2\u01b3\b\36\1"+
		"\2\u01b3\u01b4\5<\37\2\u01b4\u01b5\b\36\1\2\u01b5\u01c5\3\2\2\2\u01b6"+
		"\u01b7\7\16\2\2\u01b7\u01b8\5\22\n\2\u01b8\u01b9\7\21\2\2\u01b9\u01ba"+
		"\5:\36\2\u01ba\u01bb\7\f\2\2\u01bb\u01bc\5:\36\2\u01bc\u01bd\b\36\1\2"+
		"\u01bd\u01c5\3\2\2\2\u01be\u01bf\7\26\2\2\u01bf\u01c0\5\22\n\2\u01c0\u01c1"+
		"\7\13\2\2\u01c1\u01c2\5:\36\2\u01c2\u01c3\b\36\1\2\u01c3\u01c5\3\2\2\2"+
		"\u01c4\u01b1\3\2\2\2\u01c4\u01b6\3\2\2\2\u01c4\u01be\3\2\2\2\u01c5;\3"+
		"\2\2\2\u01c6\u01cc\b\37\1\2\u01c7\u01c8\7\63\2\2\u01c8\u01c9\5\22\n\2"+
		"\u01c9\u01ca\b\37\1\2\u01ca\u01cc\3\2\2\2\u01cb\u01c6\3\2\2\2\u01cb\u01c7"+
		"\3\2\2\2\u01cc=\3\2\2\2\30Hajt\u00a6\u00b0\u00ba\u00cb\u00d9\u00e7\u0107"+
		"\u011b\u0135\u0152\u016c\u018c\u0198\u019f\u01a7\u01af\u01c4\u01cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}