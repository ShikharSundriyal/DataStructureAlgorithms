1. Construction of a Binary Tree from an array :
  - Given an array : [10 20 -1 40 -1 -1 30 50 -1 -1 60 -1 -1] we need to construct a binary tree from it
  - Take a Stack : 
    - put first element i.e. 10 , create a Node out of it and create a Pair obj having node and state where state = 0 initially -> insert into stack
    - iterate over array : 
      - create a node from element 20 , 
        - now check the peek of the stack and see the state of the Pair obj if its 0 , add current node to the stacks peek obj's left child    
        - if state of the Pair obj is 1 , add current node to the stacks peek obj's right child
       - if element = -1 , checks stacks peek and put the peeks obj correct child either left or right based on the state value to null
     - while iterating over the array check if the state of the Pair obj at the stacks peek has become 2 then pop that element from stack

2. Construction on input array from a give Binary Tree : 
  -  Iterate over the elements of tree , in preorder input the element in the array and if the left or right child is null add -1 
