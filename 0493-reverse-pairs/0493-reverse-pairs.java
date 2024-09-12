class Solution {
    int count = 0;

    // Merge function to merge two sorted halves
    private void merge(int[] nums, int l, int m, int h) {
        int n1 = m - l + 1;
        int n2 = h - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            left[i] = nums[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = nums[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;  // Correct initialization of k

        // Merge the temp arrays back into nums[l..h]
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[], if any
        while (i < n1) {
            nums[k++] = left[i++];
        }

        // Copy remaining elements of right[], if any
        while (j < n2) {
            nums[k++] = right[j++];
        }
    }

    // Count pairs where nums[i] > 2 * nums[j]
    private void countPairs(int[] nums, int l, int mid, int h) {
        int right = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (right <= h && (long) nums[i] > 2 * (long) nums[right]) {
                right++;
            }
            count += (right - (mid + 1));  // Correct the count update
        }
    }

    // Merge sort function
    private void mergeSort(int[] nums, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;

            // Sort first and second halves
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, h);

            // Count pairs
            countPairs(nums, l, mid, h);

            // Merge the sorted halves
            merge(nums, l, mid, h);
        }
    }

    // Main function to return the count of reverse pairs
    public int reversePairs(int[] nums) {
        count = 0;  // Reset count before processing
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }
}
