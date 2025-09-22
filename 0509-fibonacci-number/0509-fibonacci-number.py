class Solution:
    def fib(self, n: int) -> int:
        memo = {}

        def _fib_memo(num):
            if num in memo:
                return memo[num]
            if num <= 1:
                return num
            
            sub_problem = _fib_memo(num - 1) + _fib_memo(num - 2)
            memo[num] = sub_problem

            return sub_problem
        
        return _fib_memo(n)