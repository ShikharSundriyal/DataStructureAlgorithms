import java.io.*;
import java.util.*;

public class Main {
    
    static int tabulationcount(int[] arr){
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 1;
        /** at each dp[i] we are storing the number of ways from ith stair to nth stair.
			Here we find our smallest problem at nth stair i.e. from nth to nth we have 1 ways 
			(we came to this conclusion by looking at recursion base case)
		**/
        for(int i = n-1; i>=0;i--){
            for(int jumps = 1; jumps<=arr[i];jumps++){
                /** this check needs to be done so that i+jumps does not become OOB**/
				if( i+jumps <= n )
                    dp[i] +=  dp[i + jumps];
                
            }
        }
		/** dp[0] means from 0th to nth , thats what we had to find **/
        return dp[0];
        
    }

    static int Memocount(int n, int[] choices,int[] dp) {
	
	/** from 0 to nth position , 
	from each position we have "choices[n]" possibilities
	
	
	**/
	
		/** base case , once you reach to nth stair we have one answer**/
		if (n == choices.length) {
            return 1;
        }
		/** if we have crossed our nth stair, it cannot be our answer **/
        if (n > choices.length) {
            return 0;
        }
		/** Memonisation, check if we have already have the result if yes avoid that call **/
        if(dp[n]!=0)
            return dp[n];
        int ans = 0;
        for (int i = 1; i <= choices[n]; i++) {
            ans += Memocount(n + i, choices,dp);
        }
		/** Memonisation, store the ans for further calls **/
        dp[n] = ans;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        //System.out.println(Memocount(0, arr, dp));
        System.out.println(tabulationcount(arr));
    }

}