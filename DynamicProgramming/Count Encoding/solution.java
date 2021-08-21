import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(countEncodingTabu(s));
    }   
    public static int countEncodingTabu(String s){
        // dp[i] = count of all encodings of string from 0 to i
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        if(s.length() == 1 ){
            if(s.charAt(0) != '0') return 1;
            else return 0;
        }
        
        dp[0] = 1;
        if(s.charAt(1) != '0' && Integer.parseInt(s.substring(0,2)) <= 26){
            dp[1] = 2;
        }else if(s.charAt(1) !='0' && Integer.parseInt(s.substring(0,2)) > 26) {
            dp[1] = 1;
        }else{
            dp[1] = 0;
        }
        for(int i = 2; i <dp.length;i++){
            // as double digit
            String x = s.charAt(i-1)+""+s.charAt(i)+"";
            if(Integer.parseInt(x) <= 26){
                dp[i] = dp[i-2];
            }
            // as single digit
            if(s.charAt(i) != '0'){
                dp[i]+=dp[i-1];
            }
            
        }
        return dp[dp.length-1];
        
    }
}
