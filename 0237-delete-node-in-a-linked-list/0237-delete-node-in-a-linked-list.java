/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) { this.val = val; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return; // There is nothing to delete if node is null or it's the last node
        }
        
        // Copy the data from the next node to the current node
        node.val = node.next.val;
        
        // Bypass the next node
        node.next = node.next.next;
    }
}
