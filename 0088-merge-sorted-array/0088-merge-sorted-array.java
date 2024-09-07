class Solution {
     public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = n + m; // Total length of both arrays
        int gap = (len / 2) + (len % 2); // Initial gap

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // Case 1: nums1 and nums2 (left is in nums1, right is in nums2)
                if (left < m && right >= m) {
                    if (nums1[left] > nums2[right - m]) {
                        // Swap between nums1 and nums2
                        int temp = nums1[left];
                        nums1[left] = nums2[right - m];
                        nums2[right - m] = temp;
                    }
                }
                // Case 2: nums2 and nums2 (both left and right are in nums2)
                else if (left >= m) {
                    if (nums2[left - m] > nums2[right - m]) {
                        // Swap within nums2
                        int temp = nums2[left - m];
                        nums2[left - m] = nums2[right - m];
                        nums2[right - m] = temp;
                    }
                }
                // Case 3: nums1 and nums1 (both left and right are in nums1)
                else {
                    if (nums1[left] > nums1[right]) {
                        // Swap within nums1
                        int temp = nums1[left];
                        nums1[left] = nums1[right];
                        nums1[right] = temp;
                    }
                }

                left++;
                right++;
            }

            // Reduce the gap for the next iteration
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }

        // Now merge nums2 into nums1 after sorting
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}