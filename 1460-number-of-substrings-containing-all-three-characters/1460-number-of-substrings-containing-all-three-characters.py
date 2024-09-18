class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        n = len(s)
        left  = 0
        right = 0
        lastSeen = [0] * 3
        count = 0

        while(right < n):
            lastSeen[ord(s[right]) - ord('a')] += 1
            while(lastSeen[0] > 0 and lastSeen[1] > 0 and lastSeen[2] > 0):
                count += (n - right)
                lastSeen[ord(s[left]) - ord('a')] -= 1
                left += 1
            right += 1

        return count
        
        