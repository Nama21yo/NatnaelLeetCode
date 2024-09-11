class Solution:
    def isPalindrome(self, s: str) -> bool:
        # Clean up the string: ignore non-alphanumeric characters and make it lowercase
        s = ''.join(char.lower() for char in s if char.isalnum())
        
        # Call the recursive helper function
        return self.checkpal(s, 0, len(s) - 1)
    
    def checkpal(self, s: str, start: int, end: int) -> bool:
        # Base case: if the start index crosses the end index, it's a palindrome
        if start >= end:
            return True
        
        # Recursive case: check if characters at start and end are the same
        if s[start] != s[end]:
            return False
        
        # Recurse for the next characters
        return self.checkpal(s, start + 1, end - 1)
