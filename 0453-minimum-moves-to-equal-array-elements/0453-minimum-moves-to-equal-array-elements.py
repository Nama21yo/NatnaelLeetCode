class Solution:
    def minMoves(self, nums: List[int]) -> int:
        mini  = float("inf")

        for num in nums:
            mini = min(mini, num)
        
        ans = 0
        for num in nums:
            ans += (num - mini)
        return ans
        