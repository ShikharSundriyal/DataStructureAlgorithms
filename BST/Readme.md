1. Wherever questions are related to the data side of the tree i.e. the question has something to do with data Binary search Tree will optimise the solution as complexoty can be reduced but in case the data is not involved then the time complexity for both BST and binary tree will be same.
2. When you have to manipulate the connections like in case of Removal , addition we will keep the return type of the function as Node type so that automatically all the connections are fixed when the function returns from the base case.
3. Removal of a node from a binary tree :
  - when we have to remove a tree from a node , we will have three kind of nodes for which we can be asked to perform removal :
    - node that has no child -> incase no child we will just return null so that the parent of that node will have null on its appropriate child
    - node that has a single child -> when we reach at the node which needs to be removed we return address of the only child
    - node that has 2 child -> we can have two ways to perfrom deletion for such node
      - case 1 : take the max from the left side of that node (the max node will always be a node with no child or a single child ) , copy the data of max node to the node that needs to be removed and then make a call to remove the max node from the left subtree
      - case 2 : take the min from the right subtree (all the nodes on the right will be greater than this node, so BST property will be still valid), copy the data of min node to the node to which needs to be removed and call a remove the min node from the lright subtree
      
