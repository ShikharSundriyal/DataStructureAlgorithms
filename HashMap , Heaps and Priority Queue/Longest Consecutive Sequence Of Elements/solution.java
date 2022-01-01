import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0;i<arr.length;i++){
        arr[i] = sc.nextInt();
    }
    
    longestConsSeq(arr);
    
 }
 public static void longestConsSeq(int[] arr){
     HashMap<Integer, Boolean> hm = new HashMap<>();
     for(int a:arr){
         hm.put(a,true);
     }
     
     for(int a:arr){
         if(hm.containsKey(a-1)){
             hm.put(a,false);
         }
         
     }
     int max = 0;
     int start = 0;
     for(int i = 0;i<arr.length;i++){
         int a = arr[i];
         if(hm.get(a)==true){
             int length = 0;
             while(hm.containsKey(a+length)){
                 length++;
             }
             if(length>max){
                 max = length;
                 start = a;
             }
         }
     }
     for(int i = start;i<start+max;i++){
         System.out.println(i);
     }
     
     
 }

}
