import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc  = new Scanner(System.in);
        int houses = sc.nextInt();
        int[][] arr = new int[houses][3];
        
        for(int i = 0;i<arr.length;i++){
            for(int j = 0; j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(mincostTabu(arr));
    }
    
    public static int mincostTabu(int[][] arr){
        
        int[][] dp = new int[arr.length][3];
        for(int i = 0; i< arr.length;i++){
            
            for(int j = 0;j<arr[0].length;j++){
                
                if(i == 0){
                    dp[i][j] = arr[i][j];
                }else{
                    if(j == 0){
                        dp[i][j] = arr[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);  
                    }else if(j == 1){
                        dp[i][j] = arr[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                    }else if(j == 2){
                        dp[i][j] = arr[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                    }
                
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j = 0 ; j < dp[0].length;j++)
        {
            if(dp[dp.length-1][j] < res){
                res = dp[dp.length-1][j];
            }
        }
        return res;
    }
}
