class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // Pointer for the position to place the next non-zero element
        
        // Move non-zero elements to the beginning of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        
        // Fill the remaining positions with zeros
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
