class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # Initialize the right pointer at the end of nums1
        right = m + n - 1
        
        # Merge nums1 and nums2 starting from the end
        while m > 0 and n > 0:
            if nums1[m - 1] > nums2[n - 1]:
                nums1[right] = nums1[m - 1]
                m -= 1
            else:
                nums1[right] = nums2[n - 1]
                n -= 1
            right -= 1
        
        # If there are remaining elements in nums2, copy them over
        while n > 0:
            nums1[right] = nums2[n - 1]
            n -= 1
            right -= 1
