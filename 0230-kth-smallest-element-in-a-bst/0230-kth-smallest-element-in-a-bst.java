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
    private int k; // Variable to keep track of the count of nodes visited
    private int ans; // Variable to store the k-th smallest element
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k; // Initialize the k value
        helper(root); // Call the helper function to perform in-order traversal
        return ans; // Return the k-th smallest element
    }
    
    private void helper(TreeNode node) {
        if (node == null) return; // Base case: if the node is null, return
        
        // Recur for the left subtree
        helper(node.left);
        
        // Decrement k (as we have visited one more node)
        k--;
        // If k becomes 0, we have found the k-th smallest element
        if (k == 0) {
            ans = node.val; // Set the answer to the current node's value
            return; // Return to stop further traversal
        }
        
        // Recur for the right subtree
        helper(node.right);
    }
}
