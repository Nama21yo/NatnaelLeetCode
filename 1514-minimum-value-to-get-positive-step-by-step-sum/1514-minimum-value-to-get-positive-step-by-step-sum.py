class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        prefixSum  = 0
        minValue = 0
        for num in nums:
            prefixSum += num
            # find the minimum negative value
            minValue = min(minValue,prefixSum)
        
        return 1 - minValue