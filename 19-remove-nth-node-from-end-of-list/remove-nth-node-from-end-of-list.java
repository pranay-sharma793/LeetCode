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

        if(removePos == 0) return head.next;

        ListNode curr = head;
        ListNode prev = null;

        while(removePos > 0){
            prev = curr;
            curr = curr.next;
            removePos--;
        }

        if(curr.next == null) prev.next = null;
        else {
            prev.next = curr.next;
        }
        
        return head;

        
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