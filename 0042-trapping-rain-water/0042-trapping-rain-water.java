class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0; // Edge case: empty array

        int[] max_left = new int[n];
        int[] max_right = new int[n];

        // Fill the max_left array
        max_left[0] = height[0];
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(height[i], max_left[i - 1]);
        }

        // Fill the max_right array
        max_right[n - 1] = height[n - 1];
        for (int r = n - 2; r >= 0; r--) {
            max_right[r] = Math.max(height[r], max_right[r + 1]);
        }

        // Calculate trapped water
        int trapped_water = 0;
        for (int i = 0; i < n; i++) {
            int water_level = Math.min(max_left[i], max_right[i]);
            trapped_water += (water_level - height[i]);
        }

        return trapped_water;
    }
}
