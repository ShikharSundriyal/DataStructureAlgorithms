import java.io.*;
import java.util.*;

public class Main {
// Kadanes algo is used to find the max sum of an subarray
  public static int solution(int[] arr) {
    // write your code here
    int[] dp = new int[arr.length];
    dp[0] = arr[0];
    for(int i = 1;i<dp.length;i++){
        dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
    }
    int res = Integer.MIN_VALUE;
    for(int x:dp){
        res = Math.max(res,x);
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}