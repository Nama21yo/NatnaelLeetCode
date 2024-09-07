
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Step 1: Swap elements between nums1 and nums2 where necessary
        int left = m - 1;  // Last index of initialized elements in nums1
        int right = 0;     // First index of nums2
        
        // Swap larger elements from nums1 with smaller elements from nums2
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                // Swap the elements between nums1 and nums2
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
            }
            left--;
            right++;
        }

        // Step 2: Sort both arrays (nums1 and nums2)
        Arrays.sort(nums1, 0, m); // Sort only the initialized part of nums1
        Arrays.sort(nums2);       // Sort all of nums2
        
        // Step 3: Merge nums2 into nums1 starting from the m-th position
        int i = m;  // Start from the m-th index in nums1
        for (int j = 0; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        
        // Step 4: Sort the entire nums1 array
        Arrays.sort(nums1);  // Sort the final nums1 array
    }
}
