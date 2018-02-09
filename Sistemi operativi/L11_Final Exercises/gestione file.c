#include<stdio.h>
#include<string.h>

typedef char stringa[30];

int inserisci(stringa nome, int voto, stringa nomefile)
{
	int numelem = 0;
	stringa tmp;

	if(voto <= 10 && voto >= 0)
	{
		FILE *fp = fopen(nomefile, "a+");
		fprintf(fp, "%s %d\n", nome, voto);

		fseek(fp, 0, SEEK_SET);
		while(!feof(fp))
		{
			fscanf(fp, "%s %d\n", tmp, &voto);
			numelem++;
		}

		fclose(fp);
	}
	else numelem=-1;

	return numelem;
}

void cambiaVoto(stringa nome, int vecchio_voto, int nuovo_voto, stringa nomefile)
{
	long pos;
	int voto;
	stringa tmp;

	if(nuovo_voto <= 10 && nuovo_voto >= 0)
	{
		FILE *fp = fopen(nomefile, "r+");

		while(!feof(fp))
		{
			pos = ftell(fp);
			
			if(fscanf(fp, "%s %d\n", tmp, &voto) != EOF)
			{
				if(strcmp(nome, tmp) == 0 && strcmp(vecchio_voto,voto) == 0)
				{
				fseek(fp, pos, SEEK_SET);
				fprintf(fp, "%s %d\n", nome, nuovo_voto);
				break;
				}
			}
		}
		fclose(fp);
	}
	else
		printf("Errore nell'inserimento del voto");
}

int maxVoto(stringa nomefile)
{
	int voto, max = 0;
	stringa nome;

	FILE* fp = fopen(nomefile, "r");

	if(fp == NULL)
		printf("File inesistente");
	
	while(!feof(fp))
	{
		fscanf("%s %d\n", nome, &voto);

		if(voto > max)
			max = voto;
	}
	fclose(fp);
	return max;
}

void creaFiles(stringa nomefile)
{
	FILE *fp = fopen(nomefile, "r");
	
	stringa tmp_nome;
	int tmp_voto;
	stringa nuovofile;
	
	while(!feof(fp))
	{
		fscanf(fp, "%s %dn", tmp_nome, &tmp_voto);
		
		strcpy(nuovofile, nomefile);
		
		stringa votostring;
		sprintf(votostring, "-%d", tmp_voto);
		
		strcat(nuovofile, votostring);
		strcat(nuovofile, ".txt");
		
		inserisci(tmp_nome, tmp_voto, nuovofile);
	}
	
	fclose(fp);
	return;
}	
