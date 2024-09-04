class Solution:
    def subarraySum(self, nums, k):
        pre_sum_map = defaultdict(int)
        
        count = 0
        sum = 0
        pre_sum_map[0] = 1
        
        for num in nums:
            sum += num
            
            rem = sum - k
            if rem in pre_sum_map:
                count += pre_sum_map[rem]
            
            pre_sum_map[sum] += 1
        
        return count
