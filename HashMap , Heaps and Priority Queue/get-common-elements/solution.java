import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0;i<n1;i++){
        arr1[i] = sc.nextInt();
    }
    int n2 = sc.nextInt();
    int[] arr2 = new int[n2];
    for(int i = 0;i<n2;i++){
        arr2[i] = sc.nextInt();
    }
    
    printCommon(arr1,arr2);
    
}
public static void printCommon(int[] arr1, int[] arr2){
    
    HashSet<Integer> hs = new HashSet<>();
    for(int elem:arr1){
        hs.add(elem);
    }
    
    for(int elem:arr2){
        
        if(hs.contains(elem)){
            System.out.println(elem);
            hs.remove(elem);
        }
        
    }
    
}

}
