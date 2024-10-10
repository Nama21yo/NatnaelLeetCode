class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        n = len(nums)
        max_right = [0] * n
        
        max_right[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            max_right[i] = max(nums[i], max_right[i + 1])
         
        l = 0
        max_width = 0

        for r in range(n):
            if nums[l] > max_right[r]:
                l += 1
            
            max_width = max(max_width, r - l)
        
        return max_width