class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to make it easier to avoid duplicates and use the two-pointer technique
        Arrays.sort(nums);
        
        // Loop through each element, fixing one number and finding two others using two pointers
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicate triplets by skipping the same number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Use two-pointer approach to find two numbers that sum to -nums[i]
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < target) {
                    // If the sum is less than the target, move the left pointer to the right
                    left++;
                } else {
                    // If the sum is greater than the target, move the right pointer to the left
                    right--;
                }
            }
        }
        
        return result;
    }
}
