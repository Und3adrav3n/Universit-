#include<stdio.h>
#include<stdlib.h>

typedef char stringa[30];

int main()
{
    int ncomandi;
    
    do
    {
        printf("Quanti comandi?\n");
        scanf("%d", &ncomandi);
    } while(ncomandi < 0 && ncomandi > 20);
    
    stringa comandi[ncomandi];
    
    int i;
    for(i = 0; i < ncomandi; i++)
    {
        printf("Scrivi un comando:\n");
        scanf("%s", comandi[i]);
    }
    
    ricorsione_comandi(comandi);
}

void ricorsione_comandi(stringa *comandi)
{
    
