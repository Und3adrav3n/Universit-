#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef char stringa[100];

int main(int argc, char *argv[])
{
    int i;
	for(i = 0; i < argc; i++)
    {
        if(i == 0)
            printf("Nome del programma: %s\n", argv[i]);
        else
            printf("Parametro numero %d: %s\n", i, argv[i]);
    }
    return 0;
}
