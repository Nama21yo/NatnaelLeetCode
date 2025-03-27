class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        line = defaultdict(int)
        n = len(nums)
        for l , r in queries:
            line[l] += 1
            line[r + 1] -= 1
        curr_sum = 0
        
        for i in range(n):
            curr_sum += line[i]
            if curr_sum < nums[i]:
                return False
        return True