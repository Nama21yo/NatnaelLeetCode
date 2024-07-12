# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        # Initialize an empty list to store the paths
        arr = []
        # Initialize an empty list to keep track of the current path
        s = []
        
        def backtrack(root, arr, s):
            # If the current node is not None
            if root:
                # Append the value of the current node to the path
                s.append(str(root.val))
                # If it's a leaf node (no left or right children)
                if not root.right and not root.left:
                    # Join the current path and add it to the list of paths
                    arr.append("->".join(s))
                # Recursively call backtrack on the left child
                backtrack(root.left, arr, s)
                # Recursively call backtrack on the right child
                backtrack(root.right, arr, s)
                # Remove the current node's value from the path (backtrack)
                s.pop()
        
        # Start the backtracking with the root node
        backtrack(root, arr, s)
        # Return the list of paths
        return arr
