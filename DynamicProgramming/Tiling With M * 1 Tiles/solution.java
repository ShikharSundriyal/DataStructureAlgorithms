import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    System.out.println(getWaysTabu(m, n));
  }

  public static int getWaysRecu(int m, int n) {
    if (n < 0)return 0;
    if (n == 0) return 1;
    int w1 = getWaysRecu(m, n - 1);
    int w2 = getWaysRecu(m, n - m);
    return w1 + w2;
  }
  public static int getWaysTabu(int m, int n) {

    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {

      dp[i] = dp[i - 1] + (i - m >= 0 ? dp[i - m] : 0);
    }
    return dp[n];
  }
}
