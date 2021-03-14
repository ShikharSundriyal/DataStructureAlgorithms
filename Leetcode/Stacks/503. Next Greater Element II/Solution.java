class Solution {
    
    public int[] nextGreaterElements(int[] arr) {
        /* only difference from normal next greater element question is, for the last element first push the indexes from
        arr.length-2 to 0 and then start the next loop to get the nge from arr.length-1 index. The process remains same
        1) pop all smaller elements ,
        2) if st.size == 0 that means no next greater element for current index exist else nge is arr[st.peek]
        3) Push the current index to stack
         */
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-2;i>=0;i--){
            st.push(i);
        }
        int[] res = new int[arr.length];
        for(int i = arr.length-1;i>=0;i--){
            //pop all smaller elements
            while(st.size() > 0 && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            res[i] = st.size() == 0?-1:arr[st.peek()];
            st.push(i);
        }
        return res;
    }
}