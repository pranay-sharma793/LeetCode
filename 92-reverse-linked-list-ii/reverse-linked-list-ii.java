/**

Loop over left to get to the position for curr to start reversing from the Next connections. hence left > 1.
Store the connection node ( the node right before the reversal begin ) and the tail node ( the starting node from where the reversal is starting).

While right > 0. Only reverse till right and perform simple reversal.

Then if connection is not null (meaning reverse is after head) set connectio.next to prev (prev will be at the end of the reversal pointing the very last reversed). ELSE update head to prev as a normal LL reversal.

And then for the remaining LL connect tail.next to curr which will be at the node right after the reversal stopped as a part of our increment.

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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode curr = head;
        ListNode prev = null;

        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        ListNode connection = prev; 
        ListNode tail = curr;

        while(right > 0){

            ListNode tmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tmp;

            right--;
        }

        if(connection == null){
            head = prev;
        } else {
            connection.next = prev;
        }

        tail.next = curr;
        

        return head;
    }
}