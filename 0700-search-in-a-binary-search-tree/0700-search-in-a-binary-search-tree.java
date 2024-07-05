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
    public TreeNode searchBST(TreeNode root, int val) {
    // While the current node is not null and its value is not equal to the target value
    while(root != null && root.val != val) {
        // If the target value is less than the current node's value, move to the left child
        // Otherwise, move to the right child
        root = val < root.val ? root.left : root.right;
    }
    // Return the node where the value is found, or null if the value is not found in the tree
    return root;
}

}