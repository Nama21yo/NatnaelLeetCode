class Solution:
    def canSortArray(self, nums: List[int]) -> bool:
        # Bubble Sorting
        n = len(nums)
        for i in range(n):
            flag = False

            for j in range(n - i - 1):
                if(nums[j] <= nums[j + 1]):
                    continue
                if(self.setBits(nums[j]) == self.setBits(nums[j + 1])):
                    nums[j], nums[j + 1] = nums[j + 1], nums[j]
                    flag = True
                else:
                    return False
            if not flag:
                break
        return True
    
    def setBits(self, number):
        count = 0
        while(number > 0):
            # if(number % 2 == 1):
            #     count += 1
            count += number & 1
            # number = number // 2
            number >>= 1
        return count

        