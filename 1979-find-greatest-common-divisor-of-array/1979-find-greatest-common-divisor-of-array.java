class Solution {
    public int findGCD(int[] nums) {
        int maxNum = nums[0];
        int minNum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > maxNum) {
                maxNum = nums[i];
            }
            if(nums[i] < minNum) {
                minNum = nums[i];
            }
        }
        
        return gcd(minNum, maxNum);
    }
    
    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
