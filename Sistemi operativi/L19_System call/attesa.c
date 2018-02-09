#include <stdio.h>
#include<stdlib.h>

int main()
{
    pid_t pid;
    
    pid = fork();
    
    // Padre
    if(pid > 0)
    {
        printf("Sono il padre e sto aspettando mio figlio\n");
        
        int status;
        pid_t pidf;
        pidf = wait(&status);
        
        printf("Mio figlio è morto! Lunga vita a mio figlio!\n");
        printf("Figlio: %d, Status: %d\n", pidf, WEXITSTATUS(status));
        return 0;
    }
    // Figlio
    else if(pid == 0)
    {
        printf("PID figlio: %d, PID padre: %d\n", getpid(), getppid());
        return 24;
    }
    else
    {
        perror("Error");
        return 2;
    }
}
