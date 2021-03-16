import java.io.*;
import java.util.*;

public class Solution {
    
    public static int[] getNextSmallestLeft(int[] arr){
        Stack<Integer> st = new Stack();
        st.push(0);
        int[] res = new int[arr.length];
        res[0] = -1;
        for(int i = 1;i<res.length;i++){
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
          if(st.size() == 0){
             res[i] = -1;
         }else{
             res[i] = st.peek();
         }
            st.push(i);
        }
        return res;
    }
     public static int[] getNextSmallestRight(int[] arr){
        Stack<Integer> st = new Stack();
        st.push(arr.length-1);
        int[] res = new int[arr.length];
        res[arr.length-1] = arr.length;
        for(int i = arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.size() == 0){
             res[i] = arr.length;
         }else{
             res[i] = st.peek();
         }
            st.push(i);
        }
        return res;
    }
    
    public static int validGroups(int[] arr, int s, int t){
        int[] nsR = getNextSmallestRight(arr);
        int[] nsL = getNextSmallestLeft(arr);
        
        int validGroupCount = 0; 
        for(int i = 0;i<arr.length;i++){
            
            int width = nsR[i] - nsL[i] - 1;
            System.out.print(width +" ");
            int length = arr[i];
            if(s <= length && length<=t){
                validGroupCount+=width;
            }
        }
        return validGroupCount;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
   // int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = sc.nextInt();
        }
        int s = sc.nextInt();
        int t = sc.nextInt();
        System.out.println(validGroups(a,s,t));
    }
}