class Main {
    // usage of get smallest element on the left and smallest element on the right
    public static int[] getSmallestElementRight(int[] arr){
        
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        st.push(arr.length-1);
        res[arr.length-1] = arr.length;
        for(int i = arr.length-2;i>=0;i--){
            //pop all larger elements
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            //make your answer
            if(st.size()==0)
                res[i] = arr.length;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public static int[] getSmallestElementLeft(int[] arr){

        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        st.push(0);
        res[0] = -1;
        for(int i = 1;i<arr.length;i++){
            //pop all larger elements
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            //make your answer
            if(st.size()==0)
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nsR = getSmallestElementRight(heights);
        int[] nsL = getSmallestElementLeft(heights);
        int max = 0;
        for(int i=0;i<heights.length;i++){
            max = Math.max(max,heights[i] * (nsR[i] - nsL[i] -1));
        }
        return max;
    }
}