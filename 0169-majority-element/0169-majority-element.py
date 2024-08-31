class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # Find the candidate using Moore's Voting Algorithm
        candidate = self.findCandidate(nums)

        # Verify if the candidate is actually the majority element
        count = 0
        for num in nums:
            if num == candidate:
                count += 1

        # If the candidate occurs more than n/2 times, return it, otherwise return -1
        return candidate if count > len(nums) // 2 else -1

    def findCandidate(self, nums: List[int]) -> int:
        count = 0
        candidate = 0  # Start with no candidate

        # Iterate over the array to find the candidate
        for num in nums:
            if count == 0:
                candidate = num  # Set the current element as the candidate
                count = 1
            elif num == candidate:
                count += 1
            else:
                count -= 1

        return candidate  # Return the candidate found
