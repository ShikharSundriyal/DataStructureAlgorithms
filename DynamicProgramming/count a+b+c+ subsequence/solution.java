import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // System.out.println(countTabulation(s));
        System.out.println(countRecursive(s)[2]);
    }
    
    public static int countTabulation(String str){
        int a = 0; // count of subsequence of type a+
        int ab = 0; // count of subsequence of type a+b+
        int abc=0;// count of subsequence of type a+b+c+
        
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
                a = a*2 +1;    
            }else if(ch == 'b'){
                ab = 2*ab + a;
            }else if(ch == 'c'){
                abc = ab + abc*2;
            }
        }
        return abc;
    }
    
    public static int[] countRecursive(String str){
        
        if(str.length() == 0)
        {
            int[] arr = new int[3];
            return arr;
        }
        char ch = str.charAt(str.length()-1);
        String sub = str.substring(0,str.length()-1);
        int[] res = countRecursive(sub);
        //res[0] -> a+
        //res[1] -> a+b+
        //res[2] -> a+b+c+
        if(ch == 'a'){
            res[0] = 2*res[0] + 1;
        }else if(ch == 'b'){
            res[1] = res[0] + 2*res[1];
        }else if(ch == 'c'){
            res[2] = res[1] + 2*res[2];
        }
        return res;
        
    }
}
