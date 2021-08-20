import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
 Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] values = new int[n];
        for(int i = 0;i<n;i++){
            values[i] = sc.nextInt();
        }
        int[] weight = new int[n];
        for(int i = 0;i<n;i++){
            weight[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        // System.out.println(maxWeight(values,weight,0,cap));
        System.out.println(maxWeightTabu(values,weight,cap));
    }
    public static int maxWeightTabu(int[] values, int[] weight,int capacity){
        
        int[][] dp = new int[values.length][capacity+1];
        
        for(int i = 0 ;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(j == 0){
                    // capacity of bag 0
                    dp[i][j] = 0;
                }else if(i == 0){
                    // if only 1 item
                    if( j >= weight[i]){
                        dp[i][j] = values[i];
                    } 
                }else{
                    //exclusive call
                    int ex = dp[i-1][j];
                    int inc = j-weight[i]>=0 ? values[i]+dp[i-1][j-weight[i]]:0;
                    dp[i][j] = Math.max(ex,inc);
                }
            }
        }
        return dp[dp.length-1][capacity];
        
    }
    
    public static int maxWeight(int[] values, int[] weight,int idx,int capacity){
        if(capacity < 0 ) return Integer.MIN_VALUE;
        if(idx == values.length){
            if(capacity < 0){
                return Integer.MIN_VALUE;
            }
            return 0;
        }
        
        int maxw1 = maxWeight(values,weight,idx+1,capacity);
        int maxw2 = values[idx] + maxWeight(values,weight,idx+1,capacity-weight[idx]);
        
        return Math.max(maxw1,maxw2);
    }
}
