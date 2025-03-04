class Solution:
    def maxSubarraySumCircular(self, arr: List[int]) -> int:
        def kadane(arr):
            max_ending_here = max_so_far = arr[0]
            for num in arr[1:]:
                max_ending_here = max(num, max_ending_here + num)
                max_so_far = max(max_so_far, max_ending_here)
            return max_so_far

        max_linear = kadane(arr)
        total_sum = sum(arr)
        inverted_arr = [-num for num in arr]
        max_circular = total_sum + kadane(inverted_arr)

        return max(max_linear, max_circular) if max_linear > 0 else max_linear
