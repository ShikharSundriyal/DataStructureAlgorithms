import java.io.*;
import java.util.*;

public class Main {

    public static int getPathsTabulation(int n, int[] dp) {

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];

    }

    public static int getPaths(int n, int[] dp) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (dp[n] != 0)
            return dp[n];

        int p1 = getPaths(n - 1, dp);
        int p2 = getPaths(n - 2, dp);
        int p3 = getPaths(n - 3, dp);
        int ans = p1 + p2 + p3;
        dp[n] = ans;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        //System.out.println(getPaths(n,dp));
        System.out.println(getPathsTabulation(n, dp));
    }

}