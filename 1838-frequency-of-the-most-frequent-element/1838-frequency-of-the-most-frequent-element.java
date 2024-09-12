class Solution {
    public int maxFrequency(int[] nums, int k) {
        int maxf = 0;
        int l = 0;
        int r = 0;
        long countSum = 0; // Use long to avoid overflow
        Arrays.sort(nums);
        
        while (r < nums.length) {
            countSum += nums[r];
            r++;
            
            // Check if the window is valid
            while (countSum + k < (long) nums[r - 1] * (r - l)) {
                countSum -= nums[l];
                l++;
            }
            
            maxf = Math.max(maxf, r - l);
        }
        
        return maxf;
    }
}
