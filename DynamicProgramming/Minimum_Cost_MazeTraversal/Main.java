import java.io.*;
import java.util.*;

public class Main {
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