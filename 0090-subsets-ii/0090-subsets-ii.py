class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans = set()
        nums.sort()
        def subsequence(nums, i , output):
            if i == len(nums):
                ans.add(tuple(output))
                return
            output.append(nums[i])
            subsequence(nums, i + 1, output)
            output.pop()
            subsequence(nums, i + 1, output)
        subsequence(nums, 0, [])
        return [list(el) for el in ans]