class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] b = Arrays.copyOf(nums, nums.length);
        Arrays.sort(b);

        int i = 0;
        while (i < nums.length && nums[i] == b[i]) {
            i++;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] == b[j]) {
            j--;
        }

        // If i becomes equal to nums.length, it means the array is already sorted
        if (i > j) {
            return 0;
        }

        return (j - i + 1);
    }
}
