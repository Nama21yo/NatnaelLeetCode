class Solution:
    def sumOfThree(self, num: int) -> List[int]:
        # x + (x + 1) + (x + 2) = num
        # 3*x + 3 = num
        # x = num / 3 - 1
        if num % 3 != 0:
            return []
        first = (num // 3) - 1
        return [first, first + 1, first + 2]