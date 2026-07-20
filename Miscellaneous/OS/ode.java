import java.util.*;
public class Main{
	public static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(){};
		TreeNode(int val){
			this.val = val;
		}
	}
	public static void hor(TreeNode head){
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(head);
		while(qu.size()>0){
			int n = qu.size();
			for(int i=0;i<n;i++){
				TreeNode temp = qu.remove();
				pns(temp.val+" ");
				if(temp.left!=null) qu.add(temp.left);
				if(temp.right!=null) qu.add(temp.right);
			}
			ps("");
		}
	}
	public static HashMap<Integer,ArrayList<Integer>> ver(TreeNode head){
		HashMap<Integer,ArrayList<Integer>> = new HashMap<>();
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(head);
		hm.put(0,new ArrayList<Integer>());
		hm.put(0,hm.get(0).add(head.val));
		int val = 0;
		while(qu.size()>0){
			int n = qu.size();
			for(int i=0;i<n;i++){
				TreeNode temp = qu.remove();
				if(temp.left!=null) {
					qu.add(temp.left);
					ArrayList<Integer> te = hm.getOrDefault(val-1,new ArrayList<Integer>());
					hm.put(val-1,te.add(temp.left.val));
				}
				if(temp.right!=null) {
					qu.add(temp.right);
					ArrayList<Integer> te = hm.getOrDefault(val+1,new ArrayList<Integer>());
					hm.put(val+1,te.add(temp.right.val));
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			int n = scn.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) arr[i] = scn.nextInt();
			Queue<TreeNode> qu = new LinkedList<>();
			TreeNode head = new TreeNode(arr[0]);
			qu.add(head);
			int i = 1;
			while(i<n-1){
				TreeNode temp = qu.remove();
				if(arr[i]!=-1){
					temp.left = new TreeNode(arr[i]);
					qu.add(temp.left);
				}
				if(arr[i+1]!=-1){
					temp.right = new TreeNode(arr[i+1]);
					qu.add(temp.right);
				}
				i+=2;
			}
			hor(head);
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
