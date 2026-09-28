class Solution:
    def check(self, nums: list[int]) -> bool:
        n = len(nums)

        drops  = 0

        for i in range(n):
            # 2,1,3,4 we need module
            if nums[i] > nums[(i + 1) % n]:
                drops += 1
        return drops <= 1