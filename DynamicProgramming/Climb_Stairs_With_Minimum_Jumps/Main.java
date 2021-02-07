import java.io.*;
import java.util.*;

public class Main {
    public static int minJumps(int[] arr, int n,int[] dp){
        if(n > arr.length){
            return Integer.MAX_VALUE-1;
        }
        if(n == arr.length){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int min = Integer.MAX_VALUE-1;
        for(int i =1;i<=arr[n];i++){
            int intermediate = minJumps(arr,n+i,dp);
            min = Math.min(min,intermediate);
        }
        dp[n] = min+1;
        return min+1;
        
    }
    public static int getMinMovesTabulation(int[] arr){
        int n = arr.length;
		/** each element of dp represents minimum number of steps required to move from
			ith idx stair to final stair
		**/
        Integer[] dp = new Integer[n+1];
		/** dp[n] = 0 because minimum moves from nth stair to nth stair are zero moves, 
		but remember no of possible paths from nth stair to nth stair is 1.
		**/
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
			/** number of choices avaible from a particular stair
			**/
            int choices = arr[i];
            if(choices > 0){
                int min = Integer.MAX_VALUE;
                for(int j = i+1; j <= choices + i && j< dp.length ;j++){      
                    if(dp[j]!=null)
                        min = Math.min(min,dp[j]);
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
    
    public static int getMinMovesMemo(int n, int[] arr, int moves,int[] dp){
        
        if(n == arr.length){
            return moves;
        }
        else if(n > arr.length){
            return Integer.MAX_VALUE;
        }
		/** if we already know the result, then we avoid the call,
			dp[n] contains minimum number of ways from nth stair to final stair
		**/
        if( dp[n] != -1)
		/** we need to add the moves because, if we are at 5th stair, then from 5th to 
			final stair we know the miminum number of moves but we would have taken some steps
			to reach the 5th stair so we have to add those moves
		**/
            return dp[n]+moves;

        int finalResult = Integer.MAX_VALUE;
        for(int choices = 1; choices <= arr[n]; choices++){
            int intermediateResult = getMinMovesMemo(n + choices, arr, moves+1, dp);
            finalResult = Math.min(intermediateResult, finalResult);
        }
		/** dp[n] stores minimum moves from nth stair to final stair, final_result variable
		contains the miminum moves from 0 to final result , so from nth stair it will be 
		final result - number of moves made to reach the nth stair.
		
		**/
        dp[n] = finalResult - moves;
        return finalResult;
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // int res = getMinMovesMemo(0,arr,0,dp);
        // if(res == Integer.MAX_VALUE){
        //     System.out.println("null");
        // }else{
        //     System.out.println(res);
        // }
        System.out.println(getMinMovesTabulation(arr));
    }

}