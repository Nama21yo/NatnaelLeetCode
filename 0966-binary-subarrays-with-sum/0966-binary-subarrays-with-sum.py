class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        
        
        # Dictionary to store the frequency of cumulative sums
        prefix_sum_count = defaultdict(int)
        prefix_sum_count[0] = 1  # There's one way to have a sum of 0, by taking no elements
        
        current_sum = 0
        count = 0

        for num in nums:
            current_sum += num
            
            # Check if (current_sum - goal) exists in the prefix sums
            if (current_sum - goal) in prefix_sum_count:
                count += prefix_sum_count[current_sum - goal]
            
            # Update the count of current_sum in the dictionary
            prefix_sum_count[current_sum] += 1
        
        return count
