import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			int n = scn.nextInt();
			
			Pair a[] = new Pair[n];
			Pair b[] = new Pair[n];
			Pair c[] = new Pair[n];
			
			inarr(a,scn);
			inarr(b,scn);
			inarr(c,scn);
			
			Arrays.sort(a);
			Arrays.sort(b);
			Arrays.sort(c);
			
			int ans = 0;
			
			for(int i=n-1;i>=n-3;i--){
				for(int j=n-1;j>=n-3;j--){
					for(int k=n-1;k>=n-3;k--){
						if(a[i].y!=b[j].y&&a[i].y!=c[k].y&&b[j].y!=c[k].y){
							ans = Math.max(ans,a[i].x+b[j].x+c[k].x);
						}
					}
				}
			}
			
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
	static void inarr(Pair[] arr, Scanner scn){
		for(int i = 0; i < arr.length; i++){
			 int temp = scn.nextInt();
			 arr[i] = new Pair(temp,i);
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
