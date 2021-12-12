1. Wherever questions are related to the data side of the tree i.e. the question has something to do with data Binary search Tree will optimise the solution as complexoty can be reduced but in case the data is not involved then the time complexity for both BST and binary tree will be same.
2. When you have to manipulate the connections like in case of Removal , addition we will keep the return type of the function as Node type so that automatically all the connections are fixed when the function returns from the base case.
3. Removal of a node from a binary tree :
  - when we have to remove a tree from a node , we will have three kind of nodes for which we can be asked to perform removal :
    - node that has no child -> incase no child we will just return null so that the parent of that node will have null on its appropriate child
    - node that has a single child -> when we reach at the node which needs to be removed we return address of the only child
    - node that has 2 child -> we can have two ways to perfrom deletion for such node
      - case 1 : take the max from the left side of that node (the max node will always be a node with no child or a single child ) , copy the data of max node to the node that needs to be removed and then make a call to remove the max node from the left subtree
      - case 2 : take the min from the right subtree (all the nodes on the right will be greater than this node, so BST property will be still valid), copy the data of min node to the node to which needs to be removed and call a remove the min node from the lright subtree

4. Replace with sum of larger :
  - the largest number in a bst is in the right bottom node, and our smallest problem i.e replace with sum of larger will also be on the right bottom node as sumof larger elements for the last bottom right node will be zero 
  - here we need to traverse Right Call , self work, left work

5. Lowest common ancestor between two nodes in BST :
  - In normal binary tree , we will find node to root path for both the nodes and find the first common node but in case of BST we can optimise the approach by using the BST property.
  - Incase of BST, the lowest common ancestor will be, if the current node on which we are standing is greater than node1 and is less than node2 then that point will be the divergent point.

6. Print in range : 
  - We are given a range lo,hi any element which lies between the range we need to print it. But the printing order should be ascending .
  - Approach 1 :
    - As we already know if we print all the nodes of a BST in inorder manner we get a sorted list , we will use the same technique.
    - we will go to each node and check if it lies between lo and hi , if yes we will print it inorder.
  - Approach 2 :
    - Instead of traversing all the nodes we will traverse only correct nodes,
      - if node.data > hi then there is no point going to the right as all the nodes to the right will be greater than hi and will fall out of range
      - if node.data < lo , then there is no going to the left as all the nodes to the left will be smaller than lo and will fall out of range
      - if node.data is between lo and hi , from here we can go both left and right side but inbetween the calls we will print the data. 
