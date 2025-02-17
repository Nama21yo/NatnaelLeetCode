class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixSumCount = {0 : 1}
        prefixSum = 0
        count = 0
        for num in nums:
            prefixSum += num
            
            count += prefixSumCount.get(prefixSum - k, 0)
            
            prefixSumCount[prefixSum] = 1 + prefixSumCount.get(prefixSum,0)
        
        return count