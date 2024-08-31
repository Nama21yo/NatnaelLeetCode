class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        # optimal
        ans = [1]*len(nums)
        positiveIndex = 0
        negativeIndex = 1
        
        for i in range(len(nums)):
            if nums[i] < 0:
                ans[negativeIndex] = nums[i]
                negativeIndex += 2
            else:
                ans[positiveIndex] = nums[i]
                positiveIndex += 2
        return ans