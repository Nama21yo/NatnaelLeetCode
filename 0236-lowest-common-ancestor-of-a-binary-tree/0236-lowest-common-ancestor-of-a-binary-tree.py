# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getPath(self, root, val, path):
        if root is None:
            return []
        path.append(root.val)
        if root.val == val or self.getPath(root.left, val , path) or self.getPath(root.right, val, path):
            return path
        path.pop()
        return []
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path_p = self.getPath(root, p.val,[])
        path_q = self.getPath(root, q.val, [])
        n = min(len(path_p), len(path_q))
        i = 0
        ans = 0
        while i < n:
            if path_p[i] != path_q[i]:
                break
            i += 1
        ans = path_p[i - 1]
        return TreeNode(ans)