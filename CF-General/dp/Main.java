import java.util.*;

public class Main{

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int t = 1;

		while(t-->0){

			int n = scn.nextInt();

			int arr[] = new int[n];

			inarr(arr,scn);
			
			solve(n,arr);

		}

	}

	public static void solve(int n, int[] arr){

		int memo[] = new int[n];

		Arrays.fill(memo,-1);

		ps(solver(n,arr,0,memo));


	}

	public static int solver(int n, int arr[], int idx, int memo[]){

		if(idx>=n) return 0;

		if(memo[idx]!=-1) return memo[idx];

		int max = IMIN;

		int sum = 0;

		int curr_sum = 0;

		int ans = IMIN;

		for(int i=idx;i<n;i++){

			max = Math.max(max, arr[i]);

			
			if(curr_sum<0){ 

				curr_sum = 0;

				max = arr[i];

			}

			if((curr_sum-max)<0){ 

				ans = solver(n,arr,i+1,memo);

				if(i+1<n) memo[i+1] = ans;

			}


			curr_sum += arr[i];


			sum = Math.max(sum,Math.max(ans, curr_sum-max));

		}

		memo[idx] = sum;

		return memo[idx];

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
