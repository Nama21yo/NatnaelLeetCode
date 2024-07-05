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
        // Start the recursive validation with the entire range of possible values for a BST
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        // An empty tree is a valid BST
        if (root == null) return true;

        // The current node's value must be within the range defined by minVal and maxVal
        if (root.val >= maxVal || root.val <= minVal) return false;

        // Recursively check the left subtree with an updated maxVal and
        // the right subtree with an updated minVal
        return isValidBST(root.left, minVal, root.val) &&
               isValidBST(root.right, root.val, maxVal);
    }

}