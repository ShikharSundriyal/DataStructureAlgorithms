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
        int txn = sc.nextInt();
        System.out.println(maxProfit(arr,txn));
    }
    public static int maxProfit(int[] arr, int txn){
        
        int oldbuyingstateprofit = -arr[0];
        int oldsellingstateprofit = 0;
        
        for(int i = 1;i<arr.length;i++){
            int newbuyingstateprofit = Math.max(oldbuyingstateprofit,oldsellingstateprofit-arr[i]);
            int newsellingstateprofit = Math.max(oldsellingstateprofit,arr[i]+oldbuyingstateprofit-txn );
            oldbuyingstateprofit=newbuyingstateprofit;
            oldsellingstateprofit = newsellingstateprofit;
        }
        return oldsellingstateprofit;
    }
}
