class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        i = 0
        j = 0
        n = len(nums)
        prev = -101
        while i < n:
            if nums[i] == prev:
                i += 1
            else:
                nums[j] = nums[i]
                prev = nums[i]
                i += 1
                j += 1
        return j
