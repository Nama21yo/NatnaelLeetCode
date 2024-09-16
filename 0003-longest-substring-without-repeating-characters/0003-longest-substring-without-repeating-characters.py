class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charMap = {}
        left = 0
        maxLen = 0
        right = 0
        
        while right < len(s):
            currentChar = s[right]
            if currentChar in charMap:
                left = max(left, charMap[currentChar] + 1)
            # if(charMap[currentChar] >= right):
            #     charMap[currentChar] = right
            # change this concept by using max in the left
            charMap[currentChar] = right
            maxLen = max(maxLen, right - left + 1)
            right += 1
        return maxLen
            
