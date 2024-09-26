class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        oddSum = 0

        for i in range(len(arr)):
            start = i + 1
            end = len(arr) - i
            total = start * end
            oddLength = total // 2 if total % 2 == 0 else total // 2 + 1
            oddSum += oddLength * arr[i]
        
        return oddSum