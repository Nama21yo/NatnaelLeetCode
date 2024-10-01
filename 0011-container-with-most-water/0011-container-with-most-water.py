class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0
        left = 0
        right = len(height) - 1  # Initialize the right pointer at the end

        # Move pointers towards each other
        while left < right:
            # Calculate the current area using the shorter height
            current_area = (right - left) * min(height[left], height[right])
            # Update the maximum area found so far
            max_area = max(max_area, current_area)

            # Move the pointer corresponding to the shorter line
            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1
        
        return max_area
