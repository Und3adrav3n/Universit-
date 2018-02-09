#include<stdio.h>
#include<stdlib.h>

typedef struct
{
	int giorni;
	char nome[20];
} mese;

int main()
{
	int i;
	mese v[12];

	FILE fp = fopen("mesi.dat", "rb");

	if(fp == NULL)
	{
		printf("Il file non esiste!");
		return 1;
	}

	while(fread(&v[i], sizeof(mese), 1, f))
	{
		if(v[i].giorni == 31)
			printf("%s ha 31 giorni", nome);
		i++;
	}

	fclose(fp);
	return 0;
}

