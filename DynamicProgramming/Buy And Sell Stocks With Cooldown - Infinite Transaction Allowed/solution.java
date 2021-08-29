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
        
        int oldbuyingstateprofit = -arr[0];
        int oldsellingstateprofit = 0;
        int oldcooldownprofit = 0;
        
        for(int i = 1;i<arr.length;i++){
            int newbuyingstateprofit = Math.max(oldcooldownprofit-arr[i],oldbuyingstateprofit);
            int newsellingstateprofit = Math.max(oldsellingstateprofit,oldbuyingstateprofit+arr[i] );
            int newcooldownprofit = Math.max(oldcooldownprofit,oldsellingstateprofit);
            oldbuyingstateprofit=newbuyingstateprofit;
            oldsellingstateprofit = newsellingstateprofit;
            oldcooldownprofit = newcooldownprofit;
        }
        return oldsellingstateprofit;
    }
}
