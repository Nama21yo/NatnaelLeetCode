class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans_map = {}
        
        for s in strs:
            count = [0] * 26  # Initialize the count array
            
            for c in s:
                count[ord(c) - ord('a')] += 1  # Count the frequency of each character
            
            key = tuple(count)  # Use the tuple of counts as the key
            
            if key not in ans_map:
                ans_map[key] = []
            
            ans_map[key].append(s)  # Add the string to the list corresponding to the key
        
        return list(ans_map.values())
