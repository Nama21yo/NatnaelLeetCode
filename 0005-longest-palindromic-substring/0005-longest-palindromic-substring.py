class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        res_len = 0 
        n = len(s)

        for i in range(n):
            # odd
            left, right = i,i
            while left >= 0 and right < n and s[left] == s[right]:
                if right - left + 1 > res_len:
                    res = s[left:right + 1]
                    res_len = right - left + 1
                left -= 1
                right += 1
            
            # even
            left, right = i, i + 1
            while left >= 0 and right < n and s[left] == s[right]:
                if right - left + 1 > res_len:
                    res = s[left: right + 1]
                    res_len = right - left + 1
                left -= 1
                right += 1
        return res
