class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        
        // Iterate over trips to mark the pick-up and drop-off points
        for(int[] t : trips) {
            timestamp[t[1]] += t[0]; // Increment the capacity at pick-up point
            timestamp[t[2]] -= t[0]; // Decrement the capacity at drop-off point
        }
        
        // Iterate over the timestamp array to check capacity at each point
        for(int number : timestamp) {
            capacity -= number; // Adjust the capacity based on pick-ups and drop-offs
            
            // If capacity falls below zero, return false
            if(capacity < 0) {
                return false;
            }
        }
        
        return true;
    }
}
