# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        paths = []
        def dfs(root, path, target, curr):
            if root is None:
                return
            # this is thing is a leaf Node
            curr += root.val
            path.append(root.val)
            if root.left is None and root.right is None:
                if curr == target:
                    paths.append(path[:])
            else:
                dfs(root.left, path, target, curr)
                dfs(root.right, path, target, curr)
            # backtrack
            curr -= root.val
            path.pop()
        dfs(root, [], targetSum, 0)
        return paths
            