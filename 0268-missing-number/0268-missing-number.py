class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        trueSum = n * (n + 1) / 2
        
        listSum = 0
        for i in range(len(nums)):
            listSum += nums[i]
        
        
        return (int)(trueSum - listSum)
        