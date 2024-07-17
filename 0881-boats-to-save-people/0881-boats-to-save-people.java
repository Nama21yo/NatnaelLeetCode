class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Sort the array of people by their weights
        Arrays.sort(people);
        
        // Initialize the count of boats needed
        int boats = 0;
        
        // Use two pointers: one starting from the lightest person (left) and one from the heaviest (right)
        int left = 0, right = people.length - 1;
        
        // Continue until all people are assigned to boats
        while (left <= right) {
            // If the lightest and heaviest person can share a boat, move both pointers inward
            if (people[left] + people[right] <= limit) {
                left++;
            }
            
            // Always move the right pointer inward (the heaviest person is assigned a boat)
            right--;
            
            // Increment the boat count
            boats++;
        }
        
        // Return the total number of boats needed
        return boats;
    }
}
