#include<stdio.h>
#include<stdlib.h>

int main()
{
    pid_t pid1 = fork();

	if(pid1 == 0)
	{
		printf("PID Figlio 1 = %d\n", getpid());
		system("./stampa_argv par1 pareo parazzo");
		return 0;
	}
	
	pid_t pid2 = fork();
	
	if(pid2 == 0)
	{
		pid_t pid3 = fork();
		
		if(pid3 > 0)
		{
			printf("PID Figlio 2 = %d\n", getpid());
			return 1;
		}
		else if(pid3 == 0)
		{
			printf("PID Figlio del Figlio 2 = %d\n", getpid());
			sleep(rand()%6);
			return 0;
		}
	}
	
	pid1 = wait();
	pid2 = wait();
	
	printf("Ordine di terminazione:\n1° %d\n2° %d\n", pid1, pid2);

	return 0;
}
