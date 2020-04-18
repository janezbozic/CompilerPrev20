lexer grammar PrevLexer;

@header {
	package prev.phase.lexan;
	import prev.common.report.*;
}

@members {
    @Override
	public LexAn.PrevToken nextToken() {
		return (LexAn.PrevToken) super.nextToken();
	}
}

COMMENT: '#'~('\r'|'\n')* -> skip;

CONST_CHAR: '\''([\u0020-\u0026\u0028-\u007E] | '\\\'')'\'';

CONST_STRING: '"'([\u0020-\u0021\u0023-\u007E] | '\\"')*'"';

CONST_INTEGER: [0-9]+;

CONST_LITERAL: 'nil';

KW_BOOLEAN: 'boolean'; 
KW_CHAR: 'char';
KW_DEL: 'del';
KW_DO: 'do';
KW_ELSE: 'else';
KW_FUN: 'fun';
KW_IF: 'if';
KW_INTEGER: 'integer';
KW_NEW: 'new';
KW_THEN: 'then';
KW_TYP: 'typ';
KW_VAR: 'var';
KW_VOID: 'void';
KW_WHERE: 'where';
KW_WHILE: 'while';

CONST_BOOLEAN: 'true' | 'false';

CONST_VOID: 'none';

IDENTIFIER: [A-Za-z_][A-Za-z0-9_]*;

SIM_LPAR: '(';
SIM_RPAR: ')';
SIM_LSQLBR: '{';
SIM_RSQLBR: '}';
SIM_LSQRBR: '[';
SIM_RSQRBR: ']';
SIM_DOT: '.';
SIM_COM: ',';
SIM_COL: ':';
SIM_SCOL: ';';
SIM_AND: '&';
SIM_LINE: '|';
SIM_EKSP: '!';
SIM_EQU: '==';
SIM_NEQU: '!=';
SIM_LT: '<';
SIM_GT: '>';
SIM_LTEQU: '<=';
SIM_GTEQU: '>=';
SIM_STAR: '*';
SIM_SLH: '/';
SIM_PRCNT: '%';
SIM_PLUS: '+';
SIM_MINUS: '-';
SIM_TOP: '^';
SIM_IS: '=';

SPACE: [ \n\r]+ -> skip;
TAB: '\t' {this.setCharPositionInLine(this.getCharPositionInLine()+7-((this.getCharPositionInLine()-1)%8));} -> skip;

ERROR: . {if (true) throw new Report.Error("Lexer error on line: " + this.getLine() + " column: " + this.getCharPositionInLine() + "\nPlease check if char/string is written correctly.");};