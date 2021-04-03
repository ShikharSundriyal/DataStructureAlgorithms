/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one = headA;
        ListNode two = headB;
        int size1 = getSize(one);
        int size2 = getSize(two);
        if(size1 > size2){
            for(int i = 0;i<size1-size2;i++){
                one = one.next;
            }
        }else if(size2 > size1){
            for(int i = 0;i<size2-size1;i++){
                two = two.next;
            }
        }
        
        while(one!=null){
            if(one == two){
                return one;
            }
            one = one.next;
            two = two.next;
        }
        return null;
    }
    public int getSize(ListNode headA){
        ListNode temp = headA;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}