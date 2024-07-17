class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers, one at the beginning and one at the end of the array
        int left = 0;
        int right = height.length - 1;
        // Variable to store the maximum area found
        int maxArea = 0;
        
        // Continue until the two pointers meet
        while (left < right) {
            // Calculate the area with the current pair of lines
            int area = Math.min(height[left], height[right]) * (right - left);
            
            // Update maxArea if the current area is larger
            maxArea = Math.max(area, maxArea);
            
            // Move the pointer pointing to the shorter line inward to try to find a taller line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        // Return the maximum area found
        return maxArea;
    }
}
