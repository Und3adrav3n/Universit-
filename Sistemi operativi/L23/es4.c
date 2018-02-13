#include<stdio.h>
#include<stdlib.h>
#include<signal.h>
#include<unistd.h>
#include<wait.h>

#define N 10

void handler(int sig)
{
	if(sig == SIGUSR1)
	{
		printf("Attivazione!\n");
	}
	else
	{
		printf("Morto!\n");
		exit(0);
	}
}

int main(int argc, char* argv[])
{
	pid_t pid;
	pid_t pid_padre = getpid();
	int i = 1, status;
	
	do
	{
		pid = fork();
		
		if(pid < 0)
		{
			printf("ERROR");
			exit(1);
		}
		
		printf("PID: %d\n", pid);

		if(pid == 0)
		{
			printf("%d: Sono stato creato!\n", pid);
			signal(SIGUSR1, handler);
			signal(SIGUSR2, handler);
			pause();
			printf("%d: Sono stato attivato!\n", pid);
			system(argv[i]);
			exit(0);
		}
		else
		{
			sleep(2);
			if(pid_padre % 2 == 0)
			{
				if(pid % 2 == 0){
					kill(pid, SIGUSR1);
					printf("%d: Attivo %d\n", pid_padre, pid);
				}
				else
				{
					kill(pid, SIGUSR2);
					printf("%d: Uccido %d\n", pid_padre, pid);
				}
			}
			else
			{
				if(pid % 2 != 0)
				{
					kill(pid, SIGUSR1);
					printf("%d: Attivo %d\n", pid_padre, pid);
				}
				else
				{
					kill(pid, SIGUSR2);
					printf("%d: Uccido %d\n", pid_padre, pid);
				}
			}
			waitpid(pid, &status, 0);
			printf("Status %d° Figlio: %d\n", i, status);
		}
		i++;
	} 
	while((i < argc) && (pid_padre != getppid()));

	return 0;
	
}
