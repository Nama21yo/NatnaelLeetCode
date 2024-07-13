from typing import List

class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        # Initialize a 2D array to keep track of cached values
        cache = [[None] * len(nums) for _ in range(len(nums))]
        
        # Helper function to calculate the score difference
        def score(left: int, right: int) -> int:
            # Base case: If the range is invalid, return 0
            if left > right:
                return 0
            
            # Check if the value is already computed and stored in the cache
            if cache[left][right] is not None:
                return cache[left][right]
            
            # Calculate the score difference if the player picks the left element
            score_taking_left = nums[left] - score(left + 1, right)
            # Calculate the score difference if the player picks the right element
            score_taking_right = nums[right] - score(left, right - 1)
            
            # Store the computed value in the cache
            cache[left][right] = max(score_taking_left, score_taking_right)
            return cache[left][right]
        
        # Start the recursive function with the entire array range
        return score(0, len(nums) - 1) >= 0
