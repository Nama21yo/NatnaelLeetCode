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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Base cases: if one of the lists is null, return the other list
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Recursive case: compare the values and merge accordingly
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);  // Merge the rest of l1 and l2
            return l1;  // l1 is the smaller node, so return it as the new head
        } else {
            l2.next = mergeTwoLists(l1, l2.next);  // Merge l1 and the rest of l2
            return l2;  // l2 is the smaller node, so return it as the new head
        }
    }
}
