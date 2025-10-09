class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        # Edge cases for small arrays
        if n == 0:
            return 0
        if n == 1:
            return nums[0]

        def rob_linear(arr: list[int]) -> int:
            rob1 = 0  # Max money robbed up to current-1 house
            rob2 = 0  # Max money robbed up to current-2 house

            # [rob2, rob1, n, n+1, ...]
            for money in arr:
                # new_rob represents the maximum money if we consider 'money'
                # It's either (don't rob 'money', take rob1)
                # or (rob 'money', take money + rob2)
                temp_rob = max(rob1, money + rob2)
                rob2 = rob1
                rob1 = temp_rob
            return rob1

        # Case 1: Rob houses from index 0 to n-2 (excluding the last house)
        # This covers scenarios where the first house is robbed.
        max_money_case1 = rob_linear(nums[0 : n - 1])

        # Case 2: Rob houses from index 1 to n-1 (excluding the first house)
        # This covers scenarios where the last house is robbed.
        max_money_case2 = rob_linear(nums[1 : n])

        # The maximum amount is the greater of the two cases
        return max(max_money_case1, max_money_case2)