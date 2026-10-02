class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        n = len(nums)
        k = 2
        fast = k
        for slow in range(k, n):
            if nums[slow] != nums[fast - k]:
                nums[fast] = nums[slow]
                fast += 1
        return fast