import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair>{
        int listno;
        int index;
        int value;
        public Pair(int listno, int index, int value){
            this.listno = listno;
            this.index = index;
            this.value = value;
        }
        public int compareTo(Pair other){
            return this.value-other.value;
        } 
        
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      // adding first element of every list to pq
      for(int i =0;i<lists.size();i++){
          pq.add(new Pair(i,0,lists.get(i).get(0)));
      }
      ArrayList<Integer> al = new ArrayList<>();
      while(pq.size()>0){
          Pair p = pq.remove();
          al.add(p.value);
          if(p.index+1 < lists.get(p.listno).size()){
            pq.add(new Pair(p.listno,p.index+1,lists.get(p.listno).get(p.index+1)));
          }
      }
      // write your code here

      return al;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
