#include <stdio.h>

int main(){
	int n,f;
	scanf("%d %d",&n,&f);
	int pages[n], frame[f], time[f];
	for(int i=0;i<n;i++)scanf("%d",&pages[i]);
	for(int i=0;i<f;i++){
		frame[i] = -1;
		time[i] = 0;
	}
	int pageFault = 0, times = 0;
	for(int i=0;i<n;i++){
		
		int flag = 0;
		for(int j=0;j<f;j++){
			if(frame[j]==pages[i]){
				time[j] = ++times;
				flag = 1;
				break;
			}
		}
		
		if(!flag){
			pageFault++;
			int lru_val = 100000, idx = -1;
			for(int k=0;k<f;k++){
				if(time[k]<lru_val){
					lru_val = time[k];
					idx = k;
				}
			}
			frame[idx] = pages[i];
			time[idx] = ++times;
		}
	}
	printf("The number of page faults is : %d",pageFault);
	return 0;
}
