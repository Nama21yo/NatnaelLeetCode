class Solution {
    public int[] runningSum(int[] nums) {
        // Initialize the result array with the same size as nums
        int[] runningSum = new int[nums.length];
        
        // The running sum starts with the first element
        runningSum[0] = nums[0];
        
        // Compute the running sum
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        
        // Return the running sum array
        return runningSum;
    }
}
