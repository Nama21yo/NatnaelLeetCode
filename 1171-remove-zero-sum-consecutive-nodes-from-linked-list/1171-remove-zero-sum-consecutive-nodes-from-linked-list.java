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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode currnode = dummy;
        dummy.next = head;
        int prefixsum = 0;
        
        Map<Integer, ListNode> prefixsumMap = new HashMap <>();
        while (currnode != null) {
            prefixsum += currnode.val;
            
            if (prefixsumMap.containsKey(prefixsum)) {
                currnode = prefixsumMap.get(prefixsum).next;
                int sum = prefixsum + currnode.val;
                while (sum != prefixsum) {
                    prefixsumMap.remove(sum);
                    currnode = currnode.next;
                    sum += currnode.val;
                }
                prefixsumMap.get(prefixsum).next = currnode .next;
                
            }
            else {
                prefixsumMap.put(prefixsum, currnode);
            }
            
            currnode = currnode.next;
        }
        
        return dummy.next;
        
    }
}