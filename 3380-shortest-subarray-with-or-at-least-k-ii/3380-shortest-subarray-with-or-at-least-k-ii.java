class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        // TC- O(n)
        // SC- O(32)
        int l = 0;
        int n = nums.length;
        int minlength = Integer.MAX_VALUE;

        int[] bits = new int[32];
        
        for(int r = 0; r < n; r++){
            bits_update(bits, nums[r], 1);
            int cur_or = bits_to_integer(bits);
            while(l <= r && cur_or >= k) {
                minlength = Math.min(minlength, r - l + 1);
                bits_update(bits, nums[l], -1);
                cur_or = bits_to_integer(bits);
                l++;
            }
        }
        return minlength == Integer.MAX_VALUE ? -1 : minlength;
    }

    private void bits_update(int[] bits ,int num, int diff) {
        for(int i = 0; i < 32; i++) {
            if((num & (1 << i)) != 0) { // if  it is non - zero 
                bits[i] += diff;
            }
        }
    }
    private int bits_to_integer(int[] bits) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            if(bits[i] != 0) {
                res += (1 << i);
            }
        }
        return res;
    }
    
}