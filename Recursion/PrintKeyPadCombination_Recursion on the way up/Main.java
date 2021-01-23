import java.io.*;
import java.util.*;

public class Main {
    public static String[] arr;
    static {
        arr = new String[10];
        arr[0] = ".;";
        arr[1] = "abc";
        arr[2] = "def";
        arr[3] = "ghi";
        arr[4] = "jkl";
        arr[5] = "mno";
        arr[6] = "pqrs";
        arr[7] = "tu";
        arr[8] = "vwx";
        arr[9] = "yz";
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printKPC(str, "");
    }

    public static void printKPC(String ques, String ans) {

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String s = arr[ch - '0'];
        ques = ques.substring(1);
		// number of calls = length of s
        for (int i = 0; i < s.length(); i++) {
            printKPC(ques,ans+s.charAt(i));
        }


    }

}