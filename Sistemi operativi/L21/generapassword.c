#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<crypt.h>
#include <unistd.h>

typedef char stringa[30];

int main()
{
	stringa password;
	printf("Inserisci una password:\n");
	scanf("%s", password);
	
	stringa passwordcriptata;
	stringa primeDueLettere;
	memcpy(primeDueLettere, password, 2);
	strcpy(passwordcriptata,crypt(password, primeDueLettere));
	printf("password criptata: %s", passwordcriptata);
}
