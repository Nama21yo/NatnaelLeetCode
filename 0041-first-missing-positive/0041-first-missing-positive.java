class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct position if possible.
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1] to place nums[i] in its correct position
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where the number is not in the correct position.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;  // The missing positive integer
            }
        }

        // If all numbers are in the correct place, the missing number is n + 1.
        return n + 1;
    }
}
