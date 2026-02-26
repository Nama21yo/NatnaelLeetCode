class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []
        
        result = []
        p_count = Counter(p)
        window_count = Counter()
        
        left = 0
        
        for right in range(len(s)):
            # Add current character to the window
            window_count[s[right]] += 1
            
            # If window size exceeds p length, shrink from left
            if right - left + 1 > len(p):
                window_count[s[left]] -= 1
                if window_count[s[left]] == 0:
                    del window_count[s[left]]
                left += 1
            
            # Compare window with p
            if window_count == p_count:
                result.append(left)
        
        return result