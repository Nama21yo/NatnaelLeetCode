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
    def klevel(self, root, k, level):
        if root is None:
            return 
        if k == 0:
            level.append(root.val)
        self.klevel(root.left, k - 1, level)
        self.klevel(root.right, k - 1, level)
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        def levelorder(root, res):
            height = self.height(root)
            for k in range(height - 1, - 1, - 1):
                level = []
                self.klevel(root, k, level)
                res.append(level)
        levelorder(root, res)
        return res
