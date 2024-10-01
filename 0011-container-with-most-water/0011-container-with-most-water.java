class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;  // Initialize 'right' at the end of the array

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the current area
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;  // Move left pointer right
            } else {
                right--;  // Move right pointer left
            }
        }

        return maxArea;
    }
}
