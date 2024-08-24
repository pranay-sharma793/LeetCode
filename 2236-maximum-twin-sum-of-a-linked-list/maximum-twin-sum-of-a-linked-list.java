/**
Trick: using the fast and slow pointer reach the mid of the LL. 
Then from the mid reverse the LL till the end.
Now loop from head until u reach mid and keep summing head val and prev val.
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
    public int pairSum(ListNode head) {
        
        ListNode curr = head;
        ListNode mid = head;

        while(curr != null){
            curr = curr.next.next;
            mid = mid.next;
        }

        ListNode holder = mid;
        ListNode prev = null;

        while(holder != null){
            ListNode tmp = holder.next;
            holder.next = prev;

            prev = holder;
            holder = tmp;
        }

        int maxSum = 0;

        while(head != mid){
            maxSum = Math.max(maxSum, head.val + prev.val);
            head = head.next;
            prev = prev.next;
        }

        return maxSum;

    }
}