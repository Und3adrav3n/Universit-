_EXIT = 1
_PRINTF = 127

.SECT .TEXT
MAIN:
	MOV	BP,SP
	PUSH	V
	CALL	CHECK
	PUSH	DX
	CALL	SUM
	PUSH	BX
	PUSH	string
	PUSH	_PRINTF
	SYS
	MOV	SP,BP
	PUSH	0
	PUSH	_EXIT
	SYS
	
CHECK:
	PUSH	BP
	MOV	BP,SP
	MOV	SI,4(BP)
1:	LODS
	ADD	DX,1
	CMP	(SI),0
	JNZ	1b
	POP	BP
	RET

SUM:
	PUSH	BP
	MOV	BP,SP
	MOV	CX,4(BP)
	MOV	SI,6(BP)
1:	LODS
	ADD	BX,AX
	LOOP	1b
	POP	BP
	RET

.SECT .DATA
V:	.WORD 1,2,3,4,0
string:	.ASCIZ	"la somma di tutti e'%d\n"

.SECT .BSS
