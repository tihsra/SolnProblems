import java.util.*;

public class Main{

	private static HashMap<Character,Integer> hm;

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int t = 1;

		hm = new HashMap<>();

		hm.put('\0',0);
		hm.put('h',1);
		hm.put('a',2);
		hm.put('r',3);
		hm.put('d',4);

		while(t-->0){

			int n = scn.nextInt();

			String str = scn.next();

			int arr[] = new int[n];

			inarr(arr,scn);
			
			solve(n,arr,str);

		}

	}

	public static void solve(int n, int[] arr, String str){

		long memo[][] = new long[n][5];

		for(long[] i : memo) Arrays.fill(i,-1);

		ps(solver(n,0,arr,str,'\0',memo));


	}

	public static long solver(int n, int i, int arr[], String str, char curr, long memo[][]){

		if(i>=n) return 0L;

		if(memo[i][hm.get(curr)]!=-1) return memo[i][hm.get(curr)];

		long cost = 0;

		char strc = str.charAt(i);  
		
		if(hm.containsKey(strc)){

			long nic = arr[i] + solver(n,i+1,arr,str,curr,memo);

			long inc = IMAX;

			if(curr=='r'&&strc=='d'){

				memo[i][hm.get(curr)] = nic;
				
				return memo[i][hm.get(curr)];

			}

			if(curr=='\0'&&strc=='h'){
				
				inc = solver(n,i+1,arr,str,strc,memo);

			}

			else if(curr=='h'&&strc=='a'){

				inc = solver(n,i+1,arr,str,strc,memo);

			}
			
			else if(curr=='a'&&strc=='r'){

				inc = solver(n,i+1,arr,str,strc,memo);

			}
			else{
				
				inc = solver(n,i+1,arr,str,curr,memo);

			}

			cost = Math.min(inc,nic);

		}
		else{

			cost = solver(n,i+1,arr,str,curr,memo);

		}
		
		memo[i][hm.get(curr)] = cost;

		return memo[i][hm.get(curr)];

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
