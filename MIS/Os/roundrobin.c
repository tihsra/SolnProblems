#include <stdio.h>

typedef struct{
	int at,aat,bt,ct,rt,tat,wt;	
}Process;

int main(){
	int n,tq;
	scanf("%d %d",&n,&tq);
	Process p[n];
	for(int i=0;i<n;i++){
		scanf("%d %d",&p[i].at,&p[i].bt);
		p[i].rt = p[i].bt;
		p[i].aat = p[i].at;
	}
	int count = 0, time = 0;
	float avgTat = 0, avgWt = 0;
	
	while(count<n){
		int min_at = 1000000, idx = -1;
		for(int i=0;i<n;i++){
			if(p[i].aat<=time&&p[i].rt>0){
				if(p[i].aat<min_at){
					min_at = p[i].aat;
					idx = i;
				}
			}
		}
		
		if(idx==-1){
			time++;	
		}
		else{
			if(p[idx].rt>tq){
				p[idx].rt-=tq;
				time+=tq;
			}
			else{
				time+=p[idx].rt;
				p[idx].rt = 0;
			}
			if(p[idx].rt==0){
				p[idx].ct = time;
				p[idx].tat = p[idx].ct - p[idx].at;
				p[idx].wt = p[idx].tat - p[idx].bt;
				avgWt+=p[idx].wt;
				avgTat+=p[idx].tat;
				count++;
			}
			else{
				p[idx].aat = time;
			}
		}
	}
	for(int i=0;i<n;i++){
		printf("%d %d %d %d %d\n",p[i].at,p[i].bt,p[i].ct,p[i].tat,p[i].wt);	
	}
	printf("The avg tat = %.2f\n",avgTat/n);
	printf("The avg wt = %.2f\n",avgWt/n);

}
