class Solution {
    public int maxSubArray(int[] nums) {
        // Using Kadane's Algorithm
        
        // Initialize max_so_far to the first element of the array.
        // This variable will hold the maximum sum encountered so far.
        int max_so_far = nums[0];
        
        // Initialize max_ending_here to 0.
        // This variable will track the sum of the current subarray.
        int max_ending_here = 0;
        
        // Iterate through the array.
        for(int i = 0; i < nums.length; i++) {
            // Add the current element to max_ending_here.
            max_ending_here += nums[i];
            
            // If max_ending_here (current subarray sum) is greater than max_so_far,
            // update max_so_far to be max_ending_here.
            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            
            // If max_ending_here becomes negative, reset it to 0.
            // This is because a negative sum will reduce the sum of any future subarray.
            if(max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        
        // Return the maximum sum found.
        return max_so_far;
    }
}
