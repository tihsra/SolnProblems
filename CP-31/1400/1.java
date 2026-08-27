import java.util.*;
public class Main{

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while(t-->0){

			int n = scn.nextInt();

			int m = scn.nextInt();

			Pair number[] = new Pair[n];

			for(int i=0;i<n;i++){

				int temp = scn.nextInt();

				int digitCnt = stubCntDigit(temp);

				int zerosCnt = stubCntZeros(temp);

				number[i] = new Pair(digitCnt,zerosCnt);
			}

			
			Arrays.sort(number);

			int ans = 0;

			for(int i=0;i<n;i++){

				int temp = 0;

				if(i%2==0){

					temp += number[i].x - number[i].y;

				}

				else{

					temp += number[i].x;
				}

				ans+=temp;

			}

			ps((ans>m)?"Sasha":"Anna");

		}

		
	}

	static int stubCntDigit(int number){

		int ans = 0;

		while(number>0){

			ans++;
			number = number / 10;

		}

		return ans;

	}

	static int stubCntZeros(int number){

		int ans = 0;

		while(number>0 && number%10==0){

			ans++;
			number = number/10;

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
