class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        count_sneaky = Counter(nums)

        sneaky = []
        for key,count in count_sneaky.items():
            if count == 2:
                sneaky.append(key)
        return sneaky

        