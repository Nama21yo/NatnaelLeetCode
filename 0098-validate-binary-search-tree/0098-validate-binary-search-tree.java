/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root; // Start with the root node
        TreeNode prev = null; // This will keep track of the previous node in inorder traversal

        while (curr != null) {
            if (curr.left == null) { // Case 1: No left child
                // Process the current node
                if (prev != null && prev.val >= curr.val) {
                    return false; // If the previous value is greater than or equal to the current value, it's not a valid BST
                }
                prev = curr; // Update the previous node to the current node
                curr = curr.right; // Move to the right child
            } else { // Case 2: Has a left child
                // Find the inorder predecessor (rightmost node in the left subtree)
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right; // Keep moving to the right until you find the rightmost node
                }

                if (pred.right == null) { // Make a threaded link (temporary link back to the current node)
                    pred.right = curr; // Link the predecessor's right to the current node
                    curr = curr.left; // Move to the left child
                } else { // Remove the threaded link (restoring the original tree structure)
                    pred.right = null; // Remove the temporary link
                    // Process the current node
                    if (prev != null && prev.val >= curr.val) {
                        return false; // If the previous value is greater than or equal to the current value, it's not a valid BST
                    }
                    prev = curr; // Update the previous node to the current node
                    curr = curr.right; // Move to the right child
                }
            }
        }

        return true; // If all nodes are processed without violation, the binary tree is a valid BST
    }

}