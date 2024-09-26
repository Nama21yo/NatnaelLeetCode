class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        min_unsorted = float('inf')
        max_unsorted = float('-inf')

        # First pass: Find the min and max unsorted elements
        for i in range(len(nums)):
            if self.isOutOfBound(nums, i):
                min_unsorted = min(min_unsorted, nums[i])
                max_unsorted = max(max_unsorted, nums[i])
        
        # If the array is fully sorted, return 0
        if min_unsorted == float('inf'):
            return 0

        # Second pass: Find the correct positions for min_unsorted and max_unsorted
        start = 0
        while start < len(nums) and nums[start] <= min_unsorted:
            start += 1
        end = len(nums) - 1
        while end >= 0 and nums[end] >= max_unsorted:
            end -= 1
        
        return end - start + 1 if start <= end else 0
        
    def isOutOfBound(self, nums, i):
        # Compare with adjacent elements to detect out-of-order elements
        if len(nums) == 1:
            return False
        if i == 0:
            return nums[i] > nums[i + 1]
        elif i == len(nums) - 1:
            return nums[i] < nums[i - 1]
        else:
            return nums[i] < nums[i - 1] or nums[i] > nums[i + 1]
