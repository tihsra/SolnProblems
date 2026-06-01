#include <stdio.h>
#include <pthread.h>

#define max 10

int number[max];
int choosing[max];
int shared = 0;

int maxe(){
	int a = 0;
	for(int i=0;i<max;i++){
		if(a<number[i]) a = number[i];
	}
	return a;
}

void* bakery(void* args){
	int idx = *(int*)args;
	choosing[idx] = 1;
	number[idx] = 1+maxe();
	choosing[idx] = 0;
	for(int i=0;i<max;i++){
		while(choosing[i]);
		while(number[i]!=0&&(number[i]<number[idx]||(number[i]==number[idx]&&(i<idx))));
	}
	printf("%d Entering the critical section\n",idx);
	shared++;
	number[idx] = 0;
}


int main(){
	pthread_t p[max];
	int pid[max];
	for(int i=0;i<max;i++){
		number[i] = 0;
		choosing[i] = 0;
	}
	for(int i=0;i<max;i++){
		pid[i] = i;
		pthread_create(&p[i],NULL,bakery,&pid[i]);	
	}
	for(int i=0;i<max;i++){
		pthread_join(p[i],NULL);		
	}
}
