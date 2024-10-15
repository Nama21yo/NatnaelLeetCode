class Solution:
    def minimumSteps(self, s: str) -> int:
        min_swap = 0

        l = 0

        for r in range(len(s)):
            if s[r] == "0":
                min_swap += (r - l)
                l += 1
        

        return min_swap
        