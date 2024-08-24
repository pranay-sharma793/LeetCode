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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1, null);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            
            ListNode nextVal;

            if(list2.val < list1.val){
                nextVal = new ListNode(list2.val, null);
                list2 = list2.next;
            } else {
                nextVal = new ListNode(list1.val, null);
                list1 = list1.next;
            }

            curr.next = nextVal;
            curr = curr.next;

        }

        if(list1 == null && list2 !=null){
            curr.next = list2;
        } else if(list1 != null) {
            curr.next = list1;
        }

        return dummy.next;
        
    }
}