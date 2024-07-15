from typing import List

class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        
        # Helper function to reverse the string
        def reverse(left: int, right: int) -> None:
            # Base case: If left index is less than right index, swap the elements
            if left < right:
                s[left], s[right] = s[right], s[left]
                # Recursive call to reverse the next pair of elements
                reverse(left + 1, right - 1)
        
        # Start the recursion with the full range of the list
        reverse(0, len(s) - 1)
