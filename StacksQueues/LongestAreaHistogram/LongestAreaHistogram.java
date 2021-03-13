import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    // get next smallest element on the right
    int[] nseRight = getNextSmallestInRight(a);
    
    // get next smallest element on the left
    int[] nseLeft = getNextSmallestInLeft(a);
    
    
    int max = Integer.MIN_VALUE;
    //O(N)
    for(int i = 0;i< a.length;i++){
        // width = nseRight[i] - nseLeft[i] -1)
        //length = a[i]
       max = Math.max(max, a[i] * (nseRight[i] - nseLeft[i] -1));
    }
    System.out.println(max);
    
 }
 
 //O(N)
 public static int[] getNextSmallestInLeft(int[] arr){
     Stack<Integer> st = new Stack<>();
     st.push(0);
     int[] res = new int[arr.length];
     // -1 if no next smaller element on the left
     res[0] = -1;
     for(int i =1;i<arr.length;i++){
         // pop all larger elements
         while(st.size()>0 && arr[st.peek()] >= arr[i]){
             st.pop();
         }
         // make your answer
         if(st.size() == 0){
             res[i] = -1;
         }else{
             res[i] = st.peek();
         }
         // push the element to the stack
         st.push(i);
     }
     return res;
 }
 //O(N)
  public static int[] getNextSmallestInRight(int[] arr){
     Stack<Integer> st = new Stack<>();
     st.push(arr.length-1);
     int[] res = new int[arr.length];
     // arr.length if there is no next smallest element on the right as we have to calculate the area so we have to use arr.length
     res[arr.length-1] = arr.length;
     for(int i =arr.length-2;i>=0;i--){
         // pop all larger elements
         while(st.size()>0 && arr[st.peek()] >= arr[i]){
             st.pop();
         }
         // make your answer
         if(st.size() == 0){
             res[i] = arr.length;
         }else{
             res[i] = st.peek();
         }
         //push the idx to stack
         st.push(i);
     }
     return res;
 }
 
}