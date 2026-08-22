import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = 1;
		while(t-->0){

			int n = scn.nextInt();

			long arr[] = new long[n];

			lnarr(arr,scn);

			long sum = 0L;

			long max = IMIN;

			int occ = 0;

			for(int i=0;i<n;i++){

				sum += arr[i];

				if(arr[i]>max){

					max = arr[i];
					occ = 1;
				}

				else if(arr[i]==max) occ++;

			}

			long temp = sum - 2*max;

			HashSet<Integer> hs = new HashSet<>();

			for(int i=0;i<n;i++){

				if(temp==max&&occ==1){
					break;
				}

				if(arr[i]==temp) hs.add(i+1);

			}

			sum = sum-max;

			long secMax = IMIN;

			for(int i=0;i<n;i++){
				if(arr[i]<max) secMax = Math.max(secMax,arr[i]);
			}
			
			sum = sum - secMax;

			if(sum==secMax){

				for(int i=0;i<n;i++) if(arr[i]==max) hs.add(i+1);

			}

			ps(hs.size());

			for(int i : hs) pns(i+" ");

			ps("");

		}
	}
	
	static int MOD = 1000000007;
	static int MOD_C = 998244353;
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
	static void mergeSort(long[]a){long[]t=new long[a.length];ms(a,t,0,a.length-1);}
	static void ms(long[]a,long[]t,int l,int r){
		if(l>=r)return;
		int m=(l+r)>>1;
		ms(a,t,l,m);ms(a,t,m+1,r);
		int i=l,j=m+1,k=l;
		while(i<=m&&j<=r)t[k++]=a[i]<=a[j]?a[i++]:a[j++];
		while(i<=m)t[k++]=a[i++];
		while(j<=r)t[k++]=a[j++];
		for(i=l;i<=r;i++)a[i]=t[i];
	}
	static long factorial(long n){if(n==1||n==0)return 1L;return ((n%MOD_C)*(factorial(n-1)%MOD_C))%MOD_C;}
}