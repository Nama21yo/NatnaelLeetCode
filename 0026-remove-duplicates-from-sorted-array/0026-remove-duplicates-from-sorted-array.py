class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        n = len(nums)
        fast = 1
        for slow in range(1, n):
            if nums[slow] != nums[fast - 1]:
                nums[fast] = nums[slow]
                fast += 1
        return fast
