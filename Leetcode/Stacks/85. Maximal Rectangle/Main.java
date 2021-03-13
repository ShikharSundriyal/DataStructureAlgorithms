class Solution {
    public static int[] getSmallestElementLeft(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res[0] = -1;
        for(int i = 1;i<arr.length; i++){
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.size() ==0 ){
                res[i] = -1;
            }
            else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public static int[] getSmallestElementRight(int[] arr){
        
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        res[arr.length-1] = arr.length;
        for(int i = arr.length-2;i>=0; i--){
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.size() ==0 ){
                res[i] = arr.length;
            }
            else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    
    public static int getAreaOfHistogram(int[] arr){
        int res = 0;
        int[] nsr = getSmallestElementRight(arr);
        int[] nsl = getSmallestElementLeft(arr);
        for(int i =0;i<arr.length;i++){
            res = Math.max(res,arr[i] * (nsr[i] - nsl[i] -1));
        }
        return res;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int[][] tr = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                tr[i][j] = matrix[i][j] - '0';
            }
        }
        int res = Integer.MIN_VALUE;
        int[] interArr = new int[tr[0].length];
        for(int i = 0;i<tr.length;i++){
            
            for(int j = 0;j<tr[0].length;j++){
                if(tr[i][j] !=0)
					interArr[j] += tr[i][j];
                else if(tr[i][j] == 0)
                    interArr[j] = 0;
            }
            res = Math.max(res,getAreaOfHistogram(interArr));
        }
        return res;
    }
}