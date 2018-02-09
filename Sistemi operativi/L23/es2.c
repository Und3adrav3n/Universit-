#include<stdio.h>
#include<stdlib.h>
#include<signal.h>

void handler(int sig)
{
	printf("Terminated");
	exit(0);
}

int main()
{
	signal(SIGINT, handler);
	
	while(1)
	{
		printf("Hello World!\n");
		sleep(1);
	}
	return 0;
}
