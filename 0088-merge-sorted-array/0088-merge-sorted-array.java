class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        // Merging nums1 and nums2 into nums
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                nums[index] = nums1[left];
                left++;
            } else {
                nums[index] = nums2[right];
                right++;
            }
            index++;
        }

        // Copy remaining elements of nums1 if any
        while (left < m) {
            nums[index++] = nums1[left++];
        }

        // Copy remaining elements of nums2 if any
        while (right < n) {
            nums[index++] = nums2[right++];
        }

        // Copy merged elements back to nums1
        for (int i = 0; i < (n + m); i++) {
            nums1[i] = nums[i];
        }
    }
}
