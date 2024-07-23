class NumArray {
    private final HashMap<Integer, Integer> prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new HashMap<>();
        
        int sum = 0;
        prefixSum.put(-1, 0);  // This ensures prefixSum.get(left - 1) works even when left is 0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum.put(i, sum);
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum.get(right) - prefixSum.get(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left, right);
 */
