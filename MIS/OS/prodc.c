#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define max 20

int buffer[max];
int in = 0, out = 0;

sem_t empty, full;
pthread_mutex_t mutex;

void* producer(void* args){
	int i = 0;
	while(i<20){
		i++;
		sem_wait(&empty);
		pthread_mutex_lock(&mutex);
		buffer[in] = i;
		in = (in + 1)%max;
		printf("Producer produced %d item\n",i);
		pthread_mutex_unlock(&mutex);
		sem_post(&full);
		sleep(1);	
	}
}

void* consumer(void* args){
	int i = 0;
	while(i<20){
		sem_wait(&full);
		pthread_mutex_lock(&mutex);
		printf("Consumer consumed %d item\n",buffer[out]);
		out = (out + 1)%max;		
		pthread_mutex_unlock(&mutex);
		sem_post(&empty);
		i++;
		sleep(5);
	}	
}


int main(){
	pthread_t prod, cons;
	sem_init(&empty,0,max);
	sem_init(&full,0,0);
	pthread_mutex_init(&mutex,NULL);
	pthread_create(&prod,NULL,producer,NULL);
	pthread_create(&cons,NULL,consumer,NULL);
	pthread_join(prod,NULL);
	pthread_join(cons,NULL);
	return 0;
}
