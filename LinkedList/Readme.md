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
