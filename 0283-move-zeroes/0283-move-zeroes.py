class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        l = 0
        for r in range(len(nums)):
            if(nums[r] != 0):
                self.swap(nums, l , r)
                l += 1
    def swap(self, nums, start, end):
        temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        
        