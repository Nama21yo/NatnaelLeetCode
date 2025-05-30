class Solution {
    public int singleNumber(int[] nums) {
        int odd_num = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            odd_num = odd_num ^ nums[i];
        }

        return odd_num;
    }
}