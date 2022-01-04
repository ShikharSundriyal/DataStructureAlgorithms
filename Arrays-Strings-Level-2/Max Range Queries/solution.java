public class MyClass {
    public static void maxRangeQueries(int[] arr, int k, int[][] queries){
	
	int[] finarr = new int[arr.length];
	
	for(int i =0;i<queries.length;i++){
		int si = queries[i][0];
		int ei = queries[i][1];
		finarr[si]+=1;
		if(ei+1<arr.length)
			finarr[ei+1]-=1;
	}
	for(int i =1;i<arr.length;i++){
		finarr[i] = finarr[i-1]+finarr[i];
	}
	int total_k=0;
	for(int i:finarr){
		if(i==k) total_k++;
	}
	int[] countk = new int[arr.length];
	int[] countkp = new int[arr.length];
	if(finarr[0] == k ){
		countk[0] =1;
	}
	if(finarr[0] == k+1){
		countkp[0]=1;
	}
	for(int i =1;i<finarr.length;i++){
		if(finarr[i] == k){
			countk[i] = countk[i-1]+1;
		}
		if(finarr[i] ==k+1){
			countkp[i]=countkp[i-1]+1;
		}
	}
	int res = Integer.MIN_VALUE;
	for(int i =0;i<queries.length;i++){
		int si = queries[i][0];
		int ei = queries[i][1];
		int ck = countk[ei]-(si-1>=0?countk[si-1]:0);
		int ckp1 = countk[ei]-(si-1>=0?countk[si-1]:0);
		int total = total_k - (ck)+(ckp1);
		if(total>res) res = total;
	}
	System.out.println(res);
}
    public static void main(String args[]) {
      int[][]queries = {{1,5},{2,7},{0,3},{6,7}};
    int k = 2;
	int len = 8;
	int[] arr = new int[len];
	maxRangeQueries(arr,k,queries);
    }
}
