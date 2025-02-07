class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        ans = []

        for i,num in enumerate(nums):
            ans.append(nums[num])
        return ans

        