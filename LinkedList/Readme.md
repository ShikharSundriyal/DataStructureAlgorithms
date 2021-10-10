1. Kth Node from the end 
  -Approach 1 : 0(N), 2 traversal required
    -Find the size of the linked list by traversing , now return the element at index from front k+1 element 
  - Approach 2 : 0(N), single traveral , without using size
    - keep 2 pointers , both at head initially 
      -  move the fast pointers k times ahead of slow pointer and after that move both the pointers with equal speed once fast pointer reaches last element of linked list the slow pointer will be k distance apart from the end .
      
2. Mid of a linked list :
  - Approach 1 : without using size 
    - Keep two pointers , slow and fast both at head initially 
    - move the fast pointer with double speed while slow pointer moves with speed 1 
    - once the fast pointer reaches the last node incase of odd length linked list(fast.next!=null) and if fast pointer reaches the second last node of linked list, if length of linked list is even (fast.next.next!=null) . The slow pointer would be sitting at the middle of the linked list
  

3. reverse Linked List pointer recursive :
    - Approach 1 : space 0(n) , time 0(n)
      - base case node.next == null return
      - travel to the end of the linked list -1 node
      - now , Node current = prev.next
      - now , current.next = prev; (change the link)
      - After the helper function
      - head.next = null; (this is needed because the first element will not a change to become current )
      - now swap , head and tail

4. reverse Linked List data iterative :
  - Approach 1  space 0(n) time 0(n) 
    - store the elements of linked list in array
    - now traverse the linkedlist and update the data with reverse values of array

  - Approach 2 space 0(1) time 0(n^2)
    - left from head swap with right (right we will get from getNodeAt(x))
    - while(l<=r)

5. Odd Even Linked List :
  - Approacch 1 : Space 0(1) , Time 0(N)
    - Create two linked list, even and odd
    - one by one remove each element from the main linked list and add that element as a new node to either even or odd (as one node is removed from Main Linked list and one node is being created , so overall space is constant at any time and does not cross N)
    - Once the main Linked list is empty , manage the head , tail and size of the final linked list by merging the odd and even linked list
  - Approach 2 : Space 0(1) , Time 0(N) (Here we are not using new node, and same node is being used)
    - Here traverse over main linked list, make the next of current node as null and based on data add the node (addLast) to either even or odd list
    - then join odd and even linked list
    - Adjust head and tail 

6. Fold a linked List : 
  - Approach 1 : Time 0(N) , Space 0(N) recrsion space
    - Keep a left Node as the data member of the class and initialise with head.
    - Make a foldHelpler Fucntion which takes two parameters(Node right, int floor)
    - take right to the end of the linked list by calling the function recursively and at each level do the following
      -   Node temp = left.next, left.next = right, right.next = temp, front = temp;
      -   Above step should happen only for half of the elements of  the linked list i.e. floor < size/2
      -   when floor == size/2 then tail = right , tail.next = null;

7. Add Two Linked Lists
  - Approach 1 : Time 0(N), Space 0(N)
    - find the difference between number of nodes between the two linkedlist say d
    - whichever list is bigger move its pointer d times forward , so that both list 1 and list 2 are at same posiiton which can be added
    - Now make a recursive call to the helper function which takes two nodes and a LinkedList as a parameter
    - once we reach to the end of both the linked list add the data part of both nodes and add that as First Node, also calculate carry and update its value as its a static variable
    - now once the common length nodes of both list are added now we need to take care of the nodes which we moved forward d times 
      - d-- , 
      - while d>=0 Node t = either list1.head or list2.head whichever is bigger in length 
        - for(int i = 0;i<=d;i++){t=t.next} add carry and the node data and add the element to the linked list
