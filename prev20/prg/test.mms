	LOC	#100
	GREG	@
D254	OCTA 0
	GREG	@
D253	OCTA 0
	GREG	@
D252	OCTA 0
	GREG	@
PRINT	BYTE	0,0
inCount	IS	#1
InArgs	OCTA	charRead,inCount
charRead	BYTE	0


Main	SET $0,#0
	SETH $252,#3000
	SETH $254,#3FFF
	INCMH $254,#FFFF
	INCML $254,#FFFF
	INCL $254,#FFFF
	PUSHJ $0,_main
	TRAP 0,Halt,0

L0	SET $0,$254
	SETL $1,8
	SUB $0,$0,$1
	STO $253,$0,0
	SUB $0,$0,8
	GET $2,rJ
	STO $2,$0,0
	SET $253,$254
	SETL $1,32
	SUB $254,$254,$1
	JMP L18
L18	SET $1,$253
	SETL $0,8
	ADD $1,$1,$0
	LDO $1,$1,0
	SETL $0,0
	CMP $0,$1,$0
	ZSZ $0,$0,1
	BNZ $0,L7
L20	SET $0,$253
	SETL $1,8
	ADD $1,$0,$1
	LDO $1,$1,0
	SETL $0,10
	DIV $0,$1,$0
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,L0
	LDO $0,$254,0
	LDO $0,$253,0
	LDO $0,$0,0
	SET $1,$253
	SETL $2,8
	ADD $2,$1,$2
	LDO $2,$2,0
	SETL $1,10
	DIV $2,$2,$1
	GET $2,rR
	SETL $1,48
	ADD $1,$2,$1
	SETL $2,256
	DIV $1,$1,$2
	GET $1,rR
	STO $1,$254,8
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	JMP L9
L7	SETL $0,0
	JMP L9
L8	SET $0,$253
	SETL $1,8
	ADD $1,$0,$1
	LDO $1,$1,0
	SETL $0,10
	DIV $0,$1,$0
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,L0
	LDO $0,$254,0
	LDO $0,$253,0
	LDO $0,$0,0
	SET $1,$253
	SETL $2,8
	ADD $2,$1,$2
	LDO $2,$2,0
	SETL $1,10
	DIV $2,$2,$1
	GET $2,rR
	SETL $1,48
	ADD $1,$2,$1
	SETL $2,256
	DIV $1,$1,$2
	GET $1,rR
	STO $1,$254,8
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	JMP L9
L9	SETL $0,0
	SET $0,$0
	JMP L19
L19	STO $0,$253,0
	SET $0,$253
	SETL $1,8
	SUB $0,$0,$1
	LDO $2,$0,0
	SET $254,$253
	SET $253,$2
	SUB $0,$0,8
	LDO $2,$0,0
	PUT rJ,$2
	POP

_putInteger	SET $0,$254
	SETL $1,8
	SUB $0,$0,$1
	STO $253,$0,0
	SUB $0,$0,8
	GET $2,rJ
	STO $2,$0,0
	SET $253,$254
	SETL $1,32
	SUB $254,$254,$1
	JMP L21
L21	SET $0,$253
	SETL $1,8
	ADD $0,$0,$1
	LDO $0,$0,0
	SETL $1,0
	CMP $0,$0,$1
	ZSN $0,$0,1
	BNZ $0,L1
L23	SETL $0,0
	JMP L3
L1	SETL $0,45
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SET $1,$253
	SETL $0,8
	ADD $1,$1,$0
	SET $0,$253
	SETL $2,8
	ADD $0,$0,$2
	LDO $0,$0,0
	NEG $0,$0
	STO $0,$1,0
	SETL $0,0
	JMP L3
L2	SETL $0,0
	JMP L3
L3	SET $1,$253
	SETL $0,8
	ADD $0,$1,$0
	LDO $0,$0,0
	SETL $1,0
	CMP $0,$0,$1
	ZSZ $0,$0,1
	BNZ $0,L4
L24	SET $0,$253
	SETL $1,8
	ADD $0,$0,$1
	LDO $0,$0,0
	STO $0,$254,8
	STO $253,$254,0
	PUSHJ $4,L0
	LDO $0,$254,0
	JMP L6
