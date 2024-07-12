class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Initialize an empty list to store all subsets
        subs = []
        # Initialize an empty list to store the current combination
        combs = []

        # Define the backtracking function
        def backtrack(i, combs, subs, nums):
            # If the index reaches the length of nums, add the current combination to subs
            if i == len(nums):
                subs.append(combs.copy())
                return
            # Include the current number in the combination and recurse
            combs.append(nums[i])
            backtrack(i + 1, combs, subs, nums)
            
            # Exclude the current number from the combination and recurse
            combs.pop()
            backtrack(i + 1, combs, subs, nums)

        # Start the backtracking with index 0
        backtrack(0, combs, subs, nums)
        return subs
