import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static String solve(int d, int k) {
        
        int i = 1,j = ( int ) Math.sqrt(d);
        int count = 0;
        while(i <= j){
            if(i*i + j*j == d){
                // test case 18 0 or 18 5
                // if i == j then only 4 possible coordinates
                if (i == j)
                    count+= 4;
                else 
                    count+= 8;
                i++;
                j--;
            }
            else if( i*i + j*j < d)
                i++;
            else if( i*i + j*j > d)
                j--;
        }
        int m = ( int ) Math.sqrt(d);
        if(m*m == d){
            count+= 4;
        }
        
        if( count > k){
            return "impossible";
        }
        
        return "possible";
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] dk = scanner.nextLine().split(" ");

            int d = Integer.parseInt(dk[0]);

            int k = Integer.parseInt(dk[1]);

            String result = solve(d, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
