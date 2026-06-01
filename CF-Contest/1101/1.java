import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			int n = scn.nextInt();
			int max = IMIN;
			int max_ele = IMAX;
			int arr[] = new int[n];
			HashMap<Integer,Integer> hm = new HashMap<>();
			
			for(int i=0;i<n;i++){
				int temp = scn.nextInt();
				arr[i] = temp;
				int curr = hm.getOrDefault(temp,0)+1;
				if(curr>max){
					max_ele = temp;
					max = curr;
				}
				hm.put(temp,curr);
			}
			
			int less = 0, great = 0;
			for(int i=0;i<n;i++){
				if(arr[i]<max_ele){
					less++;
				}
				if(arr[i]>max_ele){
					great++;
				}
			}
			
			if(less==0||great==0){
				System.out.println(n-max);
			}
			else{
				int res = n - 2*Math.min(great,less) - max;
				
				System.out.println(Math.min(great,less)+res);
			}
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
