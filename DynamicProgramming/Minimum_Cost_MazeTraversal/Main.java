import java.io.*;
import java.util.*;

public class Main {
	
	static int getMinCostTabulation(int[][] arr){
        
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int i =dp.length-1;i>=0;i--){
            for(int j = dp[0].length-1;j>=0;j--){
                int hchoice = Integer.MAX_VALUE;
                int vchoice = Integer.MAX_VALUE;
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == dp.length-1){
                    hchoice=  dp[i][j+1];
                    dp[i][j] = hchoice +arr[i][j];
                }
                else if(j == dp[0].length -1){
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                }else{
                    hchoice=  dp[i][j+1];
                    vchoice = dp[i+1][j];
                    dp[i][j] = arr[i][j] + Math.min(hchoice,vchoice);
                }
            }
        }
        
        return dp[0][0];
    }

	
    static int getMinCostRecursion(int[][] arr, int sr,int sc,int dr,int dc,int[][] dp){
        if(sr == dr && sc == dc){
            return arr[sr][sc];
        }
        if(sr> dr || sc > dc){
            return Integer.MAX_VALUE;
        }
        //horizontal
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        int hcost = getMinCostRecursion(arr,sr,sc+1,dr,dc,dp);
    
        int vcost = getMinCostRecursion(arr,sr+1,sc,dr,dc,dp);
    
        int min_cost = arr[sr][sc] + Math.min(hcost,vcost);
        dp[sr][sc] = min_cost;
        return min_cost;
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        
        
        System.out.println(getMinCostRecursion(arr,0,0,n-1,m-1,dp));
    }

}