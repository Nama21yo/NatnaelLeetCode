from typing import List

class Solution:
    def countOfPairs(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)

        # dp[a] = number of ways where current A value is a
        dp = [1] * (nums[0] + 1)

        for i in range(1, n):
            new_dp = [0] * (nums[i] + 1)

            # prefix sum of dp for fast transitions
            prefix = [0] * (len(dp) + 1)
            for j in range(len(dp)):
                prefix[j + 1] = (prefix[j] + dp[j]) % MOD

            for a in range(nums[i] + 1):
                # condition:
                # a' <= a  (A nondecreasing)
                # b' >= b  (B nonincreasing)
                # b = nums[i] - a
                # b' = nums[i-1] - a'
                #
                # b' >= b  => nums[i-1] - a' >= nums[i] - a
                # => a' <= a + nums[i-1] - nums[i]

                limit = min(a, a + nums[i - 1] - nums[i])
                if limit >= 0:
                    new_dp[a] = prefix[limit + 1]

            dp = new_dp

        return sum(dp) % MOD
