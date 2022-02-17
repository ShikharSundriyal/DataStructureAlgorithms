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
      
```   
</p>
</details>

2. 84 Largest Rectangle in Histogram :
  - Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
  - In this we will at each height[i] we will consider that height of rectangle is height[i] and we need to find the max possible widht , which will be next smallest element on the right - next smallest element of the left -1

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
 
```   
</p>
</details>

  
3. 921 Minimum Add to Make Parentheses Valid :
  - Return the minimum number of moves required to make s valid.
  - Simple approach is we need to remove the balanced brackets and the remaining unbalanced brackets will give us the count of additional parentheses requeired to make the string valid.
  
  
<details><summary>Code</summary>
<p>

  class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else{
                
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
}
 
```   
</p>
</details>
