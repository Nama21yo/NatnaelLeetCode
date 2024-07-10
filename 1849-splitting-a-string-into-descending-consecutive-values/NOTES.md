Function splitString(s: String) -> boolean
Return helper(s, -1)
​
Function helper(s: String, parent: long) -> boolean
If s is empty, return true
Initialize current as 0
For i from 0 to length of s - 1
current = current * 10 + integer value of s[i]
If (i is not the last index and parent is -1) or (parent - current is equal to 1)
If helper(substring of s from i + 1 to end, current) is true
Return true
Return false
Time Complexity: O(N^2)
- Where N is the length of the string.
- The reason for this complexity is due to the substring operation within the for loop, which creates a new string for each recursive call.
​
Space Complexity: O(N)
- The space complexity is due to the recursive call stack. In the worst case, the depth of the recursion can be equal to the length of the string, N.
​