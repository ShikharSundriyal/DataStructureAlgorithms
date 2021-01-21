import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList < String > getStairPaths(int n) {
        //base case
        if(n == 0){
            ArrayList<String> al = new ArrayList<>();
            al.add("");
            return al;
        }else if(n<0){
            return new ArrayList<String>();
        }
        //Faith
        ArrayList<String> jump1 = getStairPaths(n-1);
        ArrayList<String> jump2 = getStairPaths(n-2);
        ArrayList<String> jump3 = getStairPaths(n-3);
        ArrayList<String> res = new ArrayList<>();
        //from faith to expectation
        for(String val : jump1){
            res.add("1"+val);
        }
        //from faith to expectation
        for(String val : jump2){
            res.add("2"+val);
        }
        //from faith to expectation
        for(String val : jump3){
            res.add("3"+val);
        }
        return res;
    }

}