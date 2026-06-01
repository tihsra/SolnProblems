#include <stdio.h>

typedef struct{
	int at,bt,ct,rt,pt,tat,wt;
}Process;

int main(){
	int n;
	scanf("%d",&n);
	Process p[n];
	for(int i=0;i<n;i++){
		scanf("%d %d %d",&p[i].at,&p[i].bt,&p[i].pt);
		p[i].rt = p[i].bt;
	}	
	int count = 0, time = 100000;
	float avgTat = 0, avgWt = 0;
	for(int i=0;i<n;i++){
		if(time>p[i].at){
			time = p[i].at;
		}
	}
	while(count<n){
		int min_pt = 1000000, idx = -1;
		for(int i=0;i<n;i++){
			if(p[i].at<=time&&p[i].rt>0){
				if(min_pt>p[i].pt){
					min_pt = p[i].pt;
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
				p[idx].wt  = p[idx].tat - p[idx].bt;
				avgTat+=p[idx].tat;
				avgWt+=p[idx].wt;
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
