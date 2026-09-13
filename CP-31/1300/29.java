import java.util.*;
public class Main{

	static int color_1;
	static int color_2; 

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int t = 1;

		while(t-->0){
			
			int e = scn.nextInt();

			color_1 = 0;

			color_2 = 0;

			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

			for(int i=0;i<e;i++) graph.add(new ArrayList<Integer>());

			for(int i=0;i<e-1;i++){

				int u = scn.nextInt() - 1;

				int v = scn.nextInt() - 1;

				graph.get(u).add(v);
				
				graph.get(v).add(u);

			}

			boolean vis[] = new boolean[e];

			vis[0] = true;

			dfs(graph,vis,0,0);

			ps((1L*color_1*color_2)-(e-1));

		}
	}

	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean vis[], int color, int parent){

		if(color==1){

			color_2++;

		}
		if(color==0){

			color_1++;

		}

		ArrayList<Integer> arr = graph.get(parent);

		for(int i : arr){

			if(!vis[i]){

				vis[i] = true;

				dfs(graph,vis,1-color,i);

			}
		}

	}
	
	static int MOD = 1000000007;
	static int MOD_C = 998244353;
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
	static long factorial(long n){if(n==1||n==0)return 1L;return ((n%MOD_C)*(factorial(n-1)%MOD_C))%MOD_C;}
}