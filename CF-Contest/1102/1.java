import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			
			int n = scn.nextInt();
			
			TreeSet<Long> hs = new TreeSet<>(Collections.reverseOrder());
			
			if(n<3){
				
				long arr[] = new long[n];
				int i = 0;
				
				while(i<n){
					arr[i] = scn.nextLong();
					i++;
				}
				
				Arrays.sort(arr);
				
				i=n-1;
				
				while(i>=0){
					pns(arr[i]+" ");
					i--;
				}
				
				ps("");
				continue;
			}
			
			boolean isDupe = false;
			for(int i=0;i<n;i++){
				long temp = scn.nextLong();
				
				if(hs.contains(temp)){
					isDupe = true;
				}
				
				hs.add(temp);
			}
			
			if(isDupe){
				ps(-1);
				continue;
			}
			
			long count = 0;
			
			long fir = -1;
			long sec = -1;
			
			boolean complete = true;
			
			for(long i  : hs){
				
				if(fir == -1) fir = i;
				else if(sec == -1) sec = i;
				else break; 
				
			}
			
			long ans[] = new long[n];
			
			ans[0] = fir;
			ans[1] = sec;
			
			for(int i=2;i<n;i++){
				if(hs.contains(ans[i-2]%ans[i-1])){
					ans[i] = ans[i-2]%ans[i-1];
				}
				else{
					complete = false;
					break;
				}
			}
			
			if(complete){
				ps(ans[0]+" "+ans[1]);
			}
			else ps(-1);
			
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
			arr[i] = scn.nextInt();
		}
	}
	static void lnarr(long[] arr, Scanner scn){
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextLong();
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
