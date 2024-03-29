class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal-1);
    }
    
    private int helper(int[] A, int S) {
        if (S<0) return 0;
        
        int i = 0, res = 0;
        for (int j = 0; j < A.length; j++) {
            S -= A[j];
            
            while (S < 0) {
                S += A[i++];
            }
            
            res += j - i + 1;
        }
        
        return res;
    }
}