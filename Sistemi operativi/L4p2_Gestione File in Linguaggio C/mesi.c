#include<stdio.h>
#include<stdlib.h>

int main()
{
	char nome[20];
	int giorni;
	FILE *fp;

	fp = fopen("mesi.txt", "r");

	if(fp==NULL)
	{
		printf("Il file non esiste!");
		return 1;
	}

	while(fscanf(fp, "%s %d\n", nome, &giorni) != EOF)
		if(giorni == 31)
			printf("%s ha 31 giorni.\n", nome);

	fclose(fp);

	return 0;
}

