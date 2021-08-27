import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSumTabu(arr));
    }
    public static int maxSumTabu(int[] arr){
        // inclusive exclusive approach
        int oldinclude = 0;
        int oldexclude = 0;
        for(int i = 0; i< arr.length;i++){
            int newinclude = arr[i]+oldexclude;
            int newexclude = Math.max(oldinclude,oldexclude);
            oldexclude = newexclude;
            oldinclude = newinclude;
        }
        return Math.max(oldinclude, oldexclude);
    }
    
    
    public static int maxSum(int[] arr, int idx, int call){
        
        if(idx == arr.length){
            return 0;
        }
        int exclusion = 0;
        int inclusion = 0;
        if(call == 0 || call == 1){
             exclusion = maxSum(arr,idx+1,1);
             inclusion = arr[idx] + maxSum(arr,idx+1,2);
        }else if( call == 2){
             exclusion = maxSum(arr,idx+1,1);
        }
        return Math.max(inclusion,exclusion);
        
    }
    
    public static int maxSum1(int[] arr, int idx, int call){

        if(idx >= arr.length){
            return 0;
        }
        int exclusion = 0;
        int inclusion = 0;
        
         exclusion = maxSum1(arr,idx+1,1);
         inclusion = arr[idx] + maxSum1(arr,idx+2,2);
    
         exclusion = maxSum1(arr,idx+1,1);

        return Math.max(inclusion,exclusion);
        
    }
    
    public static int maxSumTabulation(int[] arr){
        return 0;
    }
}
