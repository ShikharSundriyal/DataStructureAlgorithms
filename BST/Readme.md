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
  - Approach 1 : 0(n) -> n is number of nodes
    - As we already know if we print all the nodes of a BST in inorder manner we get a sorted list , we will use the same technique.
    - we will go to each node and check if it lies between lo and hi , if yes we will print it inorder.
  - Approach 2 : 0(height of tree)  
    - Instead of traversing all the nodes we will traverse only correct nodes,
      - if node.data > hi then there is no point going to the right as all the nodes to the right will be greater than hi and will fall out of range
      - if node.data < lo , then there is no going to the left as all the nodes to the left will be smaller than lo and will fall out of range
      - if node.data is between lo and hi , from here we can go both left and right side but inbetween the calls we will print the data. 


7. 285 Inorder Successor in BST :
	- Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.The successor of a node p is the node with the smallest key greater than p.val
	- Brute Force : 0(N) , 0(N)
		- get the inorder of the bst in a array and find the exact next element to the element for which the successorr is asked . As the inorder of a BST is sorted. 
	- Optimised :
		- If the node for which successor is needed has a right child then the successor will be the , take a right from current node and then find the left most element in that subtree.
		- If the node does not have a right child then the successor will the ancestor of the current node but the ancestor that is greater than the current value i.e. when we are moving from parent to left child then it can be a possible successor.  
	
<details><summary>Code</summary>
<p>

```java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode succ;
    public void helper(TreeNode root, TreeNode p){
        if(root.val == p.val){
            if(root.right == null){
                succ = succ;
            }else{
                TreeNode tmp = root.right;
                while(tmp.left!=null) tmp = tmp.left;
                succ= tmp;
            }
            
        }else if(root.val > p.val){
            succ = root;
            helper(root.left,p);
        }else{
            helper(root.right,p);
        }
    }
	// Recursive solution
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //one right and extreme left
        succ=null;
        helper(root,p);
        return succ;
    }
} 

// Iterative solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while(root!=null){
            if(root.val>p.val){
                //as we have to move left we have a possibility that root is succ
                succ = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return succ;
    }
} 
```
  
</p>
</details>  	
	
897. Increasing Order Search Tree
	- Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
	- Approach 1 : Time 0(N) , Space 0(N)
		- create a dummy root and preserve it in a different variable
		- travel the given tree in inorder traversal and while in inorder create a new TreeNode and add to the dummy root's next and keep on moving the dummy root to current nodes right
		- at the end return the dummy root right which was preseverned in a variable
	- Approach 2 : Time 0(N), Space 0(1)
		- Create a dummy root and preserve it in a different variable
		- now travel the tree in inorder traversal
		- in inorder step , break the connection of the current node's left and add it to the dumm heads right 
		- at the end return the dummy root right which was preseverned in a variable

<details><summary>Code</summary>
<p>

```java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
// Approach 1
    public void helper1(TreeNode node){
        if(node == null) return;
        helper(node.left);
        res.right = new TreeNode(node.val);
        res = res.right;
        helper(node.right);
        
    }	
// Approach 2
    public void helper(TreeNode node){
        if(node == null) return;
        helper(node.left);
        node.left = null; // breaking connection
        res.right = node; // attaching node
        res = res.right; // move the dummy head
        helper(node.right);
        
    }
    TreeNode res;
    // TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        
        res = new TreeNode(Integer.MIN_VALUE);
        TreeNode temp = res;
        helper(root);
        res.right = null;
        return temp.right;
    }
}
```
  
</p>
</details> 	

230. Kth Smallest Element in a BST :
	- Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
	- Brute Force, 
		- travel the BST in in-order traversal and fill the elements into an arraylist 
		- and then once we have the arraylist we will get arraylist.get(k-1)
	- Approch 2 : 
		- Travel in inorder traversal , maintain a global level variable which is increased in inorder and check if level == k then set your answer in a variable 

	
<details><summary>Code</summary>
<p>

```java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int t;
    int ans;
    public void helper(TreeNode node,int k){
        if(node == null) return ;
        helper(node.left,k);
        if(t == k){
            ans = node.val;
        }
        t++;
        helper(node.right,k);
        // return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        
        t = 1;
        ans = 0;
        helper(root,k);
        return ans;
    }
}
	
```
  
</p>
</details> 
