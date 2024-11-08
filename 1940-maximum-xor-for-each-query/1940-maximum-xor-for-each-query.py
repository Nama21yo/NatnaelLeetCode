class Solution:
    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        # TC- O(n)
        # SC- O(1)
        xor = 0
        for num in nums:
            xor ^= num
        n = len(nums)
        # mask = 2 ** maximumBit - 1
        mask = (1 << maximumBit) - 1
        answer = []
        for i in range(n - 1, -1, -1):
            answer.append(xor ^ mask)
            xor = xor ^ nums[i]
        
        return answer
            