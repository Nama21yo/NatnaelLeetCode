class Solution:
    def findDuplicate(self, nums):
        # Using Floyd's Tortoise and Hare (Cycle Detection)
        slow = nums[0]
        fast = nums[0]

        # Phase 1: Finding the intersection point in the cycle
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        # Phase 2: Finding the entrance to the cycle
        fast = nums[0]
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]

        return slow  # or fast
