class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n  = len(nums)
        if len(nums) == 0:
            return 1
        
        last_pos_idx = self.partition(nums)

        for i in range(last_pos_idx):
            val = abs(nums[i])
            if 1 <= val and val <= last_pos_idx:
                if nums[val - 1] > 0:
                    nums[val - 1] = -nums[val - 1]
        
        for i in range(1, last_pos_idx + 1):
            if nums[i - 1] >= 0:
                return i
        
        return last_pos_idx + 1

    def partition(self, nums):
        # The pivot is known 0
        l = 0
        for r in range(len(nums)):
            if nums[r] > 0:
                self.swap(nums, l , r)
                l += 1
        return l
    def swap(self,nums,start, end):
        temp = nums[start]
        nums[start]  = nums[end]
        nums[end] = temp
        