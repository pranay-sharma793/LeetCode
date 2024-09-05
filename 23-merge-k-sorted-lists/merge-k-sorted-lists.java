/**
Trick is to use two list merge function, and then store the merged lists again the same lists variable and keep on doing this until we have only 1 list left on the lists variable. That one list left will be our merged list of all

time: O(n * log k)
Space: O(1) 
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while(lists.length > 1){
            List<ListNode> mergeLists = new ArrayList<>();
            for(int i=0; i < lists.length; i +=2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i+1] : null;
                mergeLists.add(mergeTwoSorted(l1, l2));
            }
            lists = mergeLists.toArray(new ListNode[0]);

        }
        
        return lists[0];
    }


    public ListNode mergeTwoSorted(ListNode head1, ListNode head2){

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(head1 != null && head2 != null){

            if(head1.val < head2.val){
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if(head1 != null){
            curr.next = head1;
        } else {
            curr.next = head2;
        }

        return dummy.next;
    }
}