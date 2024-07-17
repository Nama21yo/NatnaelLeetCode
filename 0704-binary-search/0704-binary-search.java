class Solution {
    public int search(int[] nums, int target) {
        // Initialize the left and right pointers
        int left = 0;
        int right = nums.length - 1;
        
        // Continue searching while the range is valid
        while (left <= right) {
            // Calculate the mid index to avoid overflow
            int mid = left + (right - left) / 2;
            
            // Check if the mid element is the target
            if (nums[mid] == target) {
                return mid;
            } 
            // If target is greater, ignore the left half
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        // If the target is not found, return -1
        return -1;
    }
}
