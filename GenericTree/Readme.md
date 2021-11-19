## General :
1. Height of a generic tree (level of a generic tree): 
  - Means the distance from the root node to the deepest node
  - If height in terms of edges , then initialize height=-1
  - If height in terms of nodes, then initialize height = 0
  - faith , get the height of childrens of the root node
  - from faith to expectation, whichever child height is greater take that height and add one as there is one edge between the child node and root node
2. Level order traversal Line wise : 
  - We will need to use queue because queue follows first in first out, at any point there are only 2 levels of tree in the queue
  - Approach 1 :
    -   Have 2 queues main q and helper q
    -   Add root node to the mainQ and add the children of root node to helper Q
    -   While mainQ.size()>0
      - remove the element from mainQ , print the element and add its children to helper Q
      - if mainQ.size() == 0 that means one level has finished , print a line and make mainQ = helperQ and helperQ = new arrayDeque<>()
   - Approach 2 :
    - using a single Queue
    - push root node and a node containing null 
    - while q.size()>1
      - remvove the element from q , 
        - if the node contains null then print new line and push another node conataining null
        - else print the data of node and push the childrens also to the queue
   - Approach 3 :
    - using a single queue
    - push root node
    - while(q.sisze()>0)
     - int sz = mainQ.size(); // finding the number of elements in a level that need to be printed in one line
     - for(int i = 0;i<sz;i++)
      - remove the element, print the element and add children to the queue      
     - System.out.println()
    
3. Level order traversal Line wise ZigZag :
  - Approach 1 : Make a queue , add root element , maintain a level variable = 0 , sz = mainQ.size()
  - while mainQ size > 0
    -  for int i = 0; i<sz ;i++
      - remove element from the mainQ and add to a new list  , add its children to the mainQ
     - if even level  print from 0 to last element
     - if level is odd , then print elements from last element to 1st element
     - level++
  - Approach 2 : Maintain two stacks and a level variable
    - add root node to the mainStack 
    - while mainStack.size > 0
      - if level is even add children to the helperStack from left to right
      - if level is odd then add children to the helperStack from right to left

4. Remove Leaves In Generic Tree :
  - Here the work needs to be done in the preorder , if we do the work in post order i.e. remove the childrens whose children arraylist size is 0 then all the nodes will be removed except the root node.
  - So here the faith will be , remove the child nodes from the leaf node
  - work will be, remove the node from the node.children arraylist whose node.children.size is 0 ( node.children.get(i).children.size()==0 )

5. Are Trees Similar:
  - similar means the length of children of the node should be equal at each node for both the trees

6. Mirror of a Tree :
  - we have to apply reverse to all childrens of the node

7. Are two trees mirror of each other : 
  -  Travel one tree in normal euler and other tree in reverse euler and children size should be equal for both the nodes.
 
8. Is a tree symmetric :
  - Symmteric means if the mirror image of tree is equal to the tree itself
  - isMirror(node, node)

9. Ceil and Floor of a Node :
  - Make two static variables , ceil and floor
  - traverse the complete tree and check if the value is greater than the value of the node for which ceil has to be calculated 
    - if yes, check if pre existing value of ceil is greater than the current node value , if yes replace the ceil
  - traverse the complete tree and check if the value is lesser than the value of the node for which floor has to be calculated
    - if yes, check if the pre existing value of floor is less than the value of the current node, if yes replace the floor

10. Kth largest element in a tree :
  - Brute Force :
    - traverse the entire tree and fill the values in a arraylist
    - sort the arraylist and kth element from the last will be the kth largest element
   - Optimal Approach :
     - using floor method that we used above,
      - for 1st largest , calculate the floor of infinity
      - for 2nd largest , calulate the floor of infinity and then again call floor function on the value obtained from the previous floor fucntion call

11. Node with maximum subtree sum :
  - Here we have to find the node whose subtree sum is maximum.
  - at each node we have to calculate the sub tree sum and we will compare if that is greater than the already existing maximum sub tree sum
  - Keep 2 static variable Node n and int maxsum
  - write a method sum which returns the sum of a tree at each node
    - to get sum our faith will be get the sum of child nodes and add the current nodes data , while doing so compare if that sum is greater than maxsum static variable
  - Approach 2 : without static variables
    - Create a pair class , which has 3 data members maxsum , Node with maxsum and total sum of an subtree
    - Faith is each child gives sum maximum subtree sum, node which forms ma subtree sum and the sum of the subtree at that particular node
    - to find the maxsubtreesum, we compare each childs maxsubtreesum and maintain a max and for total sum we add sum of each child node and finally add nodes data and check if the sum is greater than the max sum obtained from childs  
    

12. Diameter of a generic tree : 
  - Diameter is defined as the maximum distance between any two nodes
  - Brute Force : 0(n3)
    - Find all the leaf nodes and fill them in an arrylist
    - now start a for loop inside a foor loop and find the two nodes who have greatest distance between them. (distance between two nodes, Find node to root path for both nodes and then find the distance)
   
   - Optimised :  0(n) using static variable
    - Use height of a generic tree method , the height function goes to each node and finds the height of the tree rooted at that node 
      - keep a static variable diameter
      - maintain two variables childheightmax1 and childheightmax2 which will contain the 1st max height and 2nd max height out of the child nodes and at each node check if childheightmax1 + childheightamx2 +2 is greater than the static diameter variable
      -    
    - Without using static variable , pure faith and expectation
      - faith : Our method will return a pair containing the height of the child and max diameter possible acorss any of the childs child subtree
      - from faith to expectation : 
        - find 1st highest height of child and 2nd highest height of the child 
        - also compare find the best diamter amongst the childrens
        - once outside the loop calculate tif 1st highest height + 2nd highest height +2 is greater than the current diamter if yes update the diamter and return a Pair object containing the height of current node i.e. 1st highest height + 2nd highest height + 2 , diameter
