import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printSS(str,"");

    }

    public static void printSS(String ques, String ans) {
        
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        printSS(ques.substring(1),ans+ch);
        printSS(ques.substring(1),ans+"");
        
    }

}