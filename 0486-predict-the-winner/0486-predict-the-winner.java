class Solution {
    // Main function to predict the winner
    public boolean predictTheWinner(int[] nums) {
        // Start the recursive function with the entire array range
        return recursive(nums, 0, nums.length - 1) >= 0;
    }
    
    // Recursive helper function to calculate the optimal score difference
    private int recursive(int[] nums, int start, int end) {
        // Base case: when the range is reduced to a single element
        if (start == end) {
            return nums[start];
        }
        
        // Calculate the score difference if the player picks the start element
        int left = nums[start] - recursive(nums, start + 1, end);
        // Calculate the score difference if the player picks the end element
        int right = nums[end] - recursive(nums, start, end - 1);
        
        // Return the maximum score difference the player can achieve
        return Math.max(left, right);
    }
}
