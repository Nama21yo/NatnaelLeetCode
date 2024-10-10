class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        nums.sort()
        n = len(nums)
        l = 0
        r = n - 1
        min_average = float('inf')
        while l <= r:
            average = (nums[l] + nums[r]) / 2
            min_average = min(min_average, average)
            l += 1
            r -= 1

        return min_average
            
        