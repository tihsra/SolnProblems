#include <stdio.h>

typedef struct{
	int at;
	int bt;
	int ct;
	int wt;
	int tat;
	int done;
}Process;

int main(){
	int n;
	printf("Enter the number of Processes\n");
	scanf("%d",&n);
	
	Process p[n];
	for(int i=0;i<n;i++){
		printf("For process %d, enter the at, bt\n",i+1);
		scanf("%d %d",&p[i].at,&p[i].bt);
		p[i].done = 0;
	}
	float avgTat=0, avgWt=0;
	int time=0, count = 0;
	
	while(count<n){
		int min_bt = 1000000, idx = -1;
		
		for(int i=0;i<n;i++){
			if(p[i].at<=time&&p[i].done==0){
				if(p[i].bt<min_bt){
					min_bt = p[i].bt;
					idx = i;
				}			
			}
		}
		
		if(idx==-1){
			time++;
		}
		else{
			if(time<p[idx].at) time = p[idx].at;
			time = time + p[idx].bt;
			p[idx].ct = time;
			p[idx].tat = p[idx].ct - p[idx].at;
			p[idx].wt = p[idx].tat - p[idx].bt;
			avgTat+=p[idx].tat;
			avgWt+=p[idx].wt;
			p[idx].done = 1;
			count++;
		}
	} 
	for(int i=0;i<n;i++){
		printf("%d %d %d %d %d\n",p[i].at,p[i].bt,p[i].ct,p[i].tat,p[i].wt);	
	}
	printf("The avg tat = %.2f\n",avgTat/n);
	printf("The avg wt = %.2f\n",avgWt/n);
}
