class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // Initialize two pointers for each array
        int i = 0, j = 0;
        // Initialize result to maximum possible integer value
        int res = Integer.MAX_VALUE;
        
        // Traverse both arrays until one of them is exhausted
        while (i < nums1.length && j < nums2.length) {
            // If both elements are equal, update the result
            if (nums1[i] == nums2[j]) {
                res = Math.min(res, nums1[i]);
                i++;
                j++;
            }
            // If the current element in nums1 is smaller, move the pointer in nums1
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            // If the current element in nums2 is smaller, move the pointer in nums2
            else {
                j++;
            }
        }
        
        // If no common element was found, return -1, otherwise return the result
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
