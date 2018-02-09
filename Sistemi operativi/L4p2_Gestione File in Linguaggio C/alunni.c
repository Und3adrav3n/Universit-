#include<stdio.h>
#include<stdlib.h>
#include<string.h>

main()
{
	char matr[20];
	char matr2[20];

	int esami;
	
	long pos;

	printf("Quale matricola deve aver aggiunto un esame?");
	scanf("%s", matr);

	FILE *fp = fopen("alnni.txt", "r+");

	if(fp == NULL)
		printf("Il file non esiste");

	while(!feof)
	{
		pos = ftell(fp);
		fscanf(fp, "%s %d\n", matr2, esami);

		if(strcmp(matr, matr2) == 0)
		{
			esami++;

			fseek(fp, pos, SEEK_SET);
			fprintf(fp, "%s %d\n", matr2, esami);
			break;
		}
	}
	fclose(fp);
	return 0;
}
