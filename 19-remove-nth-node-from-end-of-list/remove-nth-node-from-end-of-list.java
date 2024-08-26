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

    // public ListNode removeNthFromEnd(ListNode head, int n) {
        
    //     if(head.next == null && n == 1) return null;

    //     ListNode newHead = reverse(head);

    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = newHead;

    //     ListNode curr = newHead;
    //     ListNode prev = dummy;

    //     while(n > 1){
    //         prev = curr;
    //         curr = curr.next;
    //         n--;
    //     }

    //     if (curr.next != null) {
    //         curr = curr.next;
    //         prev.next = curr;
    //     }

    //     if(prev.val == -1) prev = prev.next;

    //     return reverse(prev);
        
    // }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = getSize(head);
        int removePos = size - n;

        // if(removePos == 0) return null;

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
        ListNode fast = head;
        ListNode slow = head;
        int n = 0;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            n++;
        }

        return fast == null ? 2*n : 2*n + 1;
    }



    private ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        // head.next = null;

        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}