# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def count_large(curr, max_so_far):
            count = 0
            if not curr:
                return 0
            # count for the root and
            # recursion will count the rest for you
            if curr.val >= max_so_far:
                count += 1
                max_so_far = curr.val
            # count the left and right part part
            count_left = count_large(curr.left, max_so_far)
            count_right = count_large(curr.right, max_so_far)

            return count_left + count_right + count
        return count_large(root, float("-inf"))
            
