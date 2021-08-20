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
        // System.out.println(unboundedRecur(values,weight,cap));
        System.out.println(unboundedTabu(values,weight,cap));
	    }
	    
	    public static int unboundedTabu(int[] values, int[] weights, int capacity){
	        
	        int[] dp = new int[capacity+1];
	        for(int i = 1;i<dp.length;i++){//capacity
	            int max = 0;
	            for(int j = 0;j<weights.length;j++){//items
	                if(i >= weights[j]){
	                   max = Math.max(max,values[j]+dp[i - weights[j]]);
	                }
	            }
	            dp[i] = max;
	        }
	        return dp[capacity];
	    }
	    
	    public static int unboundedRecur(int[] values, int[] weights, int capacity){
	        if( capacity < 0) return Integer.MIN_VALUE;
	        int max = 0;
	        for(int i = 0;i<values.length;i++){
	            int a = values[i] + unboundedRecur(values, weights, capacity - weights[i]);
	            if(max < a){
	                max = a;
	            }
	        }
	        
	        return max;
	        
	        
	    }
	}
