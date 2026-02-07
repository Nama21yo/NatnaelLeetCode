class Solution:
    def minimumDeletions(self, s: str) -> int:
        cb = 0   
        ans = 0  # min deletions so far

        for c in s:
            if c == 'b':
                cb += 1
            else:  # c == 'a'
                ans = min(ans + 1, cb)

        return ans
