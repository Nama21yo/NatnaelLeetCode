class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. Find the longest prefix match
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // 2. If a valid index is found, find the element just larger than nums[index] and swap them
        if (index != -1) {
            for (int j = n - 1; j > index; j--) {
                if (nums[j] > nums[index]) {
                    swap(nums, index, j);
                    break;
                }
            }
        }

        // 3. Reverse the remaining part of the array to get the next permutation
        reverse(nums, index + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
