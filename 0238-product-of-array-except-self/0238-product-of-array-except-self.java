class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        // Initialize the result array with 1s
        Arrays.fill(result, 1);
        
        int prefix = 1, post = 1;
        
        // First pass: calculate the prefix product for each element
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i]; // Update the prefix product
        }
        
        // Second pass: calculate the postfix product and multiply it with the prefix product
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= post; // Multiply by the postfix product
            post *= nums[i]; // Update the postfix product
        }
        
        return result;
    }
}
