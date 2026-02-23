class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        if len(s) < k:
            return False
        
        seen = set()
        for i in range(len(s) - k + 1):
            substring = s[i: i + k]
            seen.add(substring)
        
        return len(seen) == (1 << k)