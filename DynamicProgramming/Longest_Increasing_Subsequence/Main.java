import java.io.*;
import java.util.*;

// 10,20,3,9,30,1,90
//length of longest incresing subsequence

public class Main {
    //O(n^2) worst case . auxilarry space O(n)
    public static int tabulation(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i = 1;i<dp.length;i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(arr[i] > arr[j]){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = 1 + max;
        }
        int res = 0;
        for(int x : dp){
            res = Math.max(res,x);
        }
        return res;
    }

    public static int memoSolution(int[] arr, int idx, int liu, int[][] dp){
        if(idx == arr.length){
            return 0;
        }
        if(liu!=-1 && dp[idx][liu] != 0){
            return dp[idx][liu];
        }
        //yes call
        int f1 = 0;
        //no call
        int f2 = 0;
        if(liu == -1 || arr[idx] > arr[liu]){
            f1 = 1 + memoSolution(arr,idx+1,idx,dp);
        }
        f2 = memoSolution(arr, idx+1,liu,dp);
        int ans = Math.max(f1,f2);
        if(liu != -1)
            dp[idx][liu] = ans;
        return ans;
    }

    //O(2^n)
    public static int recursiveSolution(int[] arr, int idx, int liu){
        if(idx == arr.length){
            return 0;
        }
        //yes call
        int f1 = 0;
        //no call
        int f2 = 0;
        if(liu == -1 ||  arr[idx] > arr[liu]){
            f1 = 1 + recursiveSolution(arr,idx+1,idx);
        }
        f2 = recursiveSolution(arr, idx+1,liu);

        return Math.max(f1,f2);
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n][n];
        System.out.println(memoSolution(arr,0,-1,dp));
    }

}