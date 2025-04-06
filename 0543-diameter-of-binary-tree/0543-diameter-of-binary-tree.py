# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def height(self, root):
        if root is None:
            return 0
        h_left = self.height(root.left)
        h_right = self.height(root.right)
        return max(h_left, h_right) + 1
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def diameter(root):
            if root is None:
                return 0
            h_left = self.height(root.left)
            h_right = self.height(root.right)
            # if includes my root, left and right
            d_all = h_left + h_right
            d_left = diameter(root.left)
            d_right = diameter(root.right)
            return max(d_all, d_left, d_right)
        return diameter(root)
        