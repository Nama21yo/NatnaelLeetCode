class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> distinct = new HashMap<>();
        int n = nums.length;
        int left = 0;
        long total = 0, maxTotal = 0;

        // Iterate through the array with a sliding window of size k
        for (int right = 0; right < n; right++) {
            total += nums[right];  // Add current number to the total
            distinct.put(nums[right], distinct.getOrDefault(nums[right], 0) + 1);

            // When the window reaches size k
            if (right - left + 1 == k) {
                // Check if the subarray is distinct
                if (distinct.size() == k) {
                    maxTotal = Math.max(maxTotal, total);  // Update maxTotal if necessary
                }

                // Slide the window by removing the leftmost element
                total -= nums[left];
                distinct.put(nums[left], distinct.get(nums[left]) - 1);
                if (distinct.get(nums[left]) == 0) {
                    distinct.remove(nums[left]);  // Remove element from the map if its count is 0
                }
                left++;
            }
        }

        return maxTotal;
    }
}
