#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef char stringa[30];

typedef struct nodo 
{
	stringa info;
	struct nodo *next;
} lista;

typedef lista *plist;

void aggiungi_in_testa(plist treni, stringa treno)
{
	plist tmp = malloc(sizeof(lista));
	strcpy(tmp->info, treno);
	tmp->next = treni;
	treni = tmp;
}

int main(int argc, char *argv[])
{
	plist treni_ic;
	plist treni_es;
	plist treni_rg;
	
	int i;
	for(i = 1; i <= argc; i++)
	{
		pid_t pid = fork();
		
		stringa treno;
		strcpy(treno, argv[i]);
		
		if(pid == 0)
		{
			int lunstringa = strlen(treno);
			
			if(lunstringa > 6)
			{
				printf("%s: treno non consentito\n", treno);
				return 2;
			}
			
			stringa tipotreno;
			stringa idtreno;
			
			memcpy(tipotreno, treno, 2);
			strcpy(idtreno, &treno[2]);
			
			if(!(strcmp(tipotreno, "ic") == 0 ||
				strcmp(tipotreno, "es") == 0 ||
				strcmp(tipotreno, "rg") == 0))
			{
				printf("%s: treno non consentito\n", treno);
				return 2;
			}
			
			if(strcmp(tipotreno, "ic") == 0)
				aggiungi_in_testa(treni_ic, treno);
			if(strcmp(tipotreno, "es") == 0)
				aggiungi_in_testa(treni_es, treno);
			if(strcmp(tipotreno, "rg") == 0)
				aggiungi_in_testa(treni_rg, treno);
			
			printf("%s: treno consentito\n", treno);
			return 0;
		}
		else if(pid > 0)
		{
			wait();
		}
	}
	
	plist tmp = treni_ic;
	while(tmp != NULL)
	{
		printf("%s ", tmp->info);
		tmp = tmp->next;
	}
	printf("\n");
	
	tmp = treni_es;
	while(tmp != NULL)
	{
		printf("%s ", tmp->info);
		tmp = tmp->next;
	}
	printf("\n");
	
	tmp = treni_rg;
	while(tmp != NULL)
	{
		printf("%s ", tmp->info);
		tmp = tmp->next;
	}
	printf("\n");
}
