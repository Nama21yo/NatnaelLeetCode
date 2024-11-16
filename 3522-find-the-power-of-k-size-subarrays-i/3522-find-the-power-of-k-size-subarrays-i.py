class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        answer = [-1] * (len(nums) - k + 1)
        
        l = 0
        r = 0
        n = len(nums)
        count = 1 
        i = 0
        
        while r < n:
            # Increase count if the current and previous elements are consecutive
            if r > 0 and nums[r - 1] + 1 == nums[r]:
                count += 1
            
            # Shrink the window if it's larger than k
            if r - l + 1 > k:
                if nums[l] + 1 == nums[l + 1]:
                    count -= 1
                l += 1
            
            # Check if the window size equals k and if it contains k consecutive elements
            if r - l + 1 == k:
                if count == k:  
                    answer[i] = nums[r]
                i += 1
            
            r += 1
        
        return answer
