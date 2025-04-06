# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        # postorder
        def diameter(root):
            if root is None:
                return 0, 0
            left_pair = diameter(root.left)
            right_pair = diameter(root.right)
            h_root = max(left_pair[0], right_pair[0]) + 1
            d_root = max(left_pair[0] + right_pair[0], left_pair[1], right_pair[1])
            return h_root, d_root
        return diameter(root)[1]