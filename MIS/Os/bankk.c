#include <stdio.h>

#define m 10

int main(){
	
	int n,r;
	scanf("%d %d",&n,&r);
	
	int alloc[m][m],max[m][m],need[m][m],available[m];
	
	for(int i=0;i<n;i++){
		for(int j=0;j<r;j++){
			scanf("%d",&alloc[i][j]);
		}
	}
	for(int i=0;i<n;i++){
		for(int j=0;j<r;j++){
			scanf("%d",&max[i][j]);
		}
	}
	for(int i=0;i<n;i++){
		for(int j=0;j<r;j++){
			need[i][j] = max[i][j] - alloc[i][j];
		}
	}
	
	bool done[m] = {false};
	int curr[m];
	int safeseq[m];
	
	for(int i=0;i<n;i++) curr[i] = available[i];
	
	int count = 0;
	
	while(count<n){
		bool flag = false;
		for(int i=0;i<n;i++){
			if(!done[i]){
				int j;
				for(j=0;j<r;j++){
					if(need[i][j]>work[j]) break;
				}
				if(j==r){
					flag = true;
					safeseq[count++] = i;
					done[i] = true;
					for(int k=0;k<r;k++){
						curr[k] += alloc[i][k];
					}
					
				}
			}
		}
		if(!flag){
			printf("No safe sequence found\n");
			break;
		}
		
	}
	
	
}
