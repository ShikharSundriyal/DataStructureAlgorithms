import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        // write your code here
        
        // n = number of elements
        // k = number of subsets
        long[][] dp = new long[n+1][k+1];
        
        // if j == 1 that means only 1 set, we will place all elemnents in a single set so only 1 way
        for(int i = 1;i<dp.length;i++){
            for(int j = 1; j<dp[0].length;j++){
                
                if(j == 1){
                    // if only one set, so all elements in same set
                    dp[i][j] = 1;
                }else if(i==j){
                    // if number of element = number of set, so only 1 way ineach set one element
                    dp[i][j] = 1;
                }else if(i>j){
                    // number of element > number of set
                    // 2 choices , 1st element takes one set dp[i-1][j-1]
                    //arrange n-1 element to k set
                    
                    dp[i][j] = dp[i-1][j-1] + j*dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
