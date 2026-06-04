import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			int n = scn.nextInt();
			int m = scn.nextInt();
			
			int freq[] = new int[m];
			
			for(int i=0;i<n;i++){
				int temp = scn.nextInt();
				int moded = temp % m;
				freq[moded]++;
			}
			int ans = (freq[0]==0)?0:1;
			
			for(int i=1;i<m;i++){
				int rem = m-i;
				if(freq[rem]==0){
					ans += freq[i];
					freq[i]=0;
					continue;
				}
				
				if(freq[i]==freq[rem]){
					freq[i] = 0;
					freq[rem] = 0;
				}
				else if(freq[i]>freq[rem]){
					freq[i] -= freq[rem]+1;
					freq[rem] = 0;
				}
				else{
					freq[rem] -= freq[i]+1;
					freq[i] = 0;
				}
				
				ans+=freq[i]+1;
				freq[i] = 0;
			}
			
			
			// hasmap while itearting cannot do change
			// so use iterator or the above
			/*
			for(int i : hm.keySet()){
				
				if(i==0){
					ans+=1;
					continue;
				}
				
				int rem = m-i;
				
				int count_i = hm.get(i);
				
				if(!hm.containsKey(rem)){
					ans+=count_i;
					hm.remove(i);
				}
				else{
					int count_r = hm.get(rem);
					int remain = 0;
					if(count_r==count_i){
						hm.remove(rem);
						hm.remove(i);
					}
					else if(count_r>count_i){
						remain = count_r-count_i;
						hm.remove(i);
						hm.put(rem,remain);
					}
					else{
						remain = count_i-count_r;
						hm.remove(rem);
						hm.put(i,remain);
					}
					ans++;
				}
			}
			*/
			ps(ans);
			
		}
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
