import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        if(n % 2 != 0 ){
            for(int diff = n-1;diff>=0;diff--){
                if(diff % 2 == 0){
                    for(int i =diff,j=0;j<=n-1 && i <=n-1 ;i++,j++){
                        System.out.println(arr[i][j]);
                    }
                }else{
                    for(int i =n-1,j=n-1-diff;j>=0 && i >=0 ;i--,j--){
                        System.out.println(arr[i][j]);
                    }
                }
            }
            
        for(int diff = 1; diff < n ; diff++){
          if(diff % 2 == 0){
               for(int i =0,j=diff;j<=n-1 && i <=n-1 ;i++,j++){
                        System.out.println(arr[i][j]);
                    }
          }
            else{
                for(int i =n-1-diff,j=n-1;j>=0 && i >=0 ;i--,j--){
                        System.out.println(arr[i][j]);
                    }
            }
        }
        
        }
        else{
            for(int diff = n-1;diff >=0;diff--){
                if(diff % 2 == 0){
                    for(int i = n-1,j=n-1-diff;i>=0 && j>=0;i--,j--){
                        System.out.println(arr[i][j]);
                    }
                    
                }else{
                    for(int i = diff,j=0;i<=n-1 && j<=n-1;i++,j++){
                        System.out.println(arr[i][j]);
                    }
                }
            }
            for(int diff = 1;diff <=n-1;diff++){
                if(diff % 2 == 0){
                    for(int i = n-1-diff,j=n-1;i>=0 && j>=0;i--,j--){
                        System.out.println(arr[i][j]);
                    }
                    
                }else{
                    for(int i = 0,j=diff;i<=n-1 && j<=n-1;i++,j++){
                        System.out.println(arr[i][j]);
                    }
                }
            }
            
        }
        
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}