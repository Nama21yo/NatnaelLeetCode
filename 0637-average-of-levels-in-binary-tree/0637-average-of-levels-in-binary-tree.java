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
    public List<Double> averageOfLevels(TreeNode root) {
        // List to store the average values of each level
        List<Double> res = new ArrayList<>();
        
        // Queue to facilitate level-order traversal (BFS)
        Queue<TreeNode> q = new LinkedList<>();
        
        // If the root is null, return an empty list
        if (root == null) return res;
        
        // Start BFS by adding the root to the queue
        q.offer(root);
        
        // Process the tree level by level
        while (!q.isEmpty()) {
            // Number of nodes at the current level
            int n = q.size();
            
            // Variable to store the sum of node values at the current level
            double level_sum = 0;
            
            // Iterate through all nodes at the current level
            for (int i = 0; i < n; i++) {
                // Dequeue the front node
                TreeNode r = q.poll();
                
                // If the dequeued node has a left child, add it to the queue
                if (r.left != null) {
                    q.add(r.left);
                }
                
                // If the dequeued node has a right child, add it to the queue
                if (r.right != null) {
                    q.add(r.right);
                }
                
                // Add the value of the dequeued node to the level sum
                level_sum += r.val;
            }
            
            // Calculate the average for the current level and add it to the result list
            res.add(level_sum / n);
        }
        
        // Return the list of averages for each level
        return res;   
    }
}