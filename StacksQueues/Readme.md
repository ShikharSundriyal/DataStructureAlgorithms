1. Celebrity Problem : Time O(n), Space O(1) if two pointer and Space 0(n) if using Stacks </br>
Can we done without stack, using a 2 pointer approach. </br>
Step 1 find the possible celebrity candidate either using 2 pointer or stack </br>
Step 2 then check row and column for the potential candidate </br>

2. PostFix and Prefix are better than infix because 2 expressions can have same infix but the postfix and prefix will be different.
example ( a+b )* b , example 2 a*(b+c) (relate the preorder, postorder of recursion tree)

3. When working with infix expression we need two stack , operator and operand stack.
4. order of operator in Prefix exp is opposite order in which they have to be solved. +a-bc (+ will be solved 2nd), first b-c is solved
5. order of operator in Postfix exp is same order in which they have to be solved. 
