class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        n = len(nums)
        nums = sorted(map(int , nums))
        return str(nums[n - k])
        