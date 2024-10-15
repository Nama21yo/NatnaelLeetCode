class Solution {
   public int firstMissingPositive(int[] nums) {
        // O(3n) and O(1) 
        if(nums.length==0) return 1;
        int lastPositiveindex = partition(nums);
        
        for(int i=0;i<lastPositiveindex;i++){
            int k = Math.abs(nums[i]);
            if(1 <= k && k <= lastPositiveindex) {
                if(nums[k - 1] > 0) {
                    nums[k - 1] = -nums[k - 1];
                }
            }
            // if(k <= lastPositiveindex)
            //     nums[k-1]=(nums[k-1]<0)?nums[k-1]:-nums[k-1];
        }
        for(int i= 1;i < lastPositiveindex + 1;i++){
            if(nums[i - 1] >= 0){
                return i;
            }
        }
        return lastPositiveindex + 1;
    }

    private int partition(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                swap(nums, i , j);
                j++;
            }
        }
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}