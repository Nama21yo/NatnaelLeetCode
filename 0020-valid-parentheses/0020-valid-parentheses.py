class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        pair = {")":"(", "]":"[","}":"{"}

        for char in s:
            if char in pair:
                if stack and stack[-1] == pair[char]:
                    stack.pop()
                else:
                    stack.append(char)
            else:
                stack.append(char)
        
        return not stack