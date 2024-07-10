from typing import List

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # Helper function for backtracking
        def backtrack(first_num, path):
            # If the path length is equal to k, add the path to the result
            if len(path) == k:
                ans.append(path[:])
                return
            
            # Iterate from the current number to n
            for num in range(first_num, n + 1):
                # Add the current number to the path
                path.append(num)
                # Recursively backtrack with the next number
                backtrack(num + 1, path)
                # Remove the last number added to the path to backtrack
                path.pop()
        
        ans = []
        backtrack(1, [])
        return ans
