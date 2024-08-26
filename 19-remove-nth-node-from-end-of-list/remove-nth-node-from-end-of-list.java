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

        if(head.next == null) return null;

        int size = getSize(head);
        int removePos = size - n;

        ListNode dummy = new ListNode(-1);

        ListNode curr = head;
        ListNode prev = dummy;

        while(removePos > 0){
            prev = curr;
            curr = curr.next;
            removePos--;
        }

        if(curr.next == null) prev.next = null;
        else {
            curr = curr.next;
            prev.next = curr;
        }

        if(prev.val == -1) prev = prev.next;
        else prev = head;

        return prev;

        
    }

    private int getSize(ListNode head){

        int size = 0;
        while(head != null){
            head = head.next;
            size++;
        }

        return size;
    }
}