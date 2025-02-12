class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        n = len(nums)
        l = -1

        for r in range(n):
            if  nums[r] % 2 == 0:
                l += 1
                nums[l], nums[r] = nums[r], nums[l]
        return nums