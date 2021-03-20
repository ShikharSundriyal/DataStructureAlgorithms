import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }
        while(st.size()!=1){
            int i = st.pop();
            int j = st.pop();
            if(arr[i][j] == 1){
                //i knows j , so i cannot be celebrity
                st.push(j);
            }else{
                st.push(i);
            }
        }
        //verify if the st.peek is actual celebrity or not
        int c = st.peek();
        for(int i = 0;i<arr.length;i++){
            if(i == st.peek()){
                continue;
            }
            // if any row we have one that means its not a celebrity
            // if any column has zero that means i does not know j but to be a celebrity j should be known by all
            if(arr[c][i] == 1 ||arr[i][c] == 0){
                System.out.println("none");
                return;
            }
        }
        System.out.println(st.peek());
     
    }

}