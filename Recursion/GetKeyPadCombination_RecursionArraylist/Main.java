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
        System.out.println(getKPC(str));
    }

    public static ArrayList < String > getKPC(String str) {
        //str = 78
        if (str.length() == 0) {
            ArrayList < String > al = new ArrayList < > ();
            al.add("");
            return al;
        }
        //ch=7
        char ch = str.charAt(0);
        //arr[7] = 'tu'
        String string_representation = arr[ch - '0'];
        //str=8
        str = str.substring(1, str.length());
        // Apply faith
        ArrayList < String > partialResult = getKPC(str);
        ArrayList < String > finalres = new ArrayList < > ();
        for (int i = 0; i < string_representation.length(); i++) {
            //t , u
            char firstchar = string_representation.charAt(i);
            for (String val: partialResult) {

                finalres.add(firstchar + val);
            }
        }
        return finalres;
    }

}