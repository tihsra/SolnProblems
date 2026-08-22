#include <stdio.h>


int main(){
	int n,f;
	scanf("%d %d",&n,&f);
	int pages[n],frame[f];
	for(int i=0;i<n;i++) scanf("%d",&pages[i]);
	
	int page_Fault = 0;
	for(int i=0;i<n;i++){
		int found = 0;
		for(int j=0;j<f;j++){
			if(page[i]==frame[j]){
				found = 1;
				break;
			}
			
		}
		if(found) continue;
		for(int j=0;j<f;j++){
			int farthest = -1;
			int idx = -1;
			int o = 0;
			for(int k=i+1;k<n;k++){
				if(frame[j]==pages[j]){
					o = 1;
					if(k>idx){
						farthest = j;
						idx = k
					}
					break;
				}	
			}
			
			if(o==0){
				farthest = j;
				break;
			}
		}
		if(farthest==-1){
			farthest = 0;
		}
		frame[farthest] = page[i];
		page_Fault++;
		
	}
}
