import java.io.*;
import java.util.*;

public class Main {
    
    public static int llps(String str){
        boolean[][] dp = new boolean[str.length()][str.length()];
        // dp[i][j] stores, if a string from i to j(str) is palindronic or not  
        int ans = 0;
        int n = dp.length;
        for(int diag = 0;diag <=n-1;diag++){
            for(int i = 0,j=diag; j<=n-1;i++,j++){
                if(i == j){
                    // str of length 1 is palindronic always
                    dp[i][j] = true;
                }else{
                    if(str.charAt(i) == str.charAt(j)){
                        if(j-i == 1)
                            dp[i][j] = true;
                        else
                            dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
            
        }
        for(int i =0;i<dp.length;i++){
            for(int j = 0;j<dp.length;j++){
               if(dp[i][j] == true)
                ans++;
            }
            
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
         
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
         System.out.println(llps(a));
    }

}