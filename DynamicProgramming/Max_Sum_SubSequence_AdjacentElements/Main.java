import java.io.*;
import java.util.*;

public class Main {
	
	// inclusive exclusive approach
 public static int maxSumInclusiveExclusive(int[] arr){
        int n = arr.length;
        int[] dpin = new int[n];
        int[] dpex = new int[n];
        dpin[0] = arr[0];
        dpex[0] = 0;
        for(int i = 1;i<n;i++){
            dpin[i] = dpex[i-1] + arr[i];
            dpex[i] = Math.max(dpex[i-1],dpin[i-1]);
        }
        return Math.max(dpin[n-1],dpex[n-1]);
        
        }
    
    public static int maxSumTabu(int[] arr,int n){
        int[] dp = new int[n+1];
        dp[0] = 0; // empty
        dp[1] = Math.max(0,arr[0]); //
        for(int i = 2;i<dp.length;i++){
            //dp[i-1] --> if element is not coming
            //arr[i-1]+dp[i-2] --> if element is coming then add current elements //value and dp[i-2] because i-1st element cannot come 
            dp[i] = Math.max(dp[i-1],arr[i-1]+dp[i-2]);
        }
        return dp[n];
    }
    
    public static int maxsum(int[] arr, int idx,int[] dp){
        if(idx >= arr.length){
            return 0;
        }
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        int f2 = maxsum(arr,idx+1,dp);
        //
        int f1 = arr[idx] + maxsum(arr,idx+2,dp);
        
        int ans = Math.max(f1,f2);
        dp[idx] = ans;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSumTabu(arr,n));
    }
}