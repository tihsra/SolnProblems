import java.util.*;

public class Main{

    public static class CustomHeap{

        private ArrayList<Integer> heap = new ArrayList<>();

        CustomHeap(){}

        public int peek(){
            
            if(heap.size()==0){
                return -1;
            }

            return heap.get(0);
        }

        public void add(int element){

            heap.add(element);

            int index = heap.size()-1;
            
            while(index>0 && heap.get(index)<heap.get((index-1)/2)){

                int temp = heap.get((index-1)/2);

                heap.set((index-1)/2,heap.get(index));

                heap.set(index,temp);

                index = (index-1)/2;

            }
        }

        public int poll(){

            int ans = heap.get(0);

            heap.set(0,heap.get(heap.size()-1));

            heap.remove(heap.size()-1);

            if(heap.size()==0) return ans;

            int index = 0;

            while(true){

                int firstChild = 2*index+1;

                int secondChild = 2*index+2;

                int smallest = index;

                if(firstChild<heap.size() && heap.get(smallest)>heap.get(firstChild)){

                    smallest = firstChild;

                }

                if(secondChild<heap.size() && heap.get(smallest)>heap.get(secondChild)){

                    smallest = secondChild;

                }

                if(smallest == index) break;

                int temp = heap.get(smallest);

                heap.set(smallest, heap.get(index));

                heap.set(index,temp);

                index = smallest;
            }

            return ans;

        }
    }

    public static void main(String args[]){

        Scanner scn = new Scanner(System.in);

        CustomHeap minHeap = new CustomHeap();

        int arr[] = {100,50,25,12,6,3,1,0};

        for(int i : arr) minHeap.add(i);

        for(int i=0;i<arr.length;i++) System.out.println(minHeap.poll());

    }
}