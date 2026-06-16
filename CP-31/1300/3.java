import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			
			int n = scn.nextInt();
			
			long arr[] = new long[n];
			
			lnarr(arr,scn);
			
			long odd[] = new long[n];
			long eve[] = new long[n];
			
			for(int i=0;i<n;i++){
				if(i==0){
					odd[0] = arr[i];
					continue;
				}
				
				if(i%2==0){
					eve[i] = eve[i-1];
					odd[i] += arr[i]+odd[i-1];
				}
				else{
					odd[i] = odd[i-1];
					eve[i] += arr[i]+eve[i-1];
				}
				
			}
			
			HashSet<Long> hs = new HashSet<>();
			boolean flag = false;
			
			for(int i=0;i<n;i++){
				long temp = odd[i]-eve[i];
				if(hs.contains(temp)||(i!=0&&temp==0)){
					flag = true;
					break;
				}
				hs.add(temp);
			}
			
			if(flag) ps("Yes");
			else ps("No");
			
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
}
