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