Function maxSumBST(root) -> int
Initialize maxSum to 0
If root is null, return 0
Call traverse(root)
Return maxSum
​
Class Result
Initialize lower, upper, sum
​
Function traverse(node) -> Result
If node is null, return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0)
leftResult = traverse(node.left)
rightResult = traverse(node.right)
If leftResult is null or rightResult is null, return null
If node.val <= leftResult.upper or node.val >= rightResult.lower, return null
currentSum = node.val + leftResult.sum + rightResult.sum
maxSum = max(maxSum, currentSum)
lower = min(node.val, leftResult.lower)
upper = max(node.val, rightResult.upper)
Return new Result(lower, upper, currentSum)
// Time Complexity: O(n), where n is the number of nodes in the binary tree. We visit each node exactly once.
// Space Complexity: O(h), where h is the height of the binary tree. This is due to the recursion stack.
​