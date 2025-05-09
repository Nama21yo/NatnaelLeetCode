class Solution:
    def firstOccurence(self, nums, target):
        l = 0
        r = len(nums) - 1
        ans = -1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                ans = mid
                r = mid - 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return ans
    def lastOccurence(self, nums, target):
        l = 0
        r = len(nums) - 1
        ans = -1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                ans = mid
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return ans
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = self.firstOccurence(nums, target)
        right = self.lastOccurence(nums, target)
        return [left, right]