class Solution:
    def _filter(self, nums, num):
        subset = []
        j = len(nums) - 1
        while num > 0:
            last_bit = (num & 1)
            if last_bit == 1:
                subset.append(nums[j])
            j -= 1
            num = num >> 1
        return subset
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        subsets = set()
        for i in range(1<<n):
            each_subset = self._filter(nums, i)
            subsets.add(tuple(each_subset))
        return [list(sub) for sub in subsets]
