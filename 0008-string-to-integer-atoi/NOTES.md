Function myAtoi(str: String) -> int
Initialize result as 0, index as 0, sign as 1, and length as length of str
​
// Step 1: Discard all leading whitespaces
While index < length and str[index] is ' '
Increment index
​
// Step 2: Check for optional sign
If index < length and (str[index] is '+' or str[index] is '-')
If str[index] is '-'
sign = -1
Else
sign = 1
Increment index
​
// Step 3: Convert digits to number
While index < length and str[index] is a digit
digit = str[index] - '0'
​
// Step 4: Check for overflow and underflow conditions
If result > (Integer.MAX_VALUE - digit) / 10
Return Integer.MAX_VALUE if sign is 1, otherwise Integer.MIN_VALUE
​
// Step 5: Update result
result = result * 10 + digit
Increment index
​
// Step 6: Apply sign to result
Return result * sign
​
// Time Complexity: O(n), where n is the length of the input string.
// Space Complexity: O(1), since we are using only a constant amount of extra space.
​