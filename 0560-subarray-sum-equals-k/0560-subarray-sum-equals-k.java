import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> arr_sums = new HashMap<>();
        arr_sums.put(0, 1);  // Initialize the map with sum 0 having one occurrence
        int sum = 0;  // This variable will keep the cumulative sum
        int result = 0;  // This will store the number of subarrays that sum to k
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];  // Update the cumulative sum
            
            // Check if there is a subarray (with sum k) ending at index i
            if (arr_sums.containsKey(sum - k)) {
                result += arr_sums.get(sum - k);
            }
            
            // Update the map with the current sum
            arr_sums.put(sum, arr_sums.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
