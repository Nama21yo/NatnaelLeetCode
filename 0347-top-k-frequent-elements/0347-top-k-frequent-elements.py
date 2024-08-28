import heapq
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if k == len(nums):
            return nums
        
        # Step 1: Count the frequency of each element
        count = Counter(nums)
        
        # Step 2: Use a heap to keep track of top k elements
        return heapq.nlargest(k, count.keys(), key=count.get)
