class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Edge case: If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on their end times
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // Initialize variables
        int count = 0; // Count of removed intervals
        int previousEnd = intervals[0][1]; // Track the end time of the last interval we kept

        // Iterate over the intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts before the previous interval ends, it's overlapping
            if (intervals[i][0] < previousEnd) {
                count++; // We need to remove one interval
            } else {
                // Otherwise, update the previous end to the current interval's end
                previousEnd = intervals[i][1];
            }
        }

        return count; // Return the number of removed intervals
    }
}
