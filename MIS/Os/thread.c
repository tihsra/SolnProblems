#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

struct arr{
	int n;
	int a[100];
};

void* solver(void* args){
	struct arr b = *(struct arr*)args;
	int sum = 0;
	for(int i=0;i<b.n;i++){
		sum+= b.a[i];
	}	
	printf("%d\n",sum);
	int *res = malloc(sizeof(int));
	*res = sum;
	return res;
}

int main(){
	pthread_t thread1;
	struct arr pa;
	int n;
	scanf("%d",&n);
	pa.n = n;
	for(int i=0;i<n;i++){
		scanf("%d",&pa.a[i]);
	}
	pthread_create(&thread1,NULL,solver,&pa);
	void* ans;
	pthread_join(thread1,&ans);
	printf("%d\n",*(int*)ans);
	free(ans);
	
	
}
