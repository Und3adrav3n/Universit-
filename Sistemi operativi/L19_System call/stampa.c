#include<stdio.h>
#include<stdlib.h>

int main()
{
    // Dichiarazione
    pid_t pid;
    
    // Creo figlio
    pid = fork();
    
    // Padre
    if(pid < 0)
    {
        perror("Error");
        return 2;
    }
    else if(pid > 0)
    {
        printf("Sono il processo padre\n");
        return 0;
    }
    // Figlio
    else
    {
        printf("Sono il proesso figlio\n");
        exit(0);
    }
}    