L4	SETL $0,48
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	JMP L6
L5	SET $0,$253
	SETL $1,8
	ADD $0,$0,$1
	LDO $0,$0,0
	STO $0,$254,8
	STO $253,$254,0
	PUSHJ $4,L0
	LDO $0,$254,0
	JMP L6
L6	SETL $0,0
	SET $0,$0
	JMP L22
L22	STO $0,$253,0
	SET $0,$253
	SETL $1,8
	SUB $0,$0,$1
	LDO $2,$0,0
	SET $254,$253
	SET $253,$2
	SUB $0,$0,8
	LDO $2,$0,0
	PUT rJ,$2
	POP

_putString	SET $0,$254
	SETL $1,16
	SUB $0,$0,$1
	STO $253,$0,0
	SUB $0,$0,8
	GET $2,rJ
	STO $2,$0,0
	SET $253,$254
	SETL $1,40
	SUB $254,$254,$1
	JMP L25
L25	SET $0,$253
	SETL $1,8
	NEG  $1,$1
	ADD $1,$0,$1
	SETL $0,0
	STO $0,$1,0
	JMP L10
L10	SET $0,$253
	SETL $1,8
	ADD $1,$0,$1
	LDO $1,$1,0
	SET $0,$253
	SETL $2,8
	NEG  $2,$2
	ADD $0,$0,$2
	LDO $0,$0,0
	SETL $2,8
	MUL $0,$0,$2
	ADD $2,$1,$0
	LDO $2,$2,0
	SETL $1,0
	SETL $0,256
	DIV $0,$1,$0
	GET $0,rR
	CMP $0,$2,$0
	ZSNZ $0,$0,1
	BNZ $0,L11
L27	SETL $0,0
	SET $0,$0
	JMP L26
L11	SET $1,$253
	SETL $0,8
	ADD $1,$1,$0
	LDO $1,$1,0
	SET $2,$253
	SETL $0,8
	NEG  $0,$0
	ADD $0,$2,$0
	LDO $0,$0,0
	SETL $2,8
	MUL $0,$0,$2
	ADD $0,$1,$0
	LDO $0,$0,0
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SET $0,$253
	SETL $1,8
	NEG  $1,$1
	ADD $0,$0,$1
	SET $2,$253
	SETL $1,8
	NEG  $1,$1
	ADD $2,$2,$1
	LDO $2,$2,0
	SETL $1,1
	ADD $1,$2,$1
	STO $1,$0,0
	SETL $0,0
	JMP L10
L12	SETL $0,0
	SET $0,$0
	JMP L26
L26	STO $0,$253,0
	SET $0,$253
	SETL $1,16
	SUB $0,$0,$1
	LDO $2,$0,0
	SET $254,$253
	SET $253,$2
	SUB $0,$0,8
	LDO $2,$0,0
	PUT rJ,$2
	POP

_perms	SET $0,$254
	SETL $1,16
	SUB $0,$0,$1
	STO $253,$0,0
	SUB $0,$0,8
	GET $2,rJ
	STO $2,$0,0
	SET $253,$254
	SETL $1,56
	SUB $254,$254,$1
	JMP L28
L28	SET $1,$253
	SETL $0,8
	ADD $0,$1,$0
	LDO $0,$0,0
	SETL $1,48
	ADD $1,$0,$1
	SETL $0,256
	DIV $0,$1,$0
	GET $0,rR
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SETL $0,10
	SETL $1,256
	DIV $0,$0,$1
	GET $0,rR
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SET $0,$253
	SETL $1,16
	ADD $0,$0,$1
	LDO $0,$0,0
	SETL $1,48
	ADD $0,$0,$1
	SETL $1,256
	DIV $0,$0,$1
	GET $0,rR
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SETL $0,10
	SETL $1,256
	DIV $0,$0,$1
	GET $0,rR
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SETL $1,10
	SETL $0,256
	DIV $0,$1,$0
	GET $0,rR
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SET $1,$253
	SETL $0,8
	ADD $1,$1,$0
	LDO $1,$1,0
	SET $2,$253
	SETL $0,16
	ADD $0,$2,$0
	LDO $0,$0,0
	CMP $0,$1,$0
	ZSZ $0,$0,1
	BNZ $0,L13
