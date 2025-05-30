class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        def divide(s):
            if len(s) <= 1:
                return ""
            set_s = set(s)
            for i,char in enumerate(s):
                opposite_case = char.swapcase()
                if opposite_case not in set_s:
                    left = divide(s[:i])
                    right = divide(s[i + 1:])
                    if len(left) >= len(right):
                        return left
                    else:
                        return right
            return s
        return divide(s)
