import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        System.out.println(targetSumSubsetTabu(arr,tar));
    }
    
    public static boolean targetSumSubsetTabu(int[] arr, int tar){
        
        boolean[][] dp = new boolean[arr.length][tar+1];
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(i == 0){
                    if(j == arr[i]){
                        dp[i][j] = true;
                    }
                }
                else if(j == 0){
                    dp[i][j] = true;
                }
                
                else if(j - arr[i]>=0 && dp[i-1][j - arr[i]] == true || dp[i-1][j] == true){
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
       
    }
}