L30	LDO $0,$253,0
	SET $1,$253
	SETL $2,8
	ADD $1,$1,$2
	LDO $1,$1,0
	SETL $2,1
	ADD $1,$1,$2
	NEG $2,0,32
	STO $1,$253,$2
	SET $2,$253
	SETL $1,16
	ADD $1,$2,$1
	LDO $1,$1,0
	SET $2,$253
	SETL $3,24
	ADD $2,$2,$3
	LDO $2,$2,0
	STO $2,$254,24
	STO $1,$254,16
	NEG $1,0,32
	LDO $1,$1,$253
	STO $1,$254,8
	STO $0,$254,0
	PUSHJ $4,_perms
	LDO $0,$254,0
	JMP L15
L13	SETL $0,0
	JMP L15
L14	LDO $0,$253,0
	SET $1,$253
	SETL $2,8
	ADD $1,$1,$2
	LDO $1,$1,0
	SETL $2,1
	ADD $1,$1,$2
	NEG $2,0,32
	STO $1,$253,$2
	SET $2,$253
	SETL $1,16
	ADD $1,$2,$1
	LDO $1,$1,0
	SET $2,$253
	SETL $3,24
	ADD $2,$2,$3
	LDO $2,$2,0
	STO $2,$254,24
	STO $1,$254,16
	NEG $1,0,32
	LDO $1,$1,$253
	STO $1,$254,8
	STO $0,$254,0
	PUSHJ $4,_perms
	LDO $0,$254,0
	JMP L15
L15	SETL $0,0
	SET $0,$0
	JMP L29
L29	STO $0,$253,0
	SET $0,$253
	SETL $1,16
	SUB $0,$0,$1
	LDO $2,$0,0
	SET $254,$253
	SET $253,$2
	SUB $0,$0,8
	LDO $2,$0,0
	PUT rJ,$2
	POP

_main	SET $0,$254
	SETL $1,24
	SUB $0,$0,$1
	STO $253,$0,0
	SUB $0,$0,8
	GET $2,rJ
	STO $2,$0,0
	SET $253,$254
	SETL $1,64
	SUB $254,$254,$1
	JMP L31
L31	SET $0,$253
	SETL $1,8
	NEG  $1,$1
	ADD $1,$0,$1
	SETL $0,3
	STO $0,$1,0
	SET $0,$253
	SETL $1,8
	NEG  $1,$1
	SET $2,$253
	SETL $3,16
	NEG  $3,$3
	ADD $2,$2,$3
	LDO $2,$2,0
	STO $2,$254,24
	ADD $2,$0,$1
	LDO $2,$2,0
	STO $2,$254,16
	SETL $2,0
	STO $2,$254,8
	LDO $2,$253,0
	STO $2,$254,0
	PUSHJ $4,_perms
	LDO $2,$254,0
	SETL $0,97
	STO $0,$254,8
	LDO $0,$253,0
	STO $0,$254,0
	PUSHJ $4,_putChar
	LDO $0,$254,0
	SETL $0,0
	SET $0,$0
	JMP L32
L32	STO $0,$253,0
	SET $0,$253
	SETL $1,24
	SUB $0,$0,$1
	LDO $2,$0,0
	SET $254,$253
	SET $253,$2
	SUB $0,$0,8
	LDO $2,$0,0
	PUT rJ,$2
	POP

_putChar	SET $0,$254
	ADD $0,$0,8
	LDO $0,$0,0
	LDA $255,PRINT
	STB $0,$255,0
	TRAP 0,Fputs,StdOut
	POP

_getChar	SET $0,$254
	SET $1,8
	SUB $0,$0,$1
	STO $253,$0,0
	SUB $0,$0,8
	GET $1,rJ
	STO $1,$0,0
	SET $253,$254
	SET $0,16
	SUB $254,$254,$0
	LDA	$255,InArgs
	TRAP 0,Fread,StdIn
	LDA	$255,charRead
	LDB	$0,$255,0
	STO $0,$253,0
	SET $0,$253
	SET $1,8
	SUB $0,$0,$1
	LDO $1,$0,0
	SET $254,$253
	SET $253,$1
	SUB $0,$0,8
	LDO $1,$0,0
	PUT rJ,$1
	POP



_exit	TRAP 0,Halt,0