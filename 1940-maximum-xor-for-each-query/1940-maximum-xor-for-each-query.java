class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;

        for(int num: nums) {
            xor = xor ^ num;
        }

        int n = nums.length;
        int[] answer = new int[n];
        // int mask = (2 ** maximumBit) - 1;
        int mask = (1 << maximumBit) - 1;

        for(int i = n - 1; i >= 0; i--) {
            answer[n - i - 1] = xor ^ mask;
            xor = xor ^ nums[i];
        }

        return answer;
        
    }
}