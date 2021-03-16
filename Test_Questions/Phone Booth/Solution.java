import java.util.Scanner;

public class Solution {
    
   
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 1){
                continue;
            }else{
                if(i>=1 && i<=arr.length-2){
                    if(arr[i-1] != 1 && arr[i+1] !=1){
                        k--;
                    } 
                }
            }
        }
        if(k == 0 || k<0)
            System.out.println(true);
        else
            System.out.println(false);
       // code here
    }
}