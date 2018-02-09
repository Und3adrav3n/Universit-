// Librerie standard
#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>

// Definizioni
#define max 10

typedef char Stringa[30];

// Dichiarazione metodi ausiliari
int modificaColore(Stringa, Stringa, Stringa);

int main()
{
	return 0;
}

// Input 	nome_file, colore_corrente, colore_nuovo
// Output 	numero colori sostituiti
// Algoritmo	Sostituisce tutte le occorrenze di colore_corrente con colore_nuovo all'interno di nome_file
int modificaColore(Stringa nome_file, Stringa colore_corrente, Stringa colore_nuovo)
{
	// Dichiarazione variabili
	FILE *fin;
	int count=0;

	// Apertura file
	fin = fopen(nome_file, "a");

	while(!feof(fin))
	{
		// Dichiarazione variabili locali
		Stringa nome, colore1, colore2, colore3;
		
		// Lettura da file
		fscanf(fin, "%s %s %s %s\n", nome, colore1, colore2, colore3);

		// Scambio colori
		if(strcmp(colore_corrente, colore1)==0)
		{
			colore1=colore_nuovo;
			count++;
		}
		if(strcmp(colore_corrente, colore2)==0)
		{
			colore2=colore_nuovo;
			count++;
		}
		if(strcmp(colore_corrente, colore3)==0)
		{
			colore3=colore_nuovo;
			count++;
		}
		
		seek(;;);	
	}
}
