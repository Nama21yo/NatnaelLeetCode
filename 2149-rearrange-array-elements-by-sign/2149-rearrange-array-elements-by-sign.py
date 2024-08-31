class Solution {
    public int[] rearrangeArray(int[] nums) {
        //optimal
        int[] ans = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        
        for(int i = 0; i < nums.length;i++) {
            if(nums[i] < 0) {
                ans[negativeIndex] = nums[i];
                negativeIndex += 2;
            } else {
                ans[positiveIndex] = nums[i];
                positiveIndex += 2;
            }
        }
        
        return ans;
    }
}