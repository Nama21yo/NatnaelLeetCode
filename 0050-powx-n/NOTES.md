Function myPow(x: float, n: int) -> float
If n < 0
x = 1 / x
n = -n
Return helper(x, n)
​
Function helper(x: float, n: int) -> float
If n == 0
Return 1
Else if n is even
ans = helper(x, n // 2)
Return ans * ans
Else
Return x * helper(x, n - 1)
​
// Time Complexity: O(log n), where n is the power. The recursion depth is log(n) due to the halving of the power.
// Space Complexity: O(log n), due to the recursion stack.
​