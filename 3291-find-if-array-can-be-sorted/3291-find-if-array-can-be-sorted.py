class Solution(object):
    def canSortArray(self, nums):
        previousMax = float("-inf")
        currentMax = nums[0]
        currentMin = nums[0]

        for num in nums:
            if self.setBits(num) == self.setBits(currentMin):
                currentMin = min(currentMin, num)
                currentMax = max(currentMax, num)
            else:
                if currentMin < previousMax:
                    return False
                previousMax = currentMax
                currentMin = num
                currentMax = num
        if currentMin < previousMax:
                return False
        return True
        
    def setBits(self, number):
        count = 0
        while(number > 0):
            count += number & 1
            number >>= 1
        return count
        