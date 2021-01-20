// Print last index of an element in an array using recursion
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(lastIndex(arr,0,x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if(idx == arr.length){
            return -1;
        }
        
        int res = lastIndex(arr,idx+1,x);
        if(res == -1){
            if(arr[idx] == x){
                res = idx;
            }
        }
        return res;
    }

}
