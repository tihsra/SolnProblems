#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int sum(int n){
	return (n*(n+1))/2;
	
}

int main(){
	int n,sum1=-1;
	scanf("%d",&n);
	pid_t child = fork();
	
	if(child==0){
		sum1 = sum(n);
		printf("%d",sum1);
	}
	else{
		waitpid(child,NULL,0);
		printf("%d",sum1);		
	}
}

/*
int main(){
		int pid = fork();
		
		if(pid==0){
			printf("Hi from children\n");
			printf("%d is the PPID\n",getppid());
			printf("%d is the PID\n",getpid());
		}
		else if(pid>0){
			waitpid(pid,NULL,0);
			printf("Hi from parent\n");
			printf("%d is the PID\n",getpid());
		}
		else{
			printf("Error occoured\n");
		}
}
*/

