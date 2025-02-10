class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        nums.sort()
        # select the median        # 
        n = len(nums)
        median = nums[n // 2]
        # get the difference
        return sum(abs(num - median) for num in nums)