class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left = 0 
        right = 0
        window_sum = 0
        n = len(nums)

        min_window = float("inf")
        for right in range(n):
            window_sum += nums[right]

            while window_sum >= target:
                min_window = min(min_window, right - left + 1)
                window_sum -= nums[left]
                left += 1
        
        return min_window if min_window != float("inf") else 0