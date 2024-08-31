class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        n = len(nums)
        
        # 1. Find the longest prefix match
        index = -1
        for i in range(n - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                index = i
                break

        # 2. If a valid index is found, find the element just larger than nums[index] and swap them
        if index != -1:
            for j in range(n - 1, index, -1):
                if nums[j] > nums[index]:
                    nums[index], nums[j] = nums[j], nums[index]  # Swap
                    break

        # 3. Reverse the remaining part of the array to get the next permutation
        self.reverse(nums, index + 1, n - 1)
    
    def reverse(self, nums: List[int], start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]  # Swap
            start += 1
            end -= 1
