class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        
        countNum = {}

        # Populate the dictionary with the frequency of each number
        for num in nums:
            countNum[num] = countNum.get(num, 0) + 1

        # Iterate through the dictionary and return the number which has a count greater than 1
        for key in countNum:
            if countNum[key] > 1:
                return key

        # In case there's no duplicate (though problem assumes there is always one)
        return -1
