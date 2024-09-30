class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero_flipped = 0;
        int current_max = 0;
        int max_so_far = 0;

        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zero_flipped++;
            
            while(zero_flipped > k) {
                if(nums[left] == 0) {
                    zero_flipped--;
                }
                left++;
            }

            max_so_far = Math.max(max_so_far, right - left + 1);
        }

        return max_so_far;
    }
}