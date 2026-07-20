#include <stdio.h>
#include <pthread.h>

int flag[2] = {0,0};
int turn;
int shared = 0;

void* pet(void* args){
	int i = *(int*)args;
	int j = 1-i;
	flag[i] = 1;
	turn = j;
	while(turn==j&&flag[j]==1);
	printf("Entering the critical section\n");
	shared++;
	flag[i] = 0;
	return NULL;
}


int main(){
	pthread_t pid[2];
	int pida[2] = {0,1};
	for(int i=0;i<2;i++){
		pthread_create(&pid[i],NULL,pet,&pida[i]);
	}
	for(int i=0;i<2;i++){
		pthread_join(pid[i],NULL);		
	}
}


