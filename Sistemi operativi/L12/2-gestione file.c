#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef char stringa[30];

typedef struct record{
	stringa nome;
	int n;
} record;

int creaBinario(stringa nome_file, stringa colore)
{
	FILE *fp = fopen(nome_file, "r");
	FILE *fb = fopen("posizione_colore.dat", "wb+");
	int cont[3];
	
	while(!feof(fp))
	{
		stringa nome, c1, c2, c3;
		int v;
		int cont[3];
		
		fscanf("%s %s %s %sn", nome, c1, c2, c3);
		
		if(strcmp(colore, c1))
		{
			v = 1;
			cont[0]++;
		}
		if(strcmp(colore, c2))
		{
			v = 2;
			cont[1]++;
		}
		if(strcmp(colore, c3))
		{
			v = 3;
			cont[2]++;			
		}
		
		record r = malloc(sizeof(record));
		strcpy(r.nome,nome);
		r.n = v;
		
		fwrite(r, sizeof(record), 1, fb);
	}
	
	fclose(fp);
	fclose(fb);
	
	if(cont[0] > cont[1])
		if(cont[0] > cont[2])
			return cont[0];
		else
			return cont[2];
	else
		if(cont[1] > cont[2])
			return cont[1];
		else
			return cont[2];
}
