class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Brute Force
        int[] positive = new int[nums.length/2];
        int[] negative = new int[nums.length/2];
        int j = 0;
        int k = 0;
        for(int i = 0; i < nums.length;i++) {
            if(nums[i] < 0) {
                negative[j] = nums[i];
                j++;
            } else {
                positive[k] = nums[i];
                k++;
            }
        }
        
        for(int i = 0;i<nums.length/2;i++) {
            nums[2*i] = positive[i];
            nums[(2*i)+1] = negative[i];
        }
        return nums;
    }
}