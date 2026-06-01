#include <stdio.h>

int main(){
	int n,f;
	scanf("%d %d",&n,&f);
	int pages[n];
	for(int i=0;i<n;i++) scanf("%d",&pages[i]);
	
	int frame[f];
	for(int i=0;i<f;i++) frame[i] = -1;
	
	int pos = 0, page_fault = 0;
	for(int i=0;i<n;i++){
		int flag = 0;
		for(int j=0;j<f;j++){
			if(pages[i]==frame[j]){
				flag = 1;
				break;
			}
		}
		if(!flag){
			page_fault++;
			printf("Page fault at index %d\n",i);
			frame[pos] = pages[i];
			pos = (pos+1)%f;
		}
	}
	printf("%d\n",page_fault);
}

