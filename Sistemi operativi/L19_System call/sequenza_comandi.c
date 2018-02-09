#include<stdio.h>
#include<stdlib.h>

typedef char stringa[30];

int main()
{
    int i, ncomandi;
    
    do
    {
    printf("Quanti comandi vuoi? (MIN 0 MAX 20)\n");
    scanf("%d", &ncomandi);
    } while(ncomandi > 20 && ncomandi < 0);
    
    stringa comandi[ncomandi];
    
    for(i = 0; i < ncomandi; i++)
    {
        printf("Scrivi un comando:\n");
        scanf("%s", comandi[i]);
    }
    
    for(i = 0; i < ncomandi; i++)
    {
        pid_t pid = fork();
        
        // Padre
        if(pid > 0)
        {
            wait();
        }
        else if(pid == 0)
        {
            system(comandi[i]);
        }
    }
}
