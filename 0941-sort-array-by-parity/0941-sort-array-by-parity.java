class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;

        for(int r = 0; r < nums.length; ++r) {
            if(nums[r] % 2 == 0) {
                swap(nums, l , r);
                l++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}