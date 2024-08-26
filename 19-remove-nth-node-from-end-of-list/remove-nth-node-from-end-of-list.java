/**
Get the size of the linkedlist: Is it easy to keep to pointer until we hit null and do size++

once we have size, check if size = n. Meanining first element removal. return head.next.

else cal removePos = size - n, travel curr till one element before and update curr.next to curr.next.next
 */

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
        if(n == size) return head.next;

        int removePos = size - n;
        ListNode curr = head;

        while(removePos > 1){
            curr = curr.next;
            removePos--;
        }

        curr.next = curr.next.next;

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