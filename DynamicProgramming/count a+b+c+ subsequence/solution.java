import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(countTabulation(s));
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
}
