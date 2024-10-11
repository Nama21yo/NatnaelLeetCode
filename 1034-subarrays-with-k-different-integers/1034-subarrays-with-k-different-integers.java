class Solution {
    // Function to count the number of subarrays with at most K distinct elements
    private int atMostKDistinct(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0; // left pointer for the sliding window
        
        for (int r = 0; r < nums.length; ++r) { // right pointer for the sliding window
            // Add the element nums[r] to the map
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            
            // If the number of distinct elements exceeds k, shrink the window from the left
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++; // Move the left pointer
            }
            
            // Count the number of valid subarrays ending at r
            count += r - l + 1;
        }
        
        return count;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        // The result is the difference between subarrays with at most K distinct
        // and subarrays with at most K-1 distinct elements
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
}
