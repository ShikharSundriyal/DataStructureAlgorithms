import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    int[] ngeR = new int[n];
    Stack<Integer> st = new Stack<>();
    st.push(arr.length-1);
    ngeR[arr.length-1] = arr.length;
    for(int i = arr.length-2;i>=0;i--){
        //pop all smaller elements
        while(st.size()>0 && arr[st.peek()] <= arr[i]){
            st.pop();
        }
        //make answer
        if(st.size() == 0){
            ngeR[i] = arr.length;
        }else{
            ngeR[i] = st.peek();
        }
        //push the idx
        st.push(i);
    }
	
    // code
    int j = 0;
    int[] ans = new int[n-k+1];
    for(int i =0;i<ans.length;i++){
        if(j < i){
            j = i;
        }
        while(ngeR[j] < i + k){
            j = ngeR[j];
        }
        ans[i] = arr[j];
    }
	for(int x : ans){
	System.out.println(x);
	}
 }
}