class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        hashmap = {")" : "(", "}" : "{", "]": "["}
        for char in s:
            # check for opening bracket
            # closing or opening
            if char in hashmap: # closing
                top = stack.pop() if stack else ""
                if top != hashmap[char]:
                    return False
            else: 
                stack.append(char)
        return len(stack) == 0 
