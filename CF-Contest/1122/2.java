import java.util.*;

public class Main{

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while(t-->0){

			long alice = scn.nextLong();

			long bob = scn.nextLong();

			long third = scn.nextLong();

			long ans = Math.abs(alice-bob);

			ans = Math.max(ans,Math.abs(alice+third-bob));
			if(alice>bob&&(alice-bob)>=third) ans = Math.max(ans,Math.abs(alice-third-bob));

			ps(ans);
		}
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