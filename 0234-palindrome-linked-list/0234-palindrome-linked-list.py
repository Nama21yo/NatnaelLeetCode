# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return True

        # Step 1: Find the middle of the linked list
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the second half of the linked list
        prev = None
        while slow:
            next_node = slow.next
            slow.next = prev
            prev = slow
            slow = next_node

        # Step 3: Compare the first half and the reversed second half
        left, right = head, prev
        while right:  # Only need to compare till end of right half
            if left.val != right.val:
                return False
            left = left.next
            right = right.next

        # If needed, step 4 would be restoring the list to its original state
        # (not implemented here as it's typically not required for this problem)

        return True
