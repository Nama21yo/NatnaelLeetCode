class Solution:
    def rearrangeArray(self, nums: list[int]) -> list[int]:
        pos, neg = 0, 1 # even , odd
        n = len(nums)
        ans = [0] * n
        for i in range(n):
            if nums[i] >= 0:
                ans[pos] = nums[i]
                pos += 2
            else:
                ans[neg] = nums[i]
                neg += 2
        return ans