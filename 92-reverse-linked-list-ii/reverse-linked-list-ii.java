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