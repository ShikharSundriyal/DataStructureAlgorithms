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
        System.out.println(getMax(arr));
    }
    public static int getMax(int[] arr){
        
        int minsofar = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i<arr.length;i++){
            if(minsofar > arr[i]) minsofar = arr[i];
            if(arr[i] - minsofar > maxprofit) maxprofit = arr[i] - minsofar;
        }
        return maxprofit;
    }

}
