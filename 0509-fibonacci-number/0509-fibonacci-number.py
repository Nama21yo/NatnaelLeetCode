class Solution:
    def __init__(self):
        self.fibArray = None  # Declare the memoization array

    def fib(self, n: int) -> int:
        # Initialize the memoization array to store computed Fibonacci values
        self.fibArray = [-1] * (n + 1)
        
        # Call the recursive helper function
        return self.fibbo(n)

    def fibbo(self, n: int) -> int:
        # Base cases
        if n <= 1:
            self.fibArray[n] = n
            return n
        
        # Memoization: If already computed, return the stored value
        if self.fibArray[n] != -1:
            return self.fibArray[n]
        
        # Recursive case with memoization
        self.fibArray[n] = self.fibbo(n - 1) + self.fibbo(n - 2)
        return self.fibArray[n]
