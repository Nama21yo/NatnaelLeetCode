from collections import defaultdict
class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        l = 0
        n = len(fruits)
        count = defaultdict(int)
        max_fruits = 0

        for r in range(n):
            count[fruits[r]] += 1

            if len(count) > 2:
                count[fruits[l]] -= 1
                if count[fruits[l]] == 0:
                    count.pop(fruits[l])
                l += 1
            max_fruits = max(max_fruits, r - l + 1)
        return max_fruits

        