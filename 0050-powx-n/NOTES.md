Can the value of n can be negative?
First use the brute force approach using iteration
​
Function myPow(x, n) -> double
Initialize finalAnswer to 1.0
Initialize powerOf to n
​
If powerOf is negative
Convert powerOf to positive
​
While powerOf is greater than 0
If powerOf is even
Square the base x
Halve the power powerOf
Else
Multiply finalAnswer by x
Decrement powerOf by 1
​
If n was negative
Invert finalAnswer
​
Return finalAnswer
​
// Time Complexity: O(log n), where n is the power. The loop runs log(n) times due to the halving of the power.
// Space Complexity: O(1), as no extra space is used other than a few variables.
​