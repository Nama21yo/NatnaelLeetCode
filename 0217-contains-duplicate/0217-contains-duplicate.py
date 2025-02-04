class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        my_count = Counter(nums)

        for value in my_count.values():
            if value > 1:
                return True
        return False