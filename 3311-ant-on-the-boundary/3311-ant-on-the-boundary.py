class Solution:
    def returnToBoundaryCount(self, nums: List[int]) -> int:
        prefixSum = 0
        count = 0
        for i in range(len(nums)):
            prefixSum += nums[i]
            if prefixSum == 0:
                count += 1
           
            
        
        return count