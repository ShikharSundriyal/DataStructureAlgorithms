import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int house = sc.nextInt();
    int colour = sc.nextInt();
    int[][] arr = new int[house][colour];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    System.out.println(getmincost(arr));
  }
  public static int getmincost(int[][] arr) {

    int[][] dp = new int[arr.length][arr[0].length];
    int min = Integer.MAX_VALUE;
    int smin = Integer.MAX_VALUE;
    for (int i = 0; i < dp.length; i++) {
      int newmin = Integer.MAX_VALUE;
      int snewmin = Integer.MAX_VALUE;
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0) {
          dp[i][j] = arr[i][j];
        } else {
          dp[i][j] = arr[i][j] + ( dp[i - 1][j] == min ? smin : min );
        }
        if (dp[i][j] < newmin) {
          snewmin = newmin;
          newmin = dp[i][j];
        } else if (dp[i][j] < snewmin) {
          snewmin = dp[i][j];
        }
      }
      min = newmin;
      smin  = snewmin;

    }
    return min;

  }
}
