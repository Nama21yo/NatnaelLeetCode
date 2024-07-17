/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Initialize the left and right pointers
        int left = 1;
        int right = n;
        
        // Perform binary search
        while (left < right) {
            // Calculate the midpoint to avoid overflow
            int mid = left + (right - left) / 2;
            
            // If mid is a bad version, narrow the search to the left half
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                // If mid is not a bad version, narrow the search to the right half
                left = mid + 1;
            }
        }
        
        // left is the first bad version when the loop exits
        return left;
    }
}
