import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] deno = new int[n];
        for(int i = 0;i<n;i++){
            deno[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        System.out.println(getCombiRecursive(deno,0,amt));
    }
    
    public static int getCombiRecursive(int[] arr, int idx, int amt){
        if( amt == 0) return 1;
        if(amt < 0) return 0;
        if( idx == arr.length){
             return 0;
        }
        
        int y = getCombiRecursive(arr, idx, amt - arr[idx]);
        int n = getCombiRecursive(arr, idx+1, amt);
        return y + n;
    }
}
