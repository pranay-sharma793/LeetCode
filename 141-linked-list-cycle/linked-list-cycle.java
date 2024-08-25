/**
Floyd's Cycle detection algorithm. Or slow and fast pointer or hare and tortoise algo. Here we take two pointer one incrementing twice and other once.
Remember: to loop until fast!=null and fast.next!=null.

Also, check slow == fast after incrementing.

 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) return true;
        }

        return false;
        
    }
}