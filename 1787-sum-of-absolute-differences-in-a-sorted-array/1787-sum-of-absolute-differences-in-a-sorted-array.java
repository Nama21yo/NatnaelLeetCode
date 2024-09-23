class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the total sum of the array elements
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Traverse the array to calculate prefix sum and suffix sum dynamically
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            int suffixSum = totalSum - prefixSum - nums[i];
            
            // For elements before nums[i]
            int leftPart = nums[i] * i - prefixSum;
            // For elements after nums[i]
            int rightPart = suffixSum - nums[i] * (n - i - 1);
            
            result[i] = leftPart + rightPart;
            
            // Update the prefix sum to include the current nums[i]
            prefixSum += nums[i];
        }
        
        return result;
    }
}
