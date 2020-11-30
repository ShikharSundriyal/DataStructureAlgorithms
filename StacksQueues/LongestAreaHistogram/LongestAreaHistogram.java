import java.io.*;
import java.util.*;

public class LongestAreaHistogram{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int res = getLargestArea(a);
    System.out.println(res);
    
    // code
 }
 
	public static int getLargestArea(int[] arr){
		Stack<Integer> st = new Stack<>();
		int[] leftboundary = new int[arr.length];
		st.push(0);
		leftboundary[0] = -1;
		for( int i = 1;i < arr.length; i++){
			while(st.size()>0 && arr[i] < arr[st.peek()]){
				st.pop();
			}
			if(st.size() == 0){
				leftboundary[i] = -1;
			}else{
				leftboundary[i] = st.peek();
			}
			st.push(i);
		}
		Stack<Integer> st1 = new Stack<>();
		int[] rightboundary = new int[arr.length];
		st1.push(arr.length-1);
		rightboundary[arr.length-1] = arr.length;
		for( int i = arr.length-2;i >= 0; i--){
			while(st1.size()>0 && arr[i] < arr[st1.peek()]){
				st1.pop();
			}
			if(st1.size() == 0){
				rightboundary[i] = arr.length;
			}else{
				rightboundary[i] = st1.peek();
			}
			st1.push(i);
		}
		int max = 0;
		for( int i = 0;i < arr.length; i++){
			int width = rightboundary[i] - leftboundary[i] -1;
			int area = width * arr[i];
			if( area>max){
				max=area;
			}
		}
		return max;
	}
}