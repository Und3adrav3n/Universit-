_EXIT = 1
_PRINTF = 127

.SECT .TEXT

MAIN:
	MOV	BP,SP
	PUSH	N
	CALL	SUM
	PUSH	M
	CALL	EQU
	MOV	SP,PB
	PUSH	0
	PUSH	_EXIT
	SYS

SUM:				! SOMMA TUTTI GLI ELEM DI UN VETTORE E LI STAMPA
	PUSH	BP
	MOV	BP,SP
	MOV	SI,4(BP)	! PREPARO PARAMETRI
	MOV	BX,0		! PREPARO REGISTRO CHE AVRA' VALORE DI RITORNO
1:	LODS
	CMP	AX,0
	JE	2f
	ADD	BX,AX		! SOMMO ELEM ATTUALE ALL'ACCUMULATORE
	JMP	1b
2:	PUSH	BX		! INIZIO PRINTF
	PUSH	str
	PUSH	_PRINTF		
	SYS			! STAMPA
	MOV	SP,BP		! FINE PRINTF
	POP	BP
	RET

EQU:
	PUSH	BP
	MOV	BP,SP
	MOV	SI,6(BP)	! PREPARO PARAMETRI
	MOV	DI,4(BP)
	MOV	CX,M-N		! CALCOLO LUNGHEZZA [BYTE]
	SHR	CX,1		! CALCOLO LUNGHEZZA [WORD]
1:	LODS
	CMP	AX,(DI)		! CONTROLLO CONDIZIONE IF(M[I]!=N[I])
	JNE	2f
	ADD	DI,2		
	LOOP	1b
	PUSH	strv		! SE SONO UGUALI INIZIO STAMPA "uguali"
	PUSH	_PRINTF
	SYS
	MOV	SP,BP
	POP	BP
	RET			! FINE
2:	PUSH	strf		! SE NON SONO UGUALI INIZIO STAMPA "non uguali"
	PUSH	_PRINTF
	SYS
	MOV	SP,BP
	POP	BP
	RET			! FINE

.SECT .DATA

N:	.WORD	1,2,3,4,5,6,7,0
M:	.WORD	1,2,3,4,5,6,7,0
O:	.WORD	1,2,3,4,0
str:	.ASCIZ	"La somma e' %d"
strv:	.ASCIZ	"Sono uguali"
strf:	.ASCIZ	"Non sono uguali"

.SECT .BSS