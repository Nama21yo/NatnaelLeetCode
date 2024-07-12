class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        # Base case: if n is less than 1, it cannot be a power of four
        if n < 1:
            return False
        # Base case: if n is exactly 1, it is a power of four
        if n == 1:
            return True
        # Recursive case: if n is divisible by 4, continue checking with n divided by 4
        if n % 4 == 0:
            return self.isPowerOfFour(n // 4)
        # If n is not divisible by 4, it cannot be a power of four
        return False
