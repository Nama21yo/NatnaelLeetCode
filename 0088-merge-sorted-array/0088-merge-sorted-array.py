class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # Step 1: Swap elements between nums1 and nums2 where necessary
        left = m - 1  # Last index of initialized elements in nums1
        right = 0     # First index of nums2

        # Swap larger elements from nums1 with smaller elements from nums2
        while left >= 0 and right < n:
            if nums1[left] > nums2[right]:
                # Swap the elements between nums1 and nums2
                nums1[left], nums2[right] = nums2[right], nums1[left]
            left -= 1
            right += 1

        # Step 2: Sort both arrays (nums1 and nums2)
        nums1[:m] = sorted(nums1[:m])  # Sort only the initialized part of nums1
        nums2.sort()                   # Sort all of nums2

        # Step 3: Merge nums2 into nums1 starting from the m-th position
        nums1[m:] = nums2              # Copy elements from nums2 to nums1

        # Step 4: Sort the entire nums1 array
        nums1.sort()  # Sort the final nums1 array
