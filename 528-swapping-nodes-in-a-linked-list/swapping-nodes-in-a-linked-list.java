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

        int size = 0;
        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            size++;
        }

        curr = head;
        int c = k;

        while(c > 1){
            curr = curr.next;
            c--;
        }

        ListNode newCurr = head;
        c = 0;

        while(c < size - k){
            newCurr = newCurr.next;
            c++;
        }

        int swap = curr.val;
        curr.val = newCurr.val;
        newCurr.val = swap;

        return head;
        
    }
}