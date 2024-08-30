import java.util.*;

class Solution {
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modesList = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        // Perform in-order traversal and process nodes
        inOrder(root);

        // Convert the result list to an array
        int[] modes = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) {
            modes[i] = modesList.get(i);
        }

        return modes;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        // Traverse the left subtree
        inOrder(node.left);

        // Process the current node
        handleValue(node.val);

        // Traverse the right subtree
        inOrder(node.right);
    }

    private void handleValue(int val) {
        // If the current value is the same as the previous one, increment the count
        if (val == currentVal) {
            currentCount++;
        } else {
            // Otherwise, reset the current value and count
            currentVal = val;
            currentCount = 1;
        }

        // Update the mode list if necessary
        if (currentCount > maxCount) {
            // New max count found, reset the list
            maxCount = currentCount;
            modesList.clear();
            modesList.add(val);
        } else if (currentCount == maxCount) {
            // Current value has the same count as the max, add it to the list
            modesList.add(val);
        }
    }
}
