#include <stdio.h>
#include <semaphore.h>
#include <pthread.h>
#include <unistd.h>

#define max 2
#define t 0
#define h 1
#define e 2

int state[max];
sem_t mutex, s[max];

void test(int i){
	if(state[i]==h&&state[(i+1)%max]!=e&&state[(i+max-1)%max]!=e){
		state[i] = e;
		sem_post(&s[i]);
	}
}

void take_fork(int i){
	sem_wait(&mutex);
	state[i] = h;
	printf("The philospher %d is hungry\n",i);
	test(i);
	sem_post(&mutex);
	sem_wait(&s[i]);
	
}

void put_fork(int i){
	sem_wait(&mutex);
	state[i] = t;
	test((i+1)%max);
	test((i+max-1)%max);
	sem_post(&mutex);
}

void* philospher(void* args){
	int id = *(int*)args;
	while(1){
		printf("The philospher %d is thinking\n",id);
		sleep(5);
		take_fork(id);
		printf("The philospher %d is eating\n",id);
		sleep(10);
		put_fork(id);
	}
}

int main(){
	pthread_t phil[max];
	int philid[max];
	
	sem_init(&mutex,0,1);
	for(int i=0;i<max;i++){
		sem_init(&s[i],0,0);
		state[i] = 0;
	}
	
	for(int i=0;i<max;i++){
		philid[i] = i;
		pthread_create(&phil[i],NULL,philospher,&philid[i]);
	}
	for(int i=0;i<max;i++){
		pthread_join(phil[i],NULL);
	}	
}
