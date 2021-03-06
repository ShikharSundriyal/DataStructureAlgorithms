import java.io.*;
import java.util.*;

public class Main {
    
     static int getFriendsCountTabulation(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2] * (i-1);
        }
        return dp[n];
    }
    
    //Recursive ( f(n) = f(n-1) + (n-1) * f(n-2) ) 
    public static int getFriendsCount(int n){
        if(n<0){
            return 0; 
        }
        if(n==0){
            return 1;
        }
        
        // 1st friend single, remaining friends can pair or stay single in f1 ways
        int f1 = getFriendsCount(n-1);
        
        //1st friend pairs up with wither one of the friends, remaining friends can
        // can pair up or stay single in f2 ways * number of possible ways 1st friends can pair up with remaining friends
        int f2 = (n-1) * getFriendsCount(n-2);
        
        return f1+f2;
        
    }
    
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getFriendsCountTabulation(n));
    }

}