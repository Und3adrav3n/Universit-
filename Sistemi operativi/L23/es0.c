#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include<stdlib.h>

int val = 10;

void handler(int sig)
{
	val += 8;
}

int main()
{
	pid_t pid;
	
	signal(SIGCHLD, handler);
	if((pid = fork()) == 0)
	{
		val -= 3;
		return 0;
	}
	
	waitpid(pid, NULL, 0);
	printf("val = %d\n", val);
	return 0;
}
