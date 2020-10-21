class StockSpan{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for( int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		int[] res = getStockSpans(arr);
		for(int val:res){
			System.out.println(val);
		}
	}
	public static int[] getStockSpans(int[] arr){
		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];
		res[0] = 1;
		st.push(0);
		for( int i = 1; i < arr.length; i++){
			while( st.size()>0 && arr[i] >= arr[st.peek()]){
				st.pop()
			}
			if(st.size() == 0){
				res[i] = i+1;
			}else{
				res[i] = i - st.peek();
			}
		}
		return res;
	}
}