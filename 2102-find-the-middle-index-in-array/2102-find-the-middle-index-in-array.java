class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for(int i = 0; i < n;i++){
            totalSum += nums[i];
        }

        int leftSum = 0;
        int rightSum = totalSum;

        for(int j = 0; j < n;j++) {
            rightSum = rightSum - nums[j];
            //check before manipulating leftSum
            if(leftSum == rightSum) return j;
            leftSum = leftSum + nums[j];
        }

        return -1;
    }
}