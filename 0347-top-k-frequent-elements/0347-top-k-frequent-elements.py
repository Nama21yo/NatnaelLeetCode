from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Step 1: Create a frequency map
        frequency_map = defaultdict(int)
        for num in nums:
            frequency_map[num] += 1
        
        # Step 2: Create the bucket list where index represents the frequency
        bucket = [[] for _ in range(len(nums) + 1)]
        for num, freq in frequency_map.items():
            bucket[freq].append(num)
        
        # Step 3: Gather the k most frequent elements
        res = []
        for i in range(len(bucket) - 1, 0, -1):
            for num in bucket[i]:
                res.append(num)
                if len(res) == k:
                    return res
