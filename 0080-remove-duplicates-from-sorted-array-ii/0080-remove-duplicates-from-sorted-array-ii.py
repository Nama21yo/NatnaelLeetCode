class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        n = len(nums)
        fast = 0
        k = 2
        for slow in range(n):
            if fast < k or nums[slow] != nums[fast - k]:
                nums[fast] = nums[slow]
                fast += 1
        return fast