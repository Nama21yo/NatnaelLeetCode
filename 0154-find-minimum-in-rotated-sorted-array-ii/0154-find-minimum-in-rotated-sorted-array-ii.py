class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        ans = float("inf")
        if l == r:
            return nums[l]
        while l <= r:
            mid = l + (r - l) // 2
            if nums[l] == nums[mid] == nums[r]:
                ans = min(ans, nums[l])
                l += 1
                r -= 1
            elif nums[l] <= nums[mid]:
                ans = min(ans, nums[l])
                l = mid + 1
            else:
                ans = min(ans, nums[mid])
                r = mid - 1
        return ans