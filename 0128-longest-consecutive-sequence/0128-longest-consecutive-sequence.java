class Solution {
    public int longestConsecutive(int[] nums) {
        // If the array is empty, return 0 as there's no sequence
        if (nums.length == 0) return 0;

        // Use a HashSet to store all unique elements from the array
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSub = 1;  // Initialize the length of the longest sequence to 1
        
        // Iterate through the set
        for (int num : numSet) {
            // Check if the current number is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSub = 1;  // Start counting the current sequence

                // Continue to find the next consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSub++;
                }
                
                // Update the longest sequence found so far
                longestSub = Math.max(longestSub, currentSub);
            } 
        }
        
        return longestSub;
    }
}
