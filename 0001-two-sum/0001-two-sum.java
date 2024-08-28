class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) { // Loop through each element in the array
            int diff = target - nums[i]; // Calculate the difference needed to reach the target
            
            if (map.containsKey(diff)) { // If the difference is already in the map
                return new int[]{map.get(diff), i}; // Return the indices of the two numbers
            }
            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        return null; // If no solution is found, return null (though this case should not occur as per the problem constraints)
    }
}
