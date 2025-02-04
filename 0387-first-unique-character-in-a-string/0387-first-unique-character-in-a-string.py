class Solution:
    def firstUniqChar(self, s: str) -> int:
        my_count = Counter(s)
        my_first = ""
        for key, value in my_count.items():
            if value == 1:
                my_first += key
                break
        
        for i,char in enumerate(s):
            if char == my_first:
                return i
        return -1