            
class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        distinct = defaultdict(int)
        total = 0
        maxTotal = 0
        n = len(nums)
        left = 0

        for right in range(n):
            total += nums[right]
            distinct[nums[right]] += 1

            if right - left + 1 == k:
                if len(distinct) == k:
                    maxTotal = max(maxTotal, total)

                # Slide the window
                total -= nums[left]
                distinct[nums[left]] -= 1
                if distinct[nums[left]] == 0:
                    del distinct[nums[left]]
                left += 1

        return maxTotal
