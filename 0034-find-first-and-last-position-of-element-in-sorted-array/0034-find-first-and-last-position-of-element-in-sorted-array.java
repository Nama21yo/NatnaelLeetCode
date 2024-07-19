class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Find the leftmost (first) index of the target
        int left = binarySearch(nums, target, true);
        // Find the rightmost (last) index of the target
        int right = binarySearch(nums, target, false);
        
        // Return the range as an array
        return new int[] {left, right};
    }
    
    // Binary search function with a bias parameter
    private int binarySearch(int[] arr, int target, boolean leftBias) {
        int left = 0, right = arr.length - 1, i = -1;
        
        while (left <= right) {
            // Calculate the midpoint to avoid overflow
            int mid = left + (right - left) / 2;
            
            // If target is greater than the mid element, search the right half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is less than the mid element, search the left half
            else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                // If target is found, update the index and adjust the search range based on bias
                i = mid;
                if (leftBias) {
                    // Continue searching in the left half to find the leftmost index
                    right = mid - 1;
                } else {
                    // Continue searching in the right half to find the rightmost index
                    left = mid + 1;
                }
            }
        }
        
        // Return the index of the target found (or -1 if not found)
        return i;
    }
}
