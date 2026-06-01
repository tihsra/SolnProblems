#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>

int main(){
	
	int buf[2];
	char str[] = "Hello may god bless";
	char rec[100];
	pipe(buf);
	
	pid_t pid = fork();
	
	if(pid>0){
		close(buf[0]);
		write(buf[1],str,strlen(str)+1);
		printf("Parent wrote %s and has pid = %d\n",str,getpid());
		close(buf[1]);
		wait(NULL);
	}
	else if(pid==0){
		close(buf[1]);
		read(buf[0],rec,sizeof(rec));
		printf("Child receiver %s from parent with pid = %d\n",rec,getppid());
	}
	else printf("Fork got fucked\n");
	
	
	
	
}
