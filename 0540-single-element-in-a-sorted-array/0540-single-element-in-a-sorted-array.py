class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        # Can be solve using Binary Search
        n = len(nums)
        l = -1
        r = n 
        if n == 1:
            return nums[0]
            # unique start
        if nums[0] != nums[1]:
            return nums[0]
        # unique end
        if nums[n - 1] != nums[n - 2]:
            return nums[n- 1]
        # middle is better to search by m = l + (r-l)/2. Because when using (l+r)/2         could lead to overflow in time when l == max_int and r == max_int.
        while l < r - 1:
            mid = l + ((r - l) // 2)
            # if mid is even, then it's duplicate should be in next index.
	    # or if mid is odd, then it's duplicate  should be in previous index.
	    # check these two condition 

        # the mid is such that the next and previous element isn't equal
            if (mid % 2 == 0 and nums[mid] == nums[mid + 1]) or (mid % 2 == 1 and nums[mid] == nums[mid - 1]) or (nums[mid] != nums[mid - 1] and nums[mid] != nums[mid + 1]):
                l = mid
            else:
                r = mid
        return nums[l] 
        