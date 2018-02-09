#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef char stringa[100];

int main(int argc, char *argv[])
{
	int i;
	for(i = 0; i < argc; i++)
	{
		printf("Procedo con il file '%s'\n", argv[i]);
		
		pid_t pid = fork();
		
		if(pid == 0)
		{
			stringa eseguibile;
			get_name(argv[i], eseguibile);
		
			pid_t pid2 = fork();	
			
			if(pid2 == 0)
			{
				//								  comando
				stringa comando;				//
				strcpy(comando, "gcc ");		//gcc 
				strcat(comando, argv[i]);		//gcc nomefile.c 
				strcat(comando, " -o ");		//gcc nomefile.c -o 
				strcat(comando, eseguibile);	//gcc nomefile.c -o nomefile
				system(comando);
				return 0;
			}
			else if(pid2 > 0)
			{
				system(eseguibile);
			}
		}
		
		wait();
	}
}			
			
void get_name(stringa a, stringa b)
{
	int i = 0;
	while(a[i] != '.')
	{
		b[i] = a[i];
		i++;
	}
}
