class Solution {
    public int findDuplicate(int[] nums) {
        // Using Floyd's Tortoise and Hare
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow; // or it can be fast
    }
}
