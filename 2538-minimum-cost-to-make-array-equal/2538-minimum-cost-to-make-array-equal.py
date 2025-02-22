class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        def f(x): # total cost to make all numbers in num == x
            return sum((abs(nums[i] - x) * cost[i] for i in range(n)))
        
        n = len(nums) # IIIIIII V VVVVV
        l = min(nums) - 1 # invalid
        r = max(nums) + 1 # valid
        # cost function is like quadratic with a = +ve
        # f(x) > f(x + 1) >> from left
        # f(x) <= f(x + 1) >> from vertex to right
        while r - l > 1:
            #  l < h - 1
            mid= l + (r - l)//2
            if f(mid) <= f(mid + 1):
                r  = mid # right is valid so no +/- 
            else:
                l = mid # l is invalid so need +/- or not
        return f(r)  