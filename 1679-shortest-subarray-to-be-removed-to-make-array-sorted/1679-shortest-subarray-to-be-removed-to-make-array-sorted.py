class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        ans =  0
        n = len(arr)

        peak = 0
        while peak < n - 1 and arr[peak] <= arr[peak + 1]:
            peak += 1
        # the edge case if it is already sorted
        if peak == n - 1:
            return 0

        valley = n - 1
        while valley > peak and arr[valley - 1] <= arr[valley]:
            valley -= 1

        # case 1: remove every thing after peak
        # case 2: remove every thing before the valley
        ans = min(n - peak - 1, valley)

        # the las trick part when there is the middle part
        i = 0
        j = valley

        while i <= peak and j < n:
            if arr[j] >= arr[i]:
                ans = min(ans , j - i - 1)
                i += 1
            else:
                j+= 1
        
        return ans