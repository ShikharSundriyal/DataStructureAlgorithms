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
       
