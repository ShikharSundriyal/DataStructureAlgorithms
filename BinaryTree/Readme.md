1. Construction of a Binary Tree from an array :
    - Given an array : [10 20 -1 40 -1 -1 30 50 -1 -1 60 -1 -1] we need to construct a binary tree from it
    - Take a Stack : 
      - put first element i.e. 10 , create a Node out of it and create a Pair obj having node and state where state = 0 initially -> insert into stack
      - while stack.size() >0 : 
        - create a node from element 20 , 
          - now check the peek of the stack and see the state of the Pair obj if its 0 , add current node to the stacks peek obj's left child    
          - if state of the Pair obj is 1 , add current node to the stacks peek obj's right child
        - if element = -1 , checks stacks peek and put the peeks obj correct child either left or right based on the state value to null
      - while iterating over the array check if the state of the Pair obj at the stacks peek has become 2 then pop that element from stack

2. Construction on input array from a give Binary Tree : 
    -  Iterate over the elements of tree , in preorder input the element in the array and if the left or right child is null add -1 

3. Binary tree leaf to root path : 
    - Apply recursion on the way up to form the path to leaf nodes.
    - make the base case at the leaf node itself .
    - Maintain a string as an argument to the function whil will form the actual path from root to leaf node. 

4. Print K Level down : 
    - Approach 1 : Iterative approach 
        - Same approach as level order , additionaly maintain a level variable , when level variable is equal to given k then , break and print all the Noded present in queue.
    - Approach 2 : Recursive approach 
        - create a function kelevel(Node node, int k , int level)
        - initially keep level is 0 , on each call increase the level variable by 1 when making the call this way all nodes of a level will have a level variable
        - put a if condition that is k == level , print the Node.data
             
5. Remove leaf nodes from binary tree :
    - Approach 1 : Without using a return type from the function
        - void removeLeaves(Node node) -> 
            - we have one option that we stand at a node and look at the child nodes left and right , if childnodes left and right is null i.e. the child node is a leaf node and current nodes child needs to be updated to null. But here we will need additional checks to handle null pointer
            - Another option is we add another parameter parent in the function which will keep the current nodes parent and also a indicator as a paramter that whether current node is left child or right child of the parent.
     - Appraoch 2 : With a return type Node removeLeaves(Node node)
        - here base case is if node == null return null or node.left == null and node.right == null return null
        - in the calls we will have node.left = removeLeaves(node.left); , node.right = removeLeaves(node.right) , in this way when we fall from child to parent we will fall to correct node that is either left child or the right child. 

6. Transform to a left cloned tree :
    - at each left child node add another node same as node.
    - Purely based on faith and expectation
    - faith is we will get left cloned tree from node.left and we will get left cloned tree from node.right
    - from faith to expectation :
        - in post order we create a new node same as current node, add that node to the current nodes left child and the add previous left child node which we have recived from node.left call as the child of new node.
   
7. Tranform a left cloned tree to a normal tree :
    - Purely faith and expectation, we know that root nodes left child is someone whom we want to remove
    - so our faith will be get normal tree from node.left.left skipping the current nodes left child as its an extra node because of left cloned
    - now from faith to expectation, make node.left = the node that we got from node.left.left call thus eliminating the extra node

8. Tilt of a binary tree :
    - Approach 1 : using static variable
        - Tilt for a node is defined as the absolute difference between left subtree sum and right subtree sum for a node.
        - Tilt for a binary tree is defined as the sum of all the tilts of nodes in a tree.
        - We will travel the complete tree , and each node will return its subtreesum, before returning sub tree sum for a node we will also calculate the tilt of that node and add it to the total tilt variable that we are maintaining as a static value.
    - Approach 2 : without using static variable (pure faith and expectation)
        - faith : our child will return un a Pair object containing the total tilt rooted at subchild and also return a subtree sum rooted at child.
        - from faith to expectation : caculate subtree sum i.e. left subtree sum - right sub treesum , tilt will be left subtree sum - right sub treesum  + left tilt + right tilt.

9. Is a tree balanced : All nodes should have a balancing factor less than 2 , Balancing factor = Abs (left trees height - right trees height)
    - Approach 1 : using a static variable
        - traverse over the tree using the height function and calculate balancing factor and if balancing factor >=2 for aany node make the static variable isBlanced = false
    - Approach 2 : without using static variable
        - Faith : 
            - left child call will give us a Pair containing , boolean is tree balanced and the height of the subtree rooted at left child
            - right child call will give us a Pair containing , boolean is tree balanced and the height of the subtree rooted at right child
        - From faith to expectation : 
            -  calculate the balancing factor for root node that will be , left child height - right child height and height i.e Max(left child height, right child height)+1
             
             
10. Is binary tree a bst : ( the logic is the current node should be greater than all the nodes on the left and lesser than all the nodes on the right i.e. we need min and max from left child and right child ) 
    - Faith : 
        - left call will return the max and min values from the subtree rooted on left child 
        - right call will return the max and min values from the subtree rooted on right child
     - from faith to expectation :
        - on root node, the root nodes value should be greater than the max value from the left child and root nodes value should be less than the least value from the right childs node. And as is bst property has to checked for each node  we also return a isbst boolean value along with min and max from the left and right subtree.


11 . Largest BST Subtree : 
    - For largest BST subtree we have to travel each node and determine whether it is a BST or not , if yes capture the sz of the subtree
    - The travlleing we will do same as ISBST logic , so it will return a pair of min, max,isbst additionally it will return the sz of the largest subtree
    - If the node at which we are is a BST then the sz will become left.sz + r.sz + 1 .
    - If the node is not the BST then the sz will be MAX of left.sz and right.sz
    - Method Defination  Pair ISBST(Node node),  Pair (int min, int max, boolean isbst, int sz)
