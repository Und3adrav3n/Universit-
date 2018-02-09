#include <stdio.h>
#include <stdlib.h>

int main()
{
    pid_t pid;
    
    FILE *fp = fopen("test.txt", "w+");
    
    pid = fork();
    
    if(pid > 0)
    {
        printf("[padre] Inserimento stringa nel file\n");
        fprintf(fp, "Sono il padre\n");
        printf("[padre] Offset: %ld\n", ftell(fp));
        printf("[padre] Chiudo il file e lo cancello\n");
        fclose(fp);
        remove("test.txt");
        return 0;
    }
    else if(pid == 0)
    {
        printf("[figlio] Attendo 4 secondi\n");
        sleep(4);
        printf("[figlio] Offset: %ld\n", ftell(fp));
        fseek(fp, 0, SEEK_SET);
        
        printf("[figlio] Stampo il contenuto del file\n");
        char c = fgetc(fp);
        while(!feof(fp))
        {
            printf("%c", c);
            c = fgetc(fp);
        }
        
        printf("\n[figlio] Chiudo il file\n");
        fclose(fp);
        return 0;
    }
    else
    {
        perror("Error");
        return 2;
    }
}
