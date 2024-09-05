class Solution:
    def majorityElement(self, nums):
        countEl = {}
        ans = []
        mini = len(nums) // 3
        
        # Count the occurrences of each element
        for num in nums:
            countEl[num] = countEl.get(num, 0) + 1
        
        # Add elements that appear more than len(nums) // 3 times
        for num, count in countEl.items():
            if count > mini:
                ans.append(num)
        
        return ans
