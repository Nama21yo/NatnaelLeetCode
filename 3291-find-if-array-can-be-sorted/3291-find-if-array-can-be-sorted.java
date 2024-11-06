class Solution {
    public boolean canSortArray(int[] nums) {
        // TC- O(n)
        // SC- O(1)
        int currentMin = nums[0];
        int currentMax = nums[0];
        int previousMax = Integer.MIN_VALUE;

        for(int num : nums) {
            if(setBits(num) == setBits(currentMin)) {
                currentMin = Math.min(currentMin, num);
                currentMax = Math.max(currentMax, num);
            } else{
                if(currentMin < previousMax) return false;

                previousMax = currentMax;
                currentMin = currentMax = num;
            }
        }
        // for the last case
        if(currentMin < previousMax) return false;
        return true;
    }
    private int setBits(int number){
        int count  = 0;
        while(number > 0){
            count += number & 1;
            number >>= 1;
        }
        return count;
    }
}