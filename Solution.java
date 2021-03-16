import java.io.*;
import java.util.*;

public class Solution {

    public static int getLength(int[] arr, int diff){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++){
            int maxi = 0;
            for(int j = i-1;j>=0;j--){
                if(arr[i] - arr[j] == diff){
                    maxi = Math.max(maxi,dp[j]);
                }
            }
            dp[i] = 1 + maxi;
        }
        int res= Integer.MIN_VALUE;
        for(int x : dp)
            res = Math.max(x,res);
        
        return res;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] =sc.nextInt();
        }
        int diff = sc.nextInt();
        System.out.println(getLength(arr,diff));
    }
}