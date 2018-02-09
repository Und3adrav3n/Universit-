#include <stdio.h>
#include <stdlib.h>

int main()
{
    pid_t pid;
    int i;
    
    for(i = 0; i < 10; i++)
    {
        pid = fork();
        
        // Padre
        if(pid > 0)
        {
            int status;
            wait(&status);
            
            printf("Status %d° figlio: %d\n", i+1, WEXITSTATUS(status));
        }
        // Figlio
        else if(pid == 0)
        {
            sleep(1);
            printf("Figlio numero %d\n", i+1);
            
            sleep(1);
            return 100+i+1;
        }
        // Errore
        else
        {
            perror("Error");
            return 2;
        }
    }
    return 0;
}
        
