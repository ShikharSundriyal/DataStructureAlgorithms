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
        if( amt == 0) return 1; // using denominations present we have formed the amount
        if(amt < 0) return 0; // as all the denominations are positive once amt becomes < 0 there is no possible way to form the amount 
        if( idx == arr.length){
             return 0; // if we have used all the denominations
        }
        // yes call, i.e. we have used the denomination at index idx at the next level also we can use the same denomination as we have infinite supply of coin but amt will get reduced for next level
        int y = getCombiRecursive(arr, idx, amt - arr[idx]);
        // no call, i.e. we are not using current denomination at idx so prepare our amount so we can move to next idx but amount will remain same
        int n = getCombiRecursive(arr, idx+1, amt);
        return y + n;
    }
}
