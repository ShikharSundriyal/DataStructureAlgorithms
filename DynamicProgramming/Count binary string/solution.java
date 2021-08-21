import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // count of binary string ending with 0 without consecutive 0
    // count of binary string ending with 0 without having consecutive 1
    // int ans = cbs(n,'0') + cbs(n,'1');
    // System.out.println(ans);
    // System.out.println(getcbsTabu(n));
    int[] a = getcbsRecur(n);
    System.out.println(a[0]+a[1]);
 }
 
 public static int cbs(int n, char ch){
     if(n == 1){
         return 1;
     }
     int ans = 0;
     if(ch == '0'){
         // string ending with 0
         ans = cbs(n-1,'1');
     }else{
         //string ending with 1
         ans = cbs(n-1,'1') + cbs(n-1,'0');
     }
     return ans;
 }
 
 public static int getcbsTabu(int n){
     
     int oldcount0  = 1;
     int oldcount1 = 1;
     
     for(int i = 2;i<=n;i++){
         int newcount0 = oldcount1;
         int newcount1 = oldcount0 + oldcount1;
         oldcount0 = newcount0;
         oldcount1 = newcount1;
     }
     return oldcount0 + oldcount1;
 }
 
 public static int[] getcbsRecur(int n){
     if(n == 1){
         // count of strings of length 1 ending with 0 not having consecutive 0
         // count of strings of length 0 ending with 1 not having consecutive 0
         int[] res = {1,1};
         return res;
     }
     int[] ans = getcbsRecur(n-1);
     //myans[0] strings ending with 0
     //myans[1] strings ending with 1
     int[] myans = {ans[1], ans[0]+ans[1]};
     return myans;
 }

}
