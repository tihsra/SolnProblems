import java.util.*;

public class Main{

	static HashMap<Long, Long>[] memo;

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while(t-->0){
			
			int n = scn.nextInt();

			long arr[] = new long[n];

			lnarr(arr,scn);

			long max[] = new long[n];

			long min[] = new long[n];

			min[0] = arr[0];
			
			max[0] = arr[0];

			long ans = arr[0];

			for(int i=1;i<n;i++){

				min[i] = arr[i] + Math.min(0,2*min[i-1]);

				max[i] = arr[i] + Math.max(0,2*max[i-1]);

				ans = Math.max(ans,arr[i] + Math.max(max[i-1],-min[i-1]));
			}

			ps(ans);



		}
	}

    public static long solve(long arr[], int i, long prevSum) {

        if (i>=arr.length) return Long.MIN_VALUE;

        Long memoAvail = memo[i].get(prevSum);

        if (memoAvail!=null) return memoAvail;

        long decre = Math.max(arr[i]-prevSum, solve(arr,i+1,arr[i]));

        long take = Math.max(arr[i], solve(arr,i+1, prevSum+arr[i]));

        long incre = Math.max(arr[i] + prevSum, solve(arr, i+1, arr[i]+2*prevSum));

        long res = Math.max(decre, Math.max(take,incre));

        memo[i].put(prevSum, res);

        return res;

    }

	static long MOD = 998244353L;
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

	static long factorialMod(long n){
		long result = 1L;
		for(long i = 2; i <= n; i++){
			result = result * (i % MOD) % MOD;
		}
		return result;
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
}