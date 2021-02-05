import java.io.*;
import java.util.*;

public class Main {
    
    public static int fiboDp(int n,int[] dp){
        
        if(n == 0 || n == 1){
            return n;
        }
        
		// IF FACT(N) has already been calculated dont recaluclate it rather use it from the dp array
        if(dp[n]!=0)
            return dp[n];
        
        int n1 = fiboDp(n-1,dp);
        int n2 = fiboDp(n-2,dp);
        int ans = n1+n2;
		// STORE FACT(N) into an array for further lookups
        dp[n] = ans;
        return ans;
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        System.out.println(fiboDp(n,dp));
    }

}