class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {}
        def climb(num):
            if num in memo:
                return memo[num]
            if num <= 2:
                return num
            sub_problem = climb(num - 1) + climb(num - 2)
            memo[num] = sub_problem
            return sub_problem
        return climb(n)