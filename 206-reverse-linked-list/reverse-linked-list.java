/**

Reverse of a linked list: Keep the curr node at head. intiailise prev as null. and keep moving ahead using a tmp at second.next.

Iterative approach is faster than recursive as T is O(n) in both but space is O(1) in iterative and O(n) in recsursive

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
    public ListNode reverseList(ListNode head) {

        ListNode second = head;
        ListNode prev = null;
        head = null;

        while(second != null){

            ListNode tmp = second.next; 
            second.next = prev;
            prev = second;
            second = tmp;

        }

        return prev;
        
    }
}