class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        max_or = 0
        for num in nums:
            max_or |= num
        
        # res = 0
        def dfs(i, cur_or):
            nonlocal max_or
            if i == len(nums):
                return 1 if cur_or == max_or else 0
            # skip i
            return (
                dfs(i + 1, cur_or) +
                dfs(i + 1, cur_or| nums[i])
            )
        return dfs(0, 0)
        # return res