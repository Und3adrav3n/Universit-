#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(int argc, char *argv[])
{
    if(strcmp(argv[1], "nipote") == 0)
        printf("Sono il nipote del primo padre\n");
    else if(strcmp(argv[1], "figlio") == 0)
        printf("Sono il figlio del secondo padre\n");
    else
    {
        perror("Lol!");
        return 2;
    }
    return 0;
}
