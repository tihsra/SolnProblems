import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			
			int n = scn.nextInt();
			int target = scn.nextInt();
			
			int arr[] = new int[n];
			
			inarr(arr,scn);
			
			int pre[] = new int[n];
			int suf[] = new int[n];
			
			pre[0] = (arr[0]==1)?1:0;
			suf[n-1] = (arr[n-1]==1)?1:0;
			
			
			for(int i=1;i<n;i++){
				if(arr[i]==1) pre[i] = pre[i-1]+1;
				else pre[i] = pre[i-1];
			}
			
			int tbr = pre[n-1] - target;
			
			for(int i=n-2;i>=0;i--){
				if(arr[i]==1) suf[i] = suf[i+1]+1;
				else suf[i] = suf[i+1];
			}
			
			for(int i=0;i<n/2;i++){
				int temp = suf[i];
				suf[i] = suf[n-i-1];
				suf[n-i-1] = temp;
			}
			
			if(target<0||target>pre[n-1]){
				ps(-1);
			}
			else if(target==pre[n-1]){
				ps(0);
			}
			else{
				int ans = IMAX;
				for(int i=0;i<n;i++){
					int rem = tbr -  pre[i];
					//if(rem<0) break;
					if(rem==0){
						ans = Math.min((i+1),ans);
					}
					else{
						int ind = binary(suf,rem);
						if(ind!=-1){
							ans = Math.min((i+ind+2),ans);
						}
					}
				}
				for(int i=0;i<n;i++){
					int rem = tbr -  suf[i];
					//if(rem<0) break;
					if(rem==0){
						ans = Math.min((i+1),ans);
					}
					else{
						int ind = binary(pre,rem);
						if(ind!=-1){
							ans = Math.min((i+ind+2),ans);
						}
					}
				}
				
				ps(ans);
			}
		}
	}
	static int binary(int arr[], int i){
		int sp = 0;
		int ep = arr.length-1;
		int ans = IMAX;
		while(sp<=ep){
			int mid = sp + (ep-sp)/2;
			if(arr[mid]==i){
				ans = Math.min(mid,ans);
				ep = mid-1;
			}
			else if(arr[mid]>i){
				ep = mid-1;
			}
			else{
				sp = mid+1;
			}
		}
		return (ans==IMAX)?-1:ans;
	}
	static int MOD = 1000000007;
	static int IMAX = Integer.MAX_VALUE;
	static long LMAX = Long.MAX_VALUE;
	static int IMIN = Integer.MIN_VALUE;
	static long LMIN = Long.MIN_VALUE;
	static void ps(Object x){System.out.println(x);}
	static void pns(Object o){System.out.print(o);}
	static void inarr(int[] arr, Scanner scn){
		for(int i = 0; i < arr.length; i++){
			 int temp = scn.nextInt();
			 arr[i] = temp;
		}
	}
	static void lnarr(long[] arr, Scanner scn){
		for(int i = 0; i < arr.length; i++){
			long temp = scn.nextLong();
			arr[i] = temp;
		}
	}  
	static class Pair implements Comparable<Pair>{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pair o){
			return this.x-o.x;
		}
	}
	static class Tuple implements Comparable<Tuple>{
		int x;
		int y;
		int z;
		Tuple(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public int compareTo(Tuple o){
			return this.x-o.x;
		}
	}
	static long lcm(long a, long b){
		return (a*b)/gcd(a,b);
	}
	static long gcd(long a, long b){
		while(a!=0){
			long temp = a;
			a = b%a;
			b = temp;
		}
		return b;
	}
	static long sumfind(long start, long end){
		return ((end-start+1)*(end+start)/2);
	}
	static void mergeSort(int[]a){int[]t=new int[a.length];ms(a,t,0,a.length-1);}
	static void ms(int[]a,int[]t,int l,int r){
		if(l>=r)return;
		int m=(l+r)>>1;
		ms(a,t,l,m);ms(a,t,m+1,r);
		int i=l,j=m+1,k=l;
		while(i<=m&&j<=r)t[k++]=a[i]<=a[j]?a[i++]:a[j++];
		while(i<=m)t[k++]=a[i++];
		while(j<=r)t[k++]=a[j++];
		for(i=l;i<=r;i++)a[i]=t[i];
	}
}
