class Solution:
    def minChanges(self, s: str) -> int:
        l = 0
        count = 0

        for r in range(len(s)):
            if s[l] != s[r]:
                # if r % 2  ==  1:
                if r & 1:
                    count += 1
                l = r


        return count
