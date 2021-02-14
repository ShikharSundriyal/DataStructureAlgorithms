import java.io.*;
import java.util.*;

public class Main {
    
	/** 
	dp[i][j] corresponds to the max gold from i,j to last column
	you will fill the dp array from top to bottom , 
	from jth row to 0th row (columnwise).
	For last column , the max gold will be arr[i][j]
	**/
    public static int getGoldTabulation(int[][] arr){
        
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int j = arr[0].length-1;j>=0;j--){
            for(int i = 0;i<arr.length;i++){
                if( j == arr[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i==0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i==arr.length -1){
                    dp[i][j]  =arr[i][j] + Math.max(dp[i-1][j+1],dp[i][j+1]);
                }else{
                    dp[i][j] =arr[i][j] + Math.max(Math.max(dp[i][j+1],dp[i-1][j+1]),dp[i+1][j+1]);
                }
            }
        }
        int max = -1;
        for(int i = 0;i<arr.length;i++){
            if(max < dp[i][0]){
                max = dp[i][0];
            }
        }
        return max;
    }

    public static int getGold(int[][] arr,int sr, int sc,int[][] dp){
        if(sr<0 || sc>arr[0].length || sr>=arr.length || sc<0){
            return Integer.MIN_VALUE;
        }
        if(sc == arr[0].length-1){
            return arr[sr][sc];
        } 
        
        int res = Integer.MIN_VALUE;
        if(dp[sr][sc] !=0){
            return dp[sr][sc];
        }
        int upR = getGold(arr,sr-1,sc+1,dp);
        int fR = getGold(arr,sr,sc+1,dp);
        int dR = getGold(arr,sr+1,sc+1,dp);
        int ans =  arr[sr][sc] + Math.max(dR,Math.max(upR,fR));
        dp[sr][sc] = ans;
        return ans;
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
        System.out.println(getGoldTabulation(arr));
        
		/**
		For Recursive solution , 
		as the starting point is not fixed . 
		You have to assume the starting
		point as fixed and make call for each point of 0th row.
		each function call will give you the max gold from each position.
		Then you have to find the max out of those all.
		Recursive function will give you max gold from a starting position to 
		last wall.
		**/
		// int[][] dp = new int[n][m];
        
        // int max = -1;
        
        // for(int i =0;i<arr.length;i++){
        //     int r = getGold(arr,i,0,dp);
        //     if(max < r){
        //         max = r;
        //     }
        // }
        
        
        // System.out.println(max);
		**/
    }

}