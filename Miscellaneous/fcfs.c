#include <stdio.h>

typedef struct{
	int at;
	int bt;
	int ct;
	int wt;
	int tat;
}Process;

int main(){
	int n;
	printf("Enter the number of Processes\n");
	scanf("%d",&n);
	
	Process p[n];
	for(int i=0;i<n;i++){
		printf("For process %d, enter the at, bt\n",i+1);
		scanf("%d %d",&p[i].at,&p[i].bt);
	}
	
	for(int i=0;i<n-1;i++){
		for(int j=0;j<n-1-i;j++){
			if(p[j].at>p[j+1].at){
				Process temp = p[j];
				p[j] = p[j+1];
				p[j+1] = temp;
			}
		}
	}
	
	float avgTat = 0, avgWt = 0;
	int time = 0;
	
	for(int i=0;i<n;i++){
		if(time<p[i].at) time = p[i].at;
		
		time = time + p[i].bt;
		p[i].ct = time;
		p[i].tat = p[i].ct - p[i].at;
		p[i].wt =  p[i].tat - p[i].bt;
		
		avgTat+=p[i].tat;
		avgWt+=p[i].wt;	
	}
	
	for(int i=0;i<n;i++){
		printf("%d %d %d %d %d\n",p[i].at,p[i].bt,p[i].ct,p[i].tat,p[i].wt);	
	}
	printf("The avg wt = %.2f\n",avgTat/n);
	printf("The avg tat = %.2f\n",avgWt/n);
}
