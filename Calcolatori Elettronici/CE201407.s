! Questo programma deve, dato un vettore V finente per 0, 
! calcolarne la lunghezza e poi farne la somma termine a termine

_EXIT	= 1
_PRINTF = 127

.SECT .TEXT
start:
	MOV	BP,SP
	PUSH 	V	! Preparo parametro indirizzo V per CHECK
	CALL	CHECK	! Richiamo CHECK
	MOV	SP,BP
	PUSH	AX	! Preparo parametro lunghezza V per SUM
	PUSH	V	! Preparo parametro indirizzo V per SUM
	CALL	SUM	! Richiamo SUM
	MOV	SP,BP
	PUSH	BX	! Preparo parametro risultato per STAMPA
	PUSH	STRINGA	! Preparo parametro stringa per STAMPA 
	PUSH	_PRINTF	! Preparo operazione per STAMPA
	SYS		! Eseguo operazione STAMPA
	MOV	SP,BP
	PUSH	0
	PUSH	_EXIT	! Preparo operazione per EXIT
	SYS		! Eseguo EXIT e chiudo il programma

CHECK:
	PUSH	BP
	MOV	BP,SP
	MOV	SI,4(BP)
	MOV	AX,0
1:	LODS
	CMP	SI,0
	JE	2f
	ADD	AX,1
	LOOP	1b
2:	MOV	SP,BP
	POP	BP
	RET

SUM:
	PUSH	BP
	MOV	BP,SP
	MOV	CX,6(BP)
	MOV	SI,4(BP)
	MOV	BX,0
1:	LODS
	ADD	BX,AX
	LOOP	1b	
	MOV	SP,BP
	POP	BP
	RET

.SECT .DATA
	STRINGA:	.ASCII	"La somma degli elementi in V e' %d"
	V:		.WORD	2,4,7,11,0

.SECT .BSS