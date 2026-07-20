#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t mutex,wrt;
int readcnt = 0;

void* reader(void* args){
	sem_wait(&mutex);
	readcnt++;
	if(readcnt==1){
		sem_wait(&wrt);
	}
	sem_post(&mutex);
	printf("The reader is reading\n");
	sem_wait(&mutex);
	readcnt--;
	if(readcnt==0){
		sem_post(&wrt);
	}
	sem_post(&mutex);	
}

void* writer(void* args){
	sem_wait(&wrt);
	printf("Writer is writing\n");
	sem_post(&wrt);
}

int main(){
	
	pthread_t read,write,read2;
	
	sem_init(&mutex,0,1);
	sem_init(&wrt,0,1);
	
	pthread_create(&write,NULL,writer,NULL);
	pthread_create(&read,NULL,reader,NULL);
	pthread_create(&read2,NULL,reader,NULL);

	pthread_join(read,NULL);
	pthread_join(read2,NULL);
	pthread_join(write,NULL);
	
	
	
}

