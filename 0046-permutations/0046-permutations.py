from typing import List

class Solution:
    # Helper function to generate permutations
    def helper(self, res: List[int], nums: List[int], ans: List[List[int]]):
    # If the current permutation is complete (same length as nums), add it to the answer list
        if len(nums) == len(res):
            ans.append(res.copy())  # Use copy to avoid reference issues
            return
        
        # Iterate through each number in nums
        for i in range(len(nums)):
            # Skip if the number is already in the current permutation
            if nums[i] in res:
                continue
            # Include the current number in the permutation
            res.append(nums[i])
            # Recur to build the next part of the permutation
            self.helper(res, nums, ans)
            # Backtrack by removing the last added number
            res.pop()
    
    # Function to initiate the permutation generation
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []  # List to store all permutations
        self.helper([], nums, ans)  # Start the helper with an empty current permutation
        return ans  # Return the list of all permutations
