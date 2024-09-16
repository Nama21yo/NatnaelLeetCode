class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        countChar = [0]*26
        left = 0
        right = 0
        maxLen = 0
        maxFreq = 0
        
        while right < len(s):
            countChar[ord(s[right]) - ord('A')] += 1
            maxFreq = max(maxFreq, countChar[ord(s[right]) - ord('A')])
            
            if((right - left + 1) - maxFreq > k): # the no of replace yemideregu char
                    countChar[ord(s[left]) - ord('A')] -= 1
                    left += 1
            
            maxLen = max(maxLen, right - left + 1)
            right += 1
        
        return maxLen
        