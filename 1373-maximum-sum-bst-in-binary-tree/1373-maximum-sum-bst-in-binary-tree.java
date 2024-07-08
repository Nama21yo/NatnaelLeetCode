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
    int maxSum = 0; // Variable to store the maximum sum of all BSTs found

    public int maxSumBST(TreeNode root) {
        // If the tree is empty, return 0 as the sum
        if (root == null) return 0;
        
        // Traverse the tree to find the maximum sum BST
        traverse(root);
        
        // Return the maximum sum found
        return maxSum;
    }

    // Helper class to store the results of subtree traversals
    class Result {
        int lower, upper, sum;

        public Result(int lower, int upper, int sum) {
            this.lower = lower; // The minimum value in the subtree
            this.upper = upper; // The maximum value in the subtree
            this.sum = sum; // The sum of values in the subtree
        }
    }

    // Traverse the tree and return the result for each subtree
    public Result traverse(TreeNode node) {
        // Base case: If the node is null, return a default result
        if (node == null) {
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Recursively traverse the left and right subtrees
        Result left = traverse(node.left);
        Result right = traverse(node.right);

        // If either left or right subtree is not a BST, return null
        if (left == null || right == null) {
            return null;
        }

        // If the current node violates the BST property, return null
        if (node.val <= left.upper || node.val >= right.lower) return null;

        // Calculate the sum of the current BST
        int currentSum = node.val + left.sum + right.sum;
        
        // Update the maximum sum if the current sum is greater
        maxSum = Math.max(maxSum, currentSum);

        // Calculate the new lower and upper bounds for the current subtree
        int lower = Math.min(node.val, left.lower);
        int upper = Math.max(node.val, right.upper);

        // Return the result for the current subtree
        return new Result(lower, upper, currentSum);
    }
}
