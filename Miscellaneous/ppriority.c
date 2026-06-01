#include <stdio.h>

typedef struct{
	int at;
	int bt;
	int ct;
	int wt;
	int tat;
	int prio;
	int done;
}Process;

int main(){
	int n;
	printf("Enter the number of Processes\n");
	scanf("%d",&n);
	
	Process p[n];
	for(int i=0;i<n;i++){
		printf("For process %d, enter the at, bt, priority\n",i+1);
		scanf("%d %d %d",&p[i].at,&p[i].bt,&p[i].prio);
		p[i].done = 0;
	}
	float avgTat=0, avgWt=0;
	int time=0, count = 0;
	
	while(count<n){
		
		int min_pt = 1000000, idx = -1;
		
		for(int i=0;i<n;i++){
			if(p[i].at<=time&&p[i].done==0){
				if(min_pt>p[i].prio){
					min_pt = p[i].prio;
					idx = i;
				}
			}
		}
		if(idx==-1){
			time++;
		}
		else{
			if(p[idx].at>time) time = p[idx].at;
			time += p[idx].bt;
			p[idx].ct = time;
			p[idx].tat = p[idx].ct - p[idx].at;
			p[idx].wt = p[idx].tat - p[idx].bt;
			p[idx].done = 1;
			count++;
			avgTat+=p[idx].tat;
			avgWt+=p[idx].wt;
		}	
	}
	for(int i=0;i<n;i++){
		printf("%d %d %d %d %d\n",p[i].at,p[i].bt,p[i].ct,p[i].tat,p[i].wt);	
	}
	printf("The avg tat = %.2f\n",avgTat/n);
	printf("The avg wt = %.2f\n",avgWt/n);
}
