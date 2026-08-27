import java.util.*;
public class Main{

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while(t-->0){

			int n = scn.nextInt();

			int segment[][] = new int[n][2];

			int max = IMIN;

			for(int i=0;i<n;i++){

				arr[i][0] = scn.nextInt();
				arr[i][1] = scn.nextInt();

				min = Math.min(min, arr[i][0]);
				max = Math.max(max, arr[i][0]);

			}

			int sp = 0;

			int ep = max;

			int ans = 0;

			while(sp<=ep){

				int mid = sp + (ep-sp)/2;

				if(stubCheck(segment,mid,n)<n){
					
					sp = mid+1;

				}
				else{

					ep = mid-1;

					ans = mid;

				}

			}

			ps(ans);

		}

		
	}

	static int stubCheck(int segment[][], int number, int n){

		int sp = 0, ep = 0;

		int curr = 0;

		for(int i=0;i<n;i++){

			if(segment[i][0]>ep){ // not reaching case


			}
			else{

				sp = Math.max(segment[i][0],ep-n);
				ep = Math.min(segment[i][1],ep+n);


			}

			if(segment[i][1]<sp){


			}
			else{

				ep 
			}




		}

		return ans;

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
			return o.y-this.y;
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
