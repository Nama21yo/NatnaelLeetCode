class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        double prefix = 1.0;
        double suffix = 1.0;
        
        for(int i = 0; i < nums.length; i++) {
            if(prefix == 0) prefix = 1.0;
            if(suffix == 0) suffix = 1.0;
            
            prefix *= nums[i];
            suffix *= nums[nums.length - i - 1];
            
            maxProduct = (int)Math.max(maxProduct, Math.max(prefix, suffix)); 
        }
        
        return maxProduct;
    }
}
