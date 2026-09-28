class Solution:
    def findMaxConsecutiveOnes(self, nums: list[int]) -> int:
        best = 0
        current = 0

        for num in nums:
            if num == 1:
                current += 1
            else:
                current = 0
            best = max(best, current)
        return best