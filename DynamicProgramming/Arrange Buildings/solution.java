import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] a = arrangeBuilding(n);
    long ans = a[0]+a[1];
    System.out.println(ans*ans);
 }
 
 public static long[] arrangeBuilding(int n){
     // all the n ways such that no 2 buildings are consecutive
     
     if(n == 1){
         // a[0] -> ways ending with building, such that no consecutive buildings together
         //a[1] - > ways ending with space, such that no consecutive building together
         long[] a = {1,1};
         return a;
     }
     
     long[] a = arrangeBuilding(n-1);
     long[] myans = {a[1],a[0]+a[1]};
     return myans;
 }

}
