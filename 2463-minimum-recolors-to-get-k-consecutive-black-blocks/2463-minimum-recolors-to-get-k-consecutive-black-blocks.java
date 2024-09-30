class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int recolored = 0;
        int min_colored = Integer.MAX_VALUE; // Initialize to a large value

        int left = 0;
        for (int right = 0; right < n; right++) {
            // Count how many white blocks ('W') are in the current window
            if (blocks.charAt(right) == 'W') recolored++;

            // Once the window size reaches k
            if (right - left + 1 == k) {
                // Update the minimum recoloring needed
                min_colored = Math.min(min_colored, recolored);

                // Slide the window to the right by moving the left pointer
                if (blocks.charAt(left) == 'W') recolored--;  // Remove the effect of left
                left++;  // Move the window's left boundary to the right
            }
        }

        return min_colored;
    }
}
