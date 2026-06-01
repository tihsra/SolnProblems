#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t mutex, wrt;
int readercnt = 0;

void* reader(void* args){
	int id = *(int*)args;

	// ENTRY
	sem_wait(&mutex);
	readercnt++;
	if(readercnt == 1){
		sem_wait(&wrt);
	}
	sem_post(&mutex);

	// CRITICAL SECTION
	printf("Reader %d is reading\n", id);
	// EXIT
	sem_wait(&mutex);
	readercnt--;
	if(readercnt == 0){
		sem_post(&wrt);
	}
	sem_post(&mutex);

	return NULL;
}

void* writer(void* args){
	int id = *(int*)args;

	sem_wait(&wrt);
	sleep(10);
	printf("Writer %d is writing\n", id);
	sem_post(&wrt);

	return NULL;
}

int main(){
	sem_init(&mutex, 0, 1);
	sem_init(&wrt, 0, 1);

	pthread_t r1, r2, w1, w2;
	int rid[2] = {1,2};
	int wid[2] = {1,2};

	pthread_create(&w1, NULL, writer, &wid[0]);
	pthread_create(&w2, NULL, writer, &wid[1]);
	pthread_create(&r1, NULL, reader, &rid[0]);
	pthread_create(&r2, NULL, reader, &rid[1]);

	pthread_join(r1, NULL);
	pthread_join(r2, NULL);
	pthread_join(w1, NULL);
	pthread_join(w2, NULL);

	return 0;
}
