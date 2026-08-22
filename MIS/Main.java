import java.util.*;

public class Main{

    public static class TrieNode{

        char c;
        boolean isEnd;
        TrieNode arr[] = new TrieNode[26];

        TrieNode(){isEnd = false;}

        TrieNode(char c){
            
            this.c = c;
            isEnd = false;

        }

    }

    public static void insert(TrieNode head, String word, int start){

        if(start==word.length()){

            head.isEnd = true;
            
            return;
            
        } 

        int toBeAddedIndex = word.charAt(start)-'a';

        if(head.arr[toBeAddedIndex]==null){
            
            head.arr[toBeAddedIndex] = new TrieNode(word.charAt(start));


        }
        
        insert(head.arr[toBeAddedIndex], word, start+1);

    }

    public static boolean search(TrieNode head, String word, int start){

        if(start==word.length()){

            return head.isEnd;
            
        }

        int toBeSearchedIndex = word.charAt(start)-'a';

        if(head.arr[toBeSearchedIndex]==null){

            return false;

        }

        return search(head.arr[toBeSearchedIndex],word,start+1);

    }

    public static boolean searchPrefix(TrieNode head, String prefix, int start){

        if(start==prefix.length()){

            return true;

        }
        
        int toBeSearchedIndex = prefix.charAt(start)-'a';

        if(head.arr[toBeSearchedIndex]==null){
            
            return false;

        }

        return searchPrefix(head.arr[toBeSearchedIndex], prefix, start+1);
    }

    public static void main(String args[]){

        Scanner scn = new Scanner(System.in);

        TrieNode head = new TrieNode();

        while (true){
            
            System.out.println("1-Insert, 2-search, 3-searchPrefix 4-exit");

            int option = scn.nextInt();

            if(option==1){

                String word = scn.next();

                insert(head,word,0);

            }

            else if(option==2){

                String word = scn.next();

                System.out.println(search(head,word,0));
            }

            else if(option==3){

                String prefix = scn.next();

                System.out.println(searchPrefix(head,prefix,0));

            }

            else if(option==4) break;

            else{

                System.out.println("1-Insert, 2-search, 3-searchPrefix 4-exit");
                
            }
        }

    }
}