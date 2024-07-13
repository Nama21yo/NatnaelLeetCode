Function combine(n, k):
list = new List to store combinations
Call backtrack(list, n, k, new List, 1)
Return list
​
Function backtrack(list, n, k, temp, start):
If k == 0:
Add a copy of temp to list
Return
​
For i from start to n - k + 1:
Add i to temp
Call backtrack(list, n, k - 1, temp, i + 1)
Remove the last element from temp to backtrack
Time Complexity: O(C(n, k))
- Where C(n, k) is the number of combinations of n items taken k at a time, which is equal to n! / (k! * (n - k)!)
- This is because we generate all possible combinations.
​
Space Complexity: O(k)
- This is the maximum depth of the recursion stack, which occurs when the temporary list `temp` contains k elements.
​