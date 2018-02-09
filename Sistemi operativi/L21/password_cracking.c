#include<stdlib.h>
#include<stdio.h>
#include<string.h>

typedef char stringa[30];

int main()
{
	stringa passwordcifrata;
	
	printf("Dammi la password cifrata.\n");
	scanf("%s", passwordcifrata);
	
	pid_t pid = fork();
	
	if(pid == 0)
	{
		execl("./password_cracking_crypt", "./password_cracking_crypt", passwordcifrata, "dictionary.txt", passwordcifrata[0]);
		
		
