import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {   Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(getWaysTabu(2,n));

    }
    
    public static int getWaysRecursive(int length, int breadth){
        if(breadth < 0) return 0;
        if(breadth == 0){
            return 1;
        }
        
        // placed vertically
        int w1 = getWaysRecursive(length,breadth-1);
        // placed horizontally
        int w2 = getWaysRecursive(length,breadth-2);
        
        return w1+w2;
    }
    
    public static int getWaysTabu(int length, int breadth){
        
        int[] dp = new int[breadth+1];
    dp[0]=1;
    dp[1] =1;
        for(int i = 2;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[breadth];
    }
}
