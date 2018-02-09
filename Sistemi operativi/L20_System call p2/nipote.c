#include<stdio.h>
#include<stdlib.h>

int main()
{
    printf("Sono il primo processo padre\n");
    pid_t pid = fork();
    
    // Figlio
    if(pid == 0)
    {
        printf("Sono il processo figlio del primo padre\n");
        
        pid_t pid2 = fork();
        
        // Nipote
        if(pid2 == 0)
        {
            system("./stampa_info nipote");
            return 0;
        }
        // Figlio
        else if(pid2 > 0)
        {
            wait();
            return 0;
        }
    }
    // 1° Padre
    else if(pid > 0)
    {
        wait();
    }
    
    printf("Sono il secondo processo padre\n");
    pid_t pid3 = fork();
 
    // Figlio
    if(pid3 == 0)
    {
        system("./stampa_info figlio");
        return 0;
    }
    // 2° Padre
    else
    {
        wait();
        return 0;
    }
}
