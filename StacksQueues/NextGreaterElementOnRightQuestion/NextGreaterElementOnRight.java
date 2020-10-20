import java.util.Scanner;
import java.util.Stack;
class NextGreaterElementOnRight{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for( int i = 0; i < arr.length; i++){
			arr[i] = sc.nextInt();
		}
		int[] res = getNextGreaterElement(arr);
		for(int val:res){
			System.out.println(val);
		}
	}
	public static int[] getNextGreaterElement(int[] arr){
		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];
		st.push(arr[arr.length-1]);
		res[arr.length-1] =-1;
		for(int i = arr.length-2;i >= 0; i--){
			while(st.size() > 0 && arr[i] >= st.peek()){
				st.pop();
			}
			if(st.size() == 0){
				res[i] = -1;
			}else{
				res[i] = st.peek();
			}
			st.push(arr[i]);
		}
		return res;
	}
}