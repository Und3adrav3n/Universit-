// Librerie standard
#include<stdio.h>	// STanDard Input/Output
#include<stdlib.h>	// STanDard LIBrary
#include<string.h>

// Typedef
// Definizione tipo stringa
typedef char Stringa[30];

// Definizione tipo record binario
typedef struct {
	Stringa nome;
	int flag;
} record_bin;

// Dichiarazione metodi ausiliari
int creaBinario(Stringa, Stringa);
void leggiBinario();

// Main
int main(){
	printf("num occorrenze: %d\n", creaBinario("persone_frutta.txt", "pera"));
	leggiBinario();
	system("rm frutto_preferito.dat");
	return 0;
}

// Crea un file binario con conteggio e presenza preferenza 
int creaBinario (Stringa nome_file, Stringa frutto)
{
	// Dichiarazione variabili
	FILE *fin, *fout;
	Stringa nome, frutto1, frutto2, frutto3;
	int count=0;

	// Apertura file input con tutti i permessi
	fin = fopen(nome_file, "r");
	// Apertura file output con tutti i permessi in binario
	fout = fopen("frutto_preferito.dat", "ab");
	
	while(!feof(fin))
	{
		// Lettura riga
		fscanf(fin, "%s %s %s %s\n", nome, frutto1, frutto2, frutto3);
		// Dichiarazione record_bin record
		record_bin record;
		
		// Riempimento record campo nome
		strcpy(record.nome, nome);

		// Riempimento record campo flag
		record.flag = strcmp(frutto, frutto1)==0 || strcmp(frutto, frutto2)==0 || strcmp(frutto, frutto3)==0;
		
		// Conteggio
		if(record.flag==1)
			count++;

		// Scrivo nel file binario il record relativo alla persona corrente
		fwrite(&record, 1, sizeof(record_bin), fout);
	}
	// Chiusura file
	fclose(fin);
	fclose(fout);

	// Ritorno conteggio
	return count;
}

// Legge e stampa file binari
void leggiBinario()
{
	// Dichiarazioen variabili
	FILE* fin;

	// Apertura file
	fin = fopen("frutto_preferito.dat", "rb");

	while(!feof(fin))
	{
		// Lettura dati da file binario e riempimento record
		record_bin record;
		fread(&record, 1, sizeof(record_bin), fin);

		// Stampa dati letti
		printf("%s \t %d\n", record.nome, record.flag);
	}
	fclose(fin);
}
