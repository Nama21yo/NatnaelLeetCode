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
    public boolean isSameTree(TreeNode p, TreeNode q) {
    // If either of the nodes is null, return true if both are null, false otherwise
    if(p == null || q == null) {
        return (p == q); // Both null means they are the same, otherwise they are not
    }
    
    // Check if the current nodes' values are the same and recursively check their left and right subtrees
    return (p.val == q.val) // Current nodes' values must be equal
        && isSameTree(p.left, q.left) // Left subtrees must be the same
        && isSameTree(p.right, q.right); // Right subtrees must be the same
}

}