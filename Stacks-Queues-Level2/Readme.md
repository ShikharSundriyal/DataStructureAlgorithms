1. Next Greater element to the right (circular array) :
  - In the normal next greater element approach the last element's next greater element is -1 but in case of cirular array all the elements from 0 to arr.length-2 have to be considered
  - to achieve this we first travel from arr.length-2 to 0 
    - pop all the smaller elements from the stack
    - push the current element to the stack (we do not make the answer yet in this step)
  - In the next step we move from arr.length-1 to 0 
    - pop all the smaller elements from the stack
    - if stack is empty that means no next greater element for this element in the array
    - if stack is not empty then the element at the peek of the stack is the next greater element
  
<details><summary>Code</summary>
<p>

```java
  class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(nums[n-1]);
        for(int i = n-2;i>=0;i--){
            while(st.size()>0 && st.peek()<=nums[i]){
                st.pop();
            }
            st.push(nums[i]);
        }
        
        for(int i = n-1;i>=0;i--){
            while(st.size()>0 && st.peek()<=nums[i]){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return nge;
        
    }
}
                                                     
</p>
</details>
 
  
2. 84 Largest Rectangle in Histogram :
  - Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
  - In this we will consider that each height[i] as the possible height of the rectange and then find the maximum possible width for this rectangle which will be nothing but index of next smallest element on the right - index of next greatest element on the left -1
  
<details><summary>Code</summary>
<p>

```java  
  
class Solution {
    public int[] getNextSmallestLeft(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        st.push(0);
        nge[0] = -1;
        for(int i = 1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    public int[] getNextSmallestRight(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        st.push(n-1);
        nge[n-1] = n;
        for(int i = n-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nge[i] = n;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nextSmallestLeft = getNextSmallestLeft(heights);
        int[] nextSmallestRight = getNextSmallestRight(heights);
        int ans = 0;
        for(int i = 0;i<heights.length;i++){
            int widht = nextSmallestRight[i] - nextSmallestLeft[i]-1;
            ans = Math.max(widht*heights[i],ans);
        }
        return ans;
    }
}  
  
</p>
</details>
