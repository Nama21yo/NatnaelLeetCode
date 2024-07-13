from typing import List

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # List to store all combinations
        combs = []
        
        # List to store the current combination being constructed
        subs = []
        
        # Helper function for backtracking
        def backtrack(i, subs, combs, k, n):
            # If the current combination is of the desired length, add it to the result list
            if len(subs) == k:
                combs.append(subs.copy())  # Use copy to avoid reference issues
                return
            
            # If the current index exceeds n, stop the recursion
            if i > n:
                return
            
            # Include the current element and proceed
            subs.append(i)
            backtrack(i + 1, subs, combs, k, n)
            
            # Exclude the current element (backtrack) and proceed
            subs.pop()
            backtrack(i + 1, subs, combs, k, n)
        
        # Start the backtracking process from 1
        backtrack(1, subs, combs, k, n)
        
        # Return the list of all combinations
        return combs
