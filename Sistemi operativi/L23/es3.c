#include<stdio.h>
#include<stdlib.h>
#include<signal.h>

void handler(int sig)
{
	char c;
	
	printf("Forse hai premuto per sbaglio Ctrl-C?\nVuoi realmente sospendere l'esecuzione? [y/n]\n");
	scanf("%c", &c);
	
	if(c == 'y' || c == 'Y')
	{
		exit(0);
	}
	else
	{
		return;
	}
}

int main()
{
	signal(SIGINT, handler);
	while(1)
		pause();
}
