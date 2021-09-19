1. Celebrity Problem : Time O(n), Space O(1) if two pointer and Space 0(n) if using Stacks </br>
Can we done without stack, using a 2 pointer approach. </br>
Step 1 find the possible celebrity candidate either using 2 pointer or stack </br>
Step 2 then check row and column for the potential candidate </br>

2. PostFix and Prefix are better than infix because 2 expressions can have same infix but the postfix and prefix will be different.
example ( a+b )* b , example 2 a*(b+c) (relate the preorder, postorder of recursion tree)

3. When working with infix expression we need two stack , operator and operand stack.
4. order of operator in Prefix exp is opposite order in which they have to be solved. +a-bc (+ will be solved 2nd), first b-c is solved
5. order of operator in Postfix exp is same order in which they have to be solved. 
6. Whenever you have to traverse a recursion tree level by level then we should think of using Queue. (count binary string problem can be solved using queue)
7. Minimum stack : 
Approach 1 (incorrect): If we think of maintaining a single int min while we push the elements to the stack and compare with min than this approach is wrong incase of pop the the element will be removed and there is a chance that the minimum will change
Approach 2 : Constant Time with Additional space ( O(n) ) </br>
Make a minstack, add first element , on second element if st.peek() > second element then push second element to the minstack by this way we are maintaining 1st lowest, 2nd lowest and so on. And incase there is a pop, we will perform pop from the minstack also if the main element that is being popped is at the top of the minstack we will pop from the minstack also whcih means that our minimum value hasbeen removed and second lowest minimum will become 1st highest min.
Approach 3 : Constant Time without Additional Space ()</br>
Maintain a min variable , 
First push first element to the data stack and update min with the first element
On second element if the element > min then simply push the element to the data stack
if the element < min then , encode the value with = val+ (val-min) and min with element.(here you will push a smaller element than the minimum element which indicates it is a fake value)
Now while popping the element , 
if data.peek() < min this means it is a fake value, so return the min that is the original element, find old min to udpate the minimum variable.

8. Two stack :
Approach 1 (incorrect): assume two stacks one on top of another, example 
push1(1),push1(2),push1(3),push1(4)
push2(1),push2(2),push2(3),push2(4) but if we perform a pop on stack1 then releaased space can only be used by 1st stack and 2nd stack cannot use that space.

Approach 2 : Assume stack 1 to grow from below and assume stack 2 to grom from top of the array so the released memory either bt stack1 or stack2 can be used by any of the stacks.
