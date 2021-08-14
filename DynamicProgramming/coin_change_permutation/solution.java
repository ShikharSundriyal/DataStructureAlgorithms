import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int am = sc.nextInt();
        int[] dp = new int[am+1];
        // System.out.println(permuRec(arr,am,dp));
        System.out.println(permuTabu(arr,am));
    }
    public static int permuRec(int[] arr,int amt,int[] dp){
        if(amt < 0) return 0;
        if(amt == 0) return 1;
        int res = 0;
        if(dp[amt] !=0 ) return dp[amt];
        for(int i = 0;i<arr.length;i++){
            res+= permuRec(arr ,amt - arr[i],dp);
        }
        dp[amt] = res;
        return res;
    }
    
    public static int permuTabu(int[] arr, int amt){
        
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for(int i = 0;i<dp.length;i++){
            
            for(int j = 0;j<arr.length;j++){
                if(i - arr[j] >= 0) // remaining amount
                    dp[i] += dp[i - arr[j]];
            }
            
        }
        return dp[amt];
    }
}
