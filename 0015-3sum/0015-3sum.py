class Solution:
    def threeSum(self, nums):
        result = []
        nums.sort()  # Step 1: Sort the array
        
        # Step 2: Iterate through each number
        for i in range(len(nums) - 2):
            # Skip duplicate elements to avoid repeating triplets
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            left, right = i + 1, len(nums) - 1
          
            
            # Step 3: Use two pointers to find two numbers that sum to -nums[i]
            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]
                
                if current_sum == 0:
                    # Found a valid triplet
                    result.append([nums[i], nums[left], nums[right]])
                    
                    # Skip duplicates for left and right pointers
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    
                    # Move both pointers inward after finding a triplet
                    left += 1
                    right -= 1
                elif current_sum < 0:
                    # If sum is less than the target, move the left pointer to the right
                    left += 1
                else:
                    # If sum is greater than the target, move the right pointer to the left
                    right -= 1
        
        return result
