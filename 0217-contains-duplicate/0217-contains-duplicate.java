class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {  // If the number is already in the set
                return true;  // Duplicate found
            }
            visited.add(nums[i]);  // Add the number to the set
        }
        
        return false;  // No duplicates found
    }
}
