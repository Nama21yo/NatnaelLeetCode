class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                totalWater += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                totalWater += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return totalWater;
    }
}