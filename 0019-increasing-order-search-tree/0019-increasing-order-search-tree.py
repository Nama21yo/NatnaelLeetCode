# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def increasingBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        dummy = TreeNode()
        current = dummy
        def inorder(node):
            nonlocal current
            if not node:
                return
            
            inorder(node.left)
            current.right = TreeNode(node.val)
            current = current.right # move the pointer
            inorder(node.right)
        inorder(root)
        return dummy.right
