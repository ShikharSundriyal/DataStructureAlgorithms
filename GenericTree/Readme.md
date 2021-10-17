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
