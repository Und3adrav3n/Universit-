_EXIT = 1
_PRINTF = 127

.SECT .TEXT

MAIN:
	MOV	BP,SP
	PUSH	S1
	CALL	PAL
	MOV	SP,BP
	PUSH	S2
	CALL	PAL
	MOV	SP,BP
	PUSH	0
	PUSH	_EXIT
	SYS

PAL:
	PUSH	BP
	MOV	BP,SP
	MOV	DI,4(BP)
	! DEVO TROVARE L'IND FINALE DELLA STRINGA E METTERLO DENTRO SI
	MOV	AX,0
	MOV	CX,-1
	REPNZ	SCASB	! TROVO IND FINALE
	MOV	SI,DI	! LO METTO DENTRO SI [OBIETTIVO COMPLETATO]
	MOV	DI,4(BP)! METTO IN DI L'IND INIZIALE
	! DEVO PREPARARE CX PER IL CONTROLLO CON META' LUNGHEZZA STRINGA
	NEG	CX	! NEGO CX
	DEC	CX	! TOLGO L'ELEM IN ECCESSO
	SHR	CX,1	! DIVIDO PER 2 [OBIETTIVO COMPLETATO]
	! DEVO COMPARARE OGNI CHAR DALL'INIZIO CON OGNI CHAR DALLA FINE
1:	MOV	AX,(DI)
	CMP	(SI),AX		! COMPARO I DUE CHAR ATTUALI
	JNE	2F		! SE NON SONO UGUALI SALTO A 2F
	ADD	SI,2
	ADD	DI,-2		! ALTRIMENTI PROSEGUO
	LOOP	1B
	PUSH	1		! ARRIVO QUI SE E' PALINDROMA
	PUSH	_PRINTF
	SYS
	MOV	SP,BP
	POP	BP
	RET
	MOV	SP,BP
	RET
2:	PUSH	0		! ARRIVO QUI SE NON E' PALINDROMA
	PUSH	_PRINTF
	SYS
	MOV	SP,BP
	POP	BP
	RET
	MOV	SP,BP
	RET
	

.SECT .DATA

S1:	.ASCIZ	"OSSO"
S2:	.ASCIZ	"CIAO"

.SECT .BSS