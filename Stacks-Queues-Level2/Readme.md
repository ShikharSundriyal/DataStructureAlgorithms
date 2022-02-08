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
