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
        public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize a queue to help with BFS and a list to store the result
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        // If the root is null, return an empty list
        if (root == null) {
            return wrapList;
        }

        // Start the BFS by adding the root to the queue
        queue.offer(root);

        // Continue until there are no more nodes to process
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // Number of nodes at the current level

            // List to hold the values of nodes at the current level
            List<Integer> subList = new LinkedList<Integer>();

            // Process all nodes at the current level
            for (int i = 0; i < levelNum; i++) {
                // Add left child to the queue if it exists
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                // Add right child to the queue if it exists
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
            // Add the current node's value to the sublist and remove it from the queue
                subList.add(queue.poll().val);
            }
            // Add the current level's values to the wrap list
            wrapList.add(subList);
        }
        return wrapList; // Return the list of levels
    }
}