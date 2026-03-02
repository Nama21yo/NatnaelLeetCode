class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        total = sum(nums)
        right_sum = total
        left_sum = 0
        valid = 0

        for i in range(len(nums) - 1):
            left_sum += nums[i]
            right_sum -= nums[i]

            if abs(left_sum - right_sum) % 2 == 0:
                valid += 1
        return valid