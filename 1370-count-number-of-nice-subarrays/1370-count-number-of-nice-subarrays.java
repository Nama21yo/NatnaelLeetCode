class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int countOdd = 0;
        int countArray  = 0;

        while(right < nums.length) {
            countOdd += nums[right] % 2;
            while(countOdd > k) {
                // if(nums[left] % 2 != 0)countOdd--;
                countOdd -= nums[left] % 2;
                left++;
            }
            countArray += right - left + 1;
            right++;
        }
        return countArray;
    }
}