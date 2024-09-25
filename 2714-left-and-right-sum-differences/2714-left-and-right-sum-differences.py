class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        leftSum = 0
        rightSum = sum(nums)
        answer = [0]*len(nums)
        for i in range(0,len(nums)):
            rightSum = rightSum - nums[i]
            answer[i] = abs(rightSum - leftSum)
            leftSum = leftSum + nums[i]
        
        return answer