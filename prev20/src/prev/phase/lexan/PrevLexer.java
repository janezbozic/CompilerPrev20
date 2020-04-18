// Generated from lexan/PrevLexer.g4 by ANTLR 4.8

	package prev.phase.lexan;
	import prev.common.report.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrevLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "CONST_CHAR", "CONST_STRING", "CONST_INTEGER", "CONST_LITERAL", 
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
		public LexAn.PrevToken nextToken() {
			return (LexAn.PrevToken) super.nextToken();
		}


	public PrevLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PrevLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 50:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 51:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			this.setCharPositionInLine(this.getCharPositionInLine()+7-((this.getCharPositionInLine()-1)%8));
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			if (true) throw new Report.Error("Lexer error on line: " + this.getLine() + " column: " + this.getCharPositionInLine() + "\nPlease check if char/string is written correctly.");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u0138\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\7\2n\n\2\f\2\16\2q\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\5\3y\n\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u0081\n\4\f\4\16\4\u0084\13\4"+
		"\3\4\3\4\3\5\6\5\u0089\n\5\r\5\16\5\u008a\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00e4\n\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\7\30\u00ed\n\30\f\30\16\30\u00f0\13\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\6\63\u012b\n\63"+
		"\r\63\16\63\u012c\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\2"+
		"\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66\3\2"+
		"\t\4\2\f\f\17\17\4\2\"(*\u0080\4\2\"#%\u0080\3\2\62;\5\2C\\aac|\6\2\62"+
		";C\\aac|\5\2\f\f\17\17\"\"\2\u013f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\3k\3\2\2\2\5t\3\2\2\2\7|\3\2\2\2\t\u0088\3\2\2\2\13\u008c"+
		"\3\2\2\2\r\u0090\3\2\2\2\17\u0098\3\2\2\2\21\u009d\3\2\2\2\23\u00a1\3"+
		"\2\2\2\25\u00a4\3\2\2\2\27\u00a9\3\2\2\2\31\u00ad\3\2\2\2\33\u00b0\3\2"+
		"\2\2\35\u00b8\3\2\2\2\37\u00bc\3\2\2\2!\u00c1\3\2\2\2#\u00c5\3\2\2\2%"+
		"\u00c9\3\2\2\2\'\u00ce\3\2\2\2)\u00d4\3\2\2\2+\u00e3\3\2\2\2-\u00e5\3"+
		"\2\2\2/\u00ea\3\2\2\2\61\u00f1\3\2\2\2\63\u00f3\3\2\2\2\65\u00f5\3\2\2"+
		"\2\67\u00f7\3\2\2\29\u00f9\3\2\2\2;\u00fb\3\2\2\2=\u00fd\3\2\2\2?\u00ff"+
		"\3\2\2\2A\u0101\3\2\2\2C\u0103\3\2\2\2E\u0105\3\2\2\2G\u0107\3\2\2\2I"+
		"\u0109\3\2\2\2K\u010b\3\2\2\2M\u010e\3\2\2\2O\u0111\3\2\2\2Q\u0113\3\2"+
		"\2\2S\u0115\3\2\2\2U\u0118\3\2\2\2W\u011b\3\2\2\2Y\u011d\3\2\2\2[\u011f"+
		"\3\2\2\2]\u0121\3\2\2\2_\u0123\3\2\2\2a\u0125\3\2\2\2c\u0127\3\2\2\2e"+
		"\u012a\3\2\2\2g\u0130\3\2\2\2i\u0135\3\2\2\2ko\7%\2\2ln\n\2\2\2ml\3\2"+
		"\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\b\2\2\2s\4\3"+
		"\2\2\2tx\7)\2\2uy\t\3\2\2vw\7^\2\2wy\7)\2\2xu\3\2\2\2xv\3\2\2\2yz\3\2"+
		"\2\2z{\7)\2\2{\6\3\2\2\2|\u0082\7$\2\2}\u0081\t\4\2\2~\177\7^\2\2\177"+
		"\u0081\7$\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0086\7$\2\2\u0086\b\3\2\2\2\u0087\u0089\t\5\2\2\u0088\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\n\3\2\2\2\u008c\u008d\7p\2\2\u008d\u008e\7k\2\2\u008e\u008f\7n\2\2\u008f"+
		"\f\3\2\2\2\u0090\u0091\7d\2\2\u0091\u0092\7q\2\2\u0092\u0093\7q\2\2\u0093"+
		"\u0094\7n\2\2\u0094\u0095\7g\2\2\u0095\u0096\7c\2\2\u0096\u0097\7p\2\2"+
		"\u0097\16\3\2\2\2\u0098\u0099\7e\2\2\u0099\u009a\7j\2\2\u009a\u009b\7"+
		"c\2\2\u009b\u009c\7t\2\2\u009c\20\3\2\2\2\u009d\u009e\7f\2\2\u009e\u009f"+
		"\7g\2\2\u009f\u00a0\7n\2\2\u00a0\22\3\2\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3"+
		"\7q\2\2\u00a3\24\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7"+
		"\7u\2\2\u00a7\u00a8\7g\2\2\u00a8\26\3\2\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab"+
		"\7w\2\2\u00ab\u00ac\7p\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af"+
		"\7h\2\2\u00af\32\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3"+
		"\7v\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7i\2\2\u00b5\u00b6\7g\2\2\u00b6"+
		"\u00b7\7t\2\2\u00b7\34\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\u00bb\7y\2\2\u00bb\36\3\2\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7j\2\2\u00be"+
		"\u00bf\7g\2\2\u00bf\u00c0\7p\2\2\u00c0 \3\2\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		"\u00c3\7{\2\2\u00c3\u00c4\7r\2\2\u00c4\"\3\2\2\2\u00c5\u00c6\7x\2\2\u00c6"+
		"\u00c7\7c\2\2\u00c7\u00c8\7t\2\2\u00c8$\3\2\2\2\u00c9\u00ca\7x\2\2\u00ca"+
		"\u00cb\7q\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7f\2\2\u00cd&\3\2\2\2\u00ce"+
		"\u00cf\7y\2\2\u00cf\u00d0\7j\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7t\2\2"+
		"\u00d2\u00d3\7g\2\2\u00d3(\3\2\2\2\u00d4\u00d5\7y\2\2\u00d5\u00d6\7j\2"+
		"\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7g\2\2\u00d9*\3\2"+
		"\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7w\2\2\u00dd\u00e4"+
		"\7g\2\2\u00de\u00df\7h\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7n\2\2\u00e1"+
		"\u00e2\7u\2\2\u00e2\u00e4\7g\2\2\u00e3\u00da\3\2\2\2\u00e3\u00de\3\2\2"+
		"\2\u00e4,\3\2\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7"+
		"p\2\2\u00e8\u00e9\7g\2\2\u00e9.\3\2\2\2\u00ea\u00ee\t\6\2\2\u00eb\u00ed"+
		"\t\7\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\60\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7*\2\2"+
		"\u00f2\62\3\2\2\2\u00f3\u00f4\7+\2\2\u00f4\64\3\2\2\2\u00f5\u00f6\7}\2"+
		"\2\u00f6\66\3\2\2\2\u00f7\u00f8\7\177\2\2\u00f88\3\2\2\2\u00f9\u00fa\7"+
		"]\2\2\u00fa:\3\2\2\2\u00fb\u00fc\7_\2\2\u00fc<\3\2\2\2\u00fd\u00fe\7\60"+
		"\2\2\u00fe>\3\2\2\2\u00ff\u0100\7.\2\2\u0100@\3\2\2\2\u0101\u0102\7<\2"+
		"\2\u0102B\3\2\2\2\u0103\u0104\7=\2\2\u0104D\3\2\2\2\u0105\u0106\7(\2\2"+
		"\u0106F\3\2\2\2\u0107\u0108\7~\2\2\u0108H\3\2\2\2\u0109\u010a\7#\2\2\u010a"+
		"J\3\2\2\2\u010b\u010c\7?\2\2\u010c\u010d\7?\2\2\u010dL\3\2\2\2\u010e\u010f"+
		"\7#\2\2\u010f\u0110\7?\2\2\u0110N\3\2\2\2\u0111\u0112\7>\2\2\u0112P\3"+
		"\2\2\2\u0113\u0114\7@\2\2\u0114R\3\2\2\2\u0115\u0116\7>\2\2\u0116\u0117"+
		"\7?\2\2\u0117T\3\2\2\2\u0118\u0119\7@\2\2\u0119\u011a\7?\2\2\u011aV\3"+
		"\2\2\2\u011b\u011c\7,\2\2\u011cX\3\2\2\2\u011d\u011e\7\61\2\2\u011eZ\3"+
		"\2\2\2\u011f\u0120\7\'\2\2\u0120\\\3\2\2\2\u0121\u0122\7-\2\2\u0122^\3"+
		"\2\2\2\u0123\u0124\7/\2\2\u0124`\3\2\2\2\u0125\u0126\7`\2\2\u0126b\3\2"+
		"\2\2\u0127\u0128\7?\2\2\u0128d\3\2\2\2\u0129\u012b\t\b\2\2\u012a\u0129"+
		"\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\b\63\2\2\u012ff\3\2\2\2\u0130\u0131\7\13\2"+
		"\2\u0131\u0132\b\64\3\2\u0132\u0133\3\2\2\2\u0133\u0134\b\64\2\2\u0134"+
		"h\3\2\2\2\u0135\u0136\13\2\2\2\u0136\u0137\b\65\4\2\u0137j\3\2\2\2\13"+
		"\2ox\u0080\u0082\u008a\u00e3\u00ee\u012c\5\b\2\2\3\64\2\3\65\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}