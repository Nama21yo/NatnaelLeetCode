# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head.next is None:
            return None
        slow = head
        fast = head.next.next # let fast start 2* to be before middle

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        # delete it
        slow.next = slow.next.next # assuming slow isn't the tail
        return head