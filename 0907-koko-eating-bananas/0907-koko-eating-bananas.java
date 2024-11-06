class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initialize the lower bound of eating speed to 1 (the minimum possible speed)
        int low = 1;
        // Initialize the upper bound of eating speed to the maximum number of bananas in any pile
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        // Use binary search to find the minimum valid eating speed
        while (low < high) {
            // Calculate the mid value to divide the search space
            int mid = low + (high - low) / 2;
            
            // If it's possible to eat all bananas within 'h' hours with 'mid' speed, search the left half
            if (isPossible(piles, h, mid)) {
                high = mid;
            } else {
                // Otherwise, search the right half
                low = mid + 1;
            }
        }
        // The lowest valid eating speed found
        return low;
    }
    
    // Helper function to determine if it's possible to eat all bananas in 'h' hours with speed 'k'
    private boolean isPossible(int[] piles, int h, int speed) {
        int totalHours = 0;
        for (int pile : piles) {
            // Calculate the number of hours needed to eat each pile with speed 'k'
            totalHours += (int) Math.ceil((double)pile / speed);
        }
        
        // Check if the total hours required is less than or equal to the given hours 'h'
        return totalHours <= h;
    }
}
