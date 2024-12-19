class Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        countc = s.count(c)
        return (countc * ((countc + 1))//2)
        