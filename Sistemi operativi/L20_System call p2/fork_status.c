#include<stdio.h>
#include<stdlib.h>

int main()
{
	pid_t pid = fork();
	
	// Figlio
	if(pid == 0)
	{
		printf("CHILD: Sono un processo figlio\n");
		printf("CHILD: Pid = %d, parent Pid = %d\n", getpid(), getppid());
		printf("Indicare codice uscita:\n");
		int codice;
		scanf("%d", &codice);
		return codice;
	}
	else if(pid > 0)
	{
		sleep(5);
		printf("PARENT: Sono il processo padre\n");
		printf("PARENT: Pid = %d, child Pid = %d\n", getpid(), pid);
		printf("PARENT: Aspetto mio figlio finisca\n");
		int status;
		wait(&status);
		printf("PARENT: Status del processo figlio appena finito: %d\n", WEXITSTATUS(status));
		return 0;
	}
	else
	{
		perror("Error");
		return 2;
	}
}
