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

8. 206 Reverse Linked List :
  - Given the head of a singly linked list, reverse the list, and return the reversed list.
  - Approach : Pointer iterative :
    - Create two variables ,current = head, prev = null 
    - start a while loop while current != null
      - Store the next address of the current in a temp variable
      - make the curr.next = prev 
      - move prev = curr 
      - curr = temp
<details><summary>Code</summary>
<p>

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode current = head;
        ListNode prev = null;
        while(current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
```
  
</p>
</details>  	 

9. 21 Merge Two Sorted Lists :
	- Make a dummy ListNode node and have a dummy tail pointer which is pointing to dummyhead
	- Now iterate over both the list and check which node is smaller , whichevever node is smaller make a connection of dummytail pointer with that node and move the dummytail to that node and move to the next element of the list.
	- at the end if any of the list is still not traversed completely add the dummtail pointer to point to that list and return dummhead.next as the final head of merged linked list

<details><summary>Code</summary>
<p>

```java

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dh = new ListNode();
        ListNode dt = dh;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dt.next = list1;
                dt = list1;
                list1=list1.next;
            }else{
                dt.next = list2;
                dt = list2;
                list2 = list2.next;
            }
            
        }
        if(list1!=null){
            dt.next = list1;
        }
        if(list2!=null){
            dt.next = list2;
        }
        return dh.next;
    }
}

```
  
</p>
</details>

10. Palindrome Linkedlist :
	- Given the head of a singly linked list, return true if it is a palindrome.
	- Approach 1 : 
		- find the mid node
		- make one linked list into two 
		- reverse the second linked list
		- iterate over both the linked list and see if both are equal

<details><summary>Code</summary>
<p>

```java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mid(ListNode head){
        ListNode s=head,f=head;
        while(f.next!=null && f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = mid(head);
        ListNode secondhead = mid.next;
        //break the linked list
        mid.next = null;
        secondhead = reverse(secondhead);
        while(secondhead!=null){
            if(head.val != secondhead.val) return false;
            head = head.next;
            secondhead = secondhead.next;
        }
        return true;
    }
}

```
  
</p>
</details>

10. 148 Sort List :
	- Given the head of a linked list, return the list after sorting it in ascending order.
	- We wil apply merge sort
	- find mid 
	- divide the list into 2 linkedlist 
	- apply mergeTwoSortedList on these two list
	- base case wil be where head.next == null return head i.e. if only one node is present so 


<details><summary>Code</summary>
<p>

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwo(ListNode h1,ListNode h2){
        ListNode dh = new ListNode();
        ListNode dt = dh;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                dt.next = h1;
                h1 = h1.next;
                dt = dt.next;
            }else{
                dt.next = h2;
                h2 = h2.next;
                dt = dt.next;
            }
        }
        if(h1!=null){
            dt.next = h1;
        }
        if(h2!=null){
            dt.next = h2;
        }
        return dh.next;
    }
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next==null) return head;
        ListNode mid = mid(head);
        ListNode sh = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(sh);
        
        return mergeTwo(l1,l2);
    }
}
```
  
</p>
</details>

11. 143 Reorder List :
	- You are given the head of a singly linked-list. The list can be represented as: L0 → L1 → … → Ln - 1 → Ln
	- Reorder the list to be on the following form: L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
	- Approach 1 : 
		- Find Mid
		- divide the linked list into 2 parts
		- Now reverse the second part of LL.
		- Now alternatively select one element from l1 and other ithem from l2 till l1!=null or l2!=null



<details><summary>Code</summary>
<p>

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        while(current!=null){
            ListNode nxt = current.next;
            current.next = previous;
            previous = current;
            current = nxt;
        }
        return previous;
    }
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast= head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        ListNode mid = mid(head);
        ListNode sh = mid.next;
        mid.next = null;
        ListNode rev = reverse(sh);
        boolean flg = true;
        ListNode dh = new ListNode();
        ListNode dt = dh;
        ListNode t1 = head;
        ListNode t2 = rev;
        while(t1!=null || t2!=null){
            if(flg == true){
                dt.next = t1;
                dt = dt.next;
                t1 = t1.next;
            }else{
                dt.next = t2;
                dt = dt.next;
                t2 = t2.next;
            }
            flg = !flg;
        }
    }
}
```
  
</p>
</details>


12. Unfold Of Linkedlist :
	- Input : 1->7->2->6->3->5->4->null
	- Output : 1->2->3->4->5->6->7->null
	- Approach 1 :
		- Make two dummy nodes head and tail
		- while iterating over the main LL ,make two list by alternatively adding one element to each list
		- make the tail of both the list as null
		- reverse the second list
		- now add the second list to the tail of the first list

<details><summary>Code</summary>
<p>

```java
public static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        while(current!=null){
            ListNode nxt = current.next;
            current.next = previous;
            previous = current;
            current = nxt;
        }
        return previous;
    }
    public static void unfold(ListNode head) {
        ListNode dh1 = new ListNode(-1);
        ListNode dt1 = dh1;
        ListNode dh2 = new ListNode(-1);
        ListNode dt2 = dh2;
        ListNode temp = head;    
        boolean flg = true;
        while(temp!=null){
            if(flg){
                dt1.next = temp;
                dt1 = dt1.next;
            }else{
                dt2.next = temp;
                dt2 = dt2.next;
            }
            temp = temp.next;
            flg=!flg;
        }
        dt1.next = null;
        dt2.next = null;
        ListNode secondhead = reverse(dh2.next);
        dt1.next = secondhead;
        head = dh1.next;
    }
```
  
</p>
</details>

13. 328 Odd Even Linked List :
	- Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.The first node is considered odd, and the second node is even, and so on.
	- Approacch 1 :
		- Create 2 dummy head and 2 dummy tail
		- iterate over the main LL :
			- alternatively add element from main LL to dummy lists
		- make the dummy tails of both list as null
		- now make the dummytail1.next = dummyhead.next
		and return dummhead1.next

<details><summary>Code</summary>
<p>

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dh1 = new ListNode();
        ListNode dt1 = dh1;
        ListNode dh2 = new ListNode();
        ListNode dt2 = dh2;
        ListNode temp = head;
        boolean flg = true;
        while(temp!=null){
            if(flg){
                dt1.next = temp;
                dt1 = dt1.next;
            }else{
                dt2.next = temp;
                dt2 = dt2.next;
            }
            temp=temp.next;
            flg=!flg;
        }
        dt1.next = null;
        dt2.next = null;
        dt1.next = dh2.next;
        return dh1.next;
    }
}
```
  
</p>
</details>

14. 19 Remove Nth Node From End of List :
	- Given the head of a linked list, remove the nth node from the end of the list and return its head.
	- Approach 1 : 
		- In single pass, we maintain two pointer slow and fast and maintain a gap of k i.e. [1 to k] when fast.next==null then slow pointer will be at k-1 position and we omit the connection of kth node.
		- Some of the edge cases are when you have to remove the first node from the beginning in that case the fast will become null so we will check after mocing k steps if fast is at null we need to return head.next
		- otherwise we move slow and fast pointer by 1 step until fast.next!=null
		- then we make slow.next = slow.next.next

<details><summary>Code</summary>
<p>

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i =1;i<=n;i++){
            fast = (fast!=null?fast.next:null);
        }
        if(fast == null){
            return head.next;
        }
        else{
            while(fast.next!=null){
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next; 
        }
        return head;
    }
}
```
  
</p>
</details>
