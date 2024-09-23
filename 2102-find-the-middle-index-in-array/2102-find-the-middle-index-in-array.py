class Solution:
    def findMiddleIndex(self, nums: List[int]) -> int:
        n = len(nums)

        totalSum = sum(nums)

        leftSum = 0
        rightSum =totalSum

        for i in range(n):
            rightSum -= nums[i]
            # check if before manipulating the left Sum
            if leftSum == rightSum:
                return i
            leftSum += nums[i]
        
        return -1

        