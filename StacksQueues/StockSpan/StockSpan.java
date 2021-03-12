import java.io.*;
import java.util.*;

public class StockSpan{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   int[] res = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   st.push(0);
   res[0] = 1;
   for( int i =1;i<arr.length;i++){
       
       while(st.size()>0 && arr[st.peek()] <= arr[i]){
           st.pop();
       }
       
       if(st.size()==0){
           // no next greater element on the left , so have to subtract by -1
           res[i] = i - (-1);
       }else{
           // next greater element is present , so span will be i - st.peek()
           res[i] = i - st.peek();
       }
       //push the element to the stack 
       st.push(i);
   }
   
   return res;
 }

}