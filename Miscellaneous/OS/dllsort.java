import java.util.*;
public class Main{
	public static class Node{
		int val;
		Node next;
		Node prev;
		Node(){}
		Node(int val){
			this.val = val;
		}
	}
	public static Node merge(Node f, Node s){
		Node result = null;
		Node trav = result;
		while(f!=null&&s!=null){
			if(result==null){
				if(f.val>=s.val){
					result = s;
					s = s.next;
					trav = result;
				}
				else{
					result = f;
					f = f.next;
					trav = result;
				}
			}
			else{
				if(f.val>=s.val){
					trav.next = s;
					trav.next.prev = trav;
					s = s.next;
					trav = trav.next;
				}
				else{
					trav.next = f;
					trav.next.prev = trav;
					f = f.next;
					trav = trav.next;
				}
			}
		}
		while(f!=null){
			if(result==null){
				result = f;
				f = f.next;
				trav = f;
			}
			else{
				trav.next = f;
				trav.next.prev = trav;
				f = f.next;
				trav = trav.next;
			}
		}
		while(s!=null){
			if(result==null){
				result = s;
				s = s.next;
				trav = s;
			}
			else{
				trav.next = s;
				trav.next.prev = trav;
				s = s.next;
				trav = trav.next;
			}
		}
		return result;
	}
	public static Node mergesort(Node head){
		if(head==null||head.next==null) return head;
		Node s=head,f=head;
		while(f.next!=null&&f.next.next!=null){
			s = s.next;
			f = f.next.next;
		}
		f = s.next;
		if(s.next!=null) s.next.prev = null;
		s.next = null;
		head = mergesort(head);
		f = mergesort(f);
		return merge(head,f);
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
			Node head = new Node();
			Node trav = head;
			int n = scn.nextInt();
			for(int i=0;i<n;i++){
				int temp = scn.nextInt();
				if(i==0){
					trav.val = temp;
					head.val = temp;
				}
				else{
					trav.next = new Node(temp);
					trav.next.prev = trav;
					trav = trav.next;
				}
			}
			head = mergesort(head);
			while(head!=null){
				pns(head.val+" ");
				head = head.next;
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
