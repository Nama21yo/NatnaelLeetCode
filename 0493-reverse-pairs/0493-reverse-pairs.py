class Solution:
    def __init__(self):
        self.count = 0

    def merge(self, nums, l, m, h):
        n1 = m - l + 1
        n2 = h - m
        left = nums[l:m+1]  # left subarray
        right = nums[m+1:h+1]  # right subarray

        i = 0
        j = 0
        k = l

        # Merge the two sorted subarrays
        while i < n1 and j < n2:
            if left[i] <= right[j]:
                nums[k] = left[i]
                i += 1
            else:
                nums[k] = right[j]
                j += 1
            k += 1

        # Copy remaining elements of left, if any
        while i < n1:
            nums[k] = left[i]
            i += 1
            k += 1

        # Copy remaining elements of right, if any
        while j < n2:
            nums[k] = right[j]
            j += 1
            k += 1

    def countPairs(self, nums, l, mid, h):
        right = mid + 1
        for i in range(l, mid + 1):
            while right <= h and nums[i] > 2 * nums[right]:
                right += 1
            self.count += (right - (mid + 1))

    def mergeSort(self, nums, l, h):
        if l < h:
            mid = (l + h) // 2

            # Sort first and second halves
            self.mergeSort(nums, l, mid)
            self.mergeSort(nums, mid + 1, h)

            # Count pairs
            self.countPairs(nums, l, mid, h)

            # Merge the sorted halves
            self.merge(nums, l, mid, h)

    def reversePairs(self, nums):
        self.count = 0  # Reset count before processing
        self.mergeSort(nums, 0, len(nums) - 1)
        return self.count
