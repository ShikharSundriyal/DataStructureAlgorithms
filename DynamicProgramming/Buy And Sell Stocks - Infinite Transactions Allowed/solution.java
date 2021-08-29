import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProfit(arr));
    }
    
    public static int maxProfit(int[] arr){
        int profit = 0;
        
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i+1] > arr[i]){
                profit += arr[i+1] - arr[i];
            }
        }
        return profit;
    }

}
