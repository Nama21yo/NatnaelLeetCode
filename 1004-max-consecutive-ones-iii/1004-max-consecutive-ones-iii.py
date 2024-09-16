class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0  # Left pointer for the sliding window
        maxLen = 0  # To store the maximum length of the window
        zerosCount = 0  # To count how many zeros are in the current window
        
        # Iterate with the right pointer
        for right in range(len(nums)):
            if nums[right] == 0:
                zerosCount += 1
            
            # If zerosCount exceeds k, move the left pointer to reduce zeros
            while zerosCount > k:
                if nums[left] == 0:
                    zerosCount -= 1
                left += 1
            
            # Update the maximum length of the window
            maxLen = max(maxLen, right - left + 1)
        
        return maxLen
