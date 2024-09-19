class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0;
        int right = 0;
        int count  = 0;
        int sum = 0;
        int prefixZeros = 0;

        while(right < nums.length) {
            sum += nums[right];
            
            //consider the first condition nus[left] == 0
            while(left < right && (nums[left] == 0 || sum > goal)) {
                if(nums[left] == 1) prefixZeros = 0;
                else prefixZeros++;
                sum -= nums[left];
                left++;
            }
            if(sum == goal) count += 1 + prefixZeros;
            right++;
        }
    return count;
    }
}