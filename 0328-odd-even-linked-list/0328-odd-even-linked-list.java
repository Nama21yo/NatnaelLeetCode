class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Edge case: if the list is empty or has only one node
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Keep the head of the even list

        while (even != null && even.next != null) {
            odd.next = even.next; // Link odd nodes together
            odd = odd.next;       // Move odd pointer to next odd node
            even.next = odd.next; // Link even nodes together
            even = even.next;     // Move even pointer to next even node
        }

        odd.next = evenHead; // Connect the end of the odd list to the head of the even list
        return head;
    }
}
