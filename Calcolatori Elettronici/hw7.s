#include "..\\syscalnr.h"

.SECT .TEXT
start:
	PUSH s			! passa s come argomento (o meglio l'indirizzo del primo carattere di s)
	CALL lun		! chiama la subroutine lun
	PUSH AX			! secondo parametro del messaggio r1 (il risultato di lun)
	PUSH s			! primo parametro del messaggio r1 (la stringa s)
	PUSH r1			! stringa messaggio r1
	PUSH _PRINTF		! codice funzione PRINTF
	SYS			! chiama la funzione PRINTF
	PUSH s			! passa l'indirizzo del primo carattere di s come argomento
	PUSH (x)		! passa il valore x come argomento
	CALL occ		! chiama la subroutine occ
	PUSH x			! terzo parametro del messaggio r2 (il carattere x)
	PUSH AX			! secondo parametro del messaggio r2 (il risultato di occ)
	PUSH s			! primo parametro del messaggio r2 (la stringa s)
	PUSH r2			! stringa messaggio r2
	PUSH _PRINTF		! codice funzione PRINTF
	SYS			! chiama la funzione PRINTF
	PUSH 0			! codice di stato
	PUSH _EXIT		! codice funzione EXIT
	SYS			! chiama la funzione EXIT

lun:
	PUSH BP			! salva il valore attuale di BP sullo stack
	MOV BP,SP		! copia SP in BP per accedere agli argomenti
	MOV BX,4(BP)		! copia in BX l'argomento (l'indirizzo del primo carattere di s)
	MOV CX,-1		! inizializzo CX al valore massimo possibile (senza segno 4.294.967.295, letto con segno diventa -1), serve per REPNE sotto
	MOVB AL,0		! metto in AL il carattere terminatore (NUL, valore 0)
	MOV DI,BX		! DI=BX, serve per l'istruzione SCASB qui sotto (SCAn String, Byte), che analizza il carattere in DI
    	REPNE SCASB		! Scorre la stringa finche non trova il byte in AL (0 qui), DI=DI+1 ad ogni passo (REPNE ripete CX volte, si ferma prima se SCASB finisce)
    	SUB DI,BX		! DI=DI-BX, e DI diventa la lunghezza della stringa + 1
	DEC DI			! SCASB conta anche il terminatore, quindi decremento di 1
	MOV AX,DI		! salva il risultato in AX
    	POP BP			! ripristina il valore iniziale di BP
	RET			! return

occ:
	PUSH BP			! salva il valore attuale di BP sullo stack
	MOV BP,SP		! copia SP in BP per accedere agli argomenti
	MOV BX,6(BP)		! copia in BX il primo argomento (l'indirizzo del primo carattere di s)
	MOV DX,4(BP)		! copia in DX il secondo argomento (il valore del carattere x)
	MOV AX,0		! inizializzo il risultato (posto in AX) a 0
	DEC BX			! il ciclo comincia con l'INC, quindi devo partire prima
1:	INC BX			! mi sposto in avanti (non lo metto alla fine senno' non funziona il JNE)
	MOV CX,(BX)		! copio il valore indirizzato da BX in CX
	CMPB CL,DL		! controllo se e' il carattere cercato
	JNE 2f			! non eseguire l'INC se non e' il carattere cercato
	INC AX			! incremento di 1 il risultato
2:	CMPB CL,0		! controllo se la stringa e' finita
	JNE 1b			! se non e' finita ripeti
    	POP BP			! ripristina il valore iniziale di BP
	RET			! return

.SECT .DATA
s:    .ASCIZ "tentativo"	! ASCIZ = ASCII che termina con il carattere NUL (che ha valore 0)
x:    .ASCIZ "t"
r1:   .ASCIZ "la stringa %s ha lunghezza %d \n"
r2:   .ASCIZ "la stringa %s contiene %d volte il carattere %s \n"

.SECT .BSS
