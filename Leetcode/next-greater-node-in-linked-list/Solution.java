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
    public int[] nextLargerNodes(ListNode head) {
        ListNode pointer1 = head;
        int size = 0;
        while (pointer1 != null){
            pointer1 = pointer1.next;
            size++;
        }
        ListNode pointer = head;
        
        int[] arr = new int[size];
        int[] res = new int[size];
        int k = 0;
        while (pointer != null){
            arr[k] = pointer.val;
            pointer = pointer.next;
            k++;
        }
        Stack<Integer> st = new Stack<>();
        st.push(res.length-1);
        res[res.length-1] = 0;
        for(int i = arr.length-2;i>=0;i--){
            
            while(st.size()>0 && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.size()==0){
            res[i] = 0;    
            }else{
                res[i] = arr[st.peek()];
            }
            
            st.push(i);
        }
        return res;
    }
}