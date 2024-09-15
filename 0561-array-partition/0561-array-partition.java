class Solution {
    public int arrayPairSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        // Initialize the sum
        int sum = 0;
        
        // Sum up every second element starting from the first element
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        
        return sum;
    }
}
