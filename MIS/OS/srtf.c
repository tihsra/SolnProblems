#include <stdio.h>

typedef struct{
	int at;
	int bt;
	int rt;
	int ct;
	int tat;
	int wt;
}Process;

int main(){
	int n;
	scanf("%d",&n);
	Process p[n];
	for(int i=0;i<n;i++){
		scanf("%d %d",&p[i].at,&p[i].bt);
		p[i].rt = p[i].bt;
	}
	int count=0, time=100000;
	float avgWt=0, avgTat=0;
	for(int i=0;i<n;i++){
		if(time>p[i].at){
			time = p[i].at;
		}
	}
	while(count<n){
		int min_rt = 100000, idx = -1;
		for(int i=0;i<n;i++){
			if(p[i].at<=time&&p[i].rt>0){
				if(min_rt>p[i].rt){
					min_rt =p[i].rt;
					idx = i;
				}
			}
		}
		
		if(idx==-1){
			time++;
		}
		else{
			time++;
			p[idx].rt--;
			if(p[idx].rt==0){
					p[idx].ct = time;
					p[idx].tat = p[idx].ct - p[idx].at;
					p[idx].wt = p[idx].tat - p[idx].bt;
					avgWt+=p[idx].wt;
					avgTat+=p[idx].tat;
					count++;
			}
		}
	}
	for(int i=0;i<n;i++){
		printf("%d %d %d %d %d\n",p[i].at,p[i].bt,p[i].ct,p[i].tat,p[i].wt);	
	}
	printf("The avg tat = %.2f\n",avgTat/n);
	printf("The avg wt = %.2f\n",avgWt/n);
}
