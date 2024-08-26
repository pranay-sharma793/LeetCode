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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode curr = head;

        for(int i =1; i < k; i++){
            curr = curr.next;
        }
        
        ListNode first = curr;
        ListNode newCurr = head;

        while(curr.next != null){
            curr = curr.next;
            newCurr = newCurr.next;
        }

        int secVal = newCurr.val;
        newCurr.val = first.val;
        first.val = secVal;


        return head;

        
    }
}