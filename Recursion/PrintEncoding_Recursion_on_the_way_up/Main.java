import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str, "");

    }

    public static void printEncodings(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        // choice 1
        char ch1 = ques.charAt(0);
        if (ch1 == '0') {
            return;
        }
        
        String ros1 = ques.substring(1);
        char code = (char)('a' + ch1 - '0' - 1);
        printEncodings(ros1, ans + code);
        
        //choice 2
        if(ques.length()>=2){
        String ch2 = ques.substring(0, 2);
        int cht = Integer.parseInt(ch2);
        String ros2 = ques.substring(2);
        if (cht <= 26) {
            char code1 = (char)('a' + cht - 1);
            printEncodings(ros2, ans + code1);
        }
        }


    }

}