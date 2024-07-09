class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Recursive helper function to handle the power calculation
        def helper(x, n):
            # Base case: Any number raised to the power of 0 is 1
            if n == 0:
                return 1
            # If n is even, recursively call the function with n/2 and square the result
            elif n % 2 == 0:
                ans = helper(x, n // 2)
                return ans * ans
            # If n is odd, multiply x with the result of the function called with (n-1)
            else:
                return x * helper(x, n - 1)

        # Handle the case where n is negative
        if n < 0:
            x = 1 / x
            n = -n
        
        # Call the helper function with the original x and n values
        return helper(x, n)
