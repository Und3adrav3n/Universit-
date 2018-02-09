#include <stdlib.h>
#include <stdio.h>

typedef char stringa[30];

int main()
{
    
    while(1)
    {
		stringa comando;
		printf("myshell# ");
		scanf("%s", comando);
		
		pid_t pid = fork();
		
		if(pid==0){
			system(comando);
			return 0;
		}
		else
			wait();		
    }
}
