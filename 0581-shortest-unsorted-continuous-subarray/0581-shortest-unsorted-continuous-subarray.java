class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min_unsorted = Integer.MAX_VALUE;
        int max_unsorted = Integer.MIN_VALUE;

        // First pass: Find the minimum and maximum elements that are out of order
        for (int i = 0; i < n; i++) {
            if (isOutOfBound(nums, i)) {
                min_unsorted = Math.min(min_unsorted, nums[i]);
                max_unsorted = Math.max(max_unsorted, nums[i]);
            }
        }

        // If the array is already sorted, return 0
        if (min_unsorted == Integer.MAX_VALUE) {
            return 0;
        }

        // Second pass: Find the correct position to place the min_unsorted and max_unsorted
        int start = 0;
        while (start < n && nums[start] <= min_unsorted) {
            start++;
        }

        int end = n - 1;
        while (end >= 0 && nums[end] >= max_unsorted) {
            end--;
        }

        return end - start + 1;
    }

    private boolean isOutOfBound(int[] nums, int i) {
        // Compare it to previous and next elements
        if(nums.length == 1) return false;
        if (i == 0) {
            return nums[i] > nums[i + 1];
        } else if (i == nums.length - 1) {
            return nums[i] < nums[i - 1];
        } else {
            return nums[i] < nums[i - 1] || nums[i] > nums[i + 1];
        }
    }
}
