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

		ps(solver(n,arr,times)); 

	}

	public static int solver(int n, int arr[], int times){

		int memo[][][] = new int[n+1][2][times+1];

		for(int i=0;i<=n;i++){ //  BC FOR TIMES = 0
			
			memo[i][0][0] = 0;// sell 

			memo[i][1][0] = IMIN/2;// buy 

		}

		for(int i=0;i<=times;i++){

			memo[0][0][i] = 0;

			memo[0][1][i] = IMIN/2;

		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=times;j++){


				// Buy case:

				// why shift transaction here becasue we will ask previoous state
				// if this state is buy mening we have completed a transation in during the before
				// becasue we are thinking in reverse here have to keep this in mind

				int buyIt = memo[i-1][0][j-1]-arr[i-1]; 
				int notBuyIt = memo[i-1][1][j];
				
				memo[i][1][j] = Math.max(buyIt, notBuyIt);

				// Sell case:

				int sellIt = memo[i-1][1][j]+arr[i-1];
				int notSellIt = memo[i-1][0][j];
				
				memo[i][0][j] = Math.max(sellIt, notSellIt);

			}
		} 

		return memo[n][0][times];

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
