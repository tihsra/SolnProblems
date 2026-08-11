import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			
			int n = scn.nextInt();
			int times = scn.nextInt();
			int arr[] = new int[n];

			inarr(arr,scn);

			solve(n,arr,times);
			
		}
	}

	public static void solve(int n, int arr[], int times){


		int memo[][][] = new int[n][2][times+1];

		for(int mainArr[][] : memo) for(int subArr[]: mainArr) Arrays.fill(subArr,-1); // needed in order to check visited or not 

		ps(solver(n,arr,times,0,1,memo)); 

	}

	public static int solver(int n, int arr[], int times, int idx, int buy, int[][][] memo){


		//bc 

		if(idx>=n||times==0){
			return 0;
		}

		// we say if i completed a trn then
		// find from the next idx coz till here is we made some t transaction already and they are maximum we could 
		// therefore cannot find another trn there
		// have to track buy/sell state also for obvious reason

		// have to memoize because the tc there is 2^n 

		// what is needed to memoize
		// track idx, buy?, times

		if(memo[idx][buy][times]!=-1) return memo[idx][buy][times];

		if(buy==1){  //denotes we could buy

			int buyIt = solver(n,arr,times,idx+1,0,memo)-arr[idx];
			int notBuyIt = solver(n,arr,times,idx+1,1,memo);

			memo[idx][buy][times] = Math.max(buyIt,notBuyIt);
			return memo[idx][buy][times];

		}

		int sellIt = solver(n,arr,times-1,idx+1,1,memo)+arr[idx];
		int notSellIt = solver(n,arr,times,idx+1,0,memo);

		memo[idx][buy][times] = Math.max(sellIt,notSellIt);

		return memo[idx][buy][times];

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
			return Integer.compare(this.x, o.x);
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
}
