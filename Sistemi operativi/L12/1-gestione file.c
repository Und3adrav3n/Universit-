#include<*.h>

typedef char stringa[30];

int modificaColore(stringa nome_file, stringa colore_corrente, stringa colore_nuovo)
{
	FILE* fp = fopen(nome_file, "w+");
	int cont = 0;

	while(!feof(fp))
	{
		long pos = ftell(fp);
		 
		stringa n, c1, c2, c3;
		fscanf(fp, "%s %s %s %sn", n, c1, c2, c3);
		
		if(strcmp(c1, colore_corrente) == 0)
		{
			c1 = colore_nuovo;
			cont++;
		}
		if(strcmp(c2, colore_corrente) == 0)
		{
			c2 = colore_nuovo;
			cont++;
		}
		if(strcmp(c3, colore_corrente) == 0)
		{
			c3 = colore_nuovo;
			cont++;
		}
		
		fseek(fp, pos, SEEK_SET);
		
		fprintf(fp, "%s %s %s %sn", n, c1, c2, c3);
	}
	
	fclose(fp);
	return cont;
}
 
