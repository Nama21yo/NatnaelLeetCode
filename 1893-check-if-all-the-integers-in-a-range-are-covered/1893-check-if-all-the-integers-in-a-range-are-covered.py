class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        # line sweep 
        # < 10^3 -> list
        # > 10^ 3 -> defaultdict

        # 0 1  2  3  4  5  6  7 8
        # 0 1    -1
        #         1    -1
        #               1    -1

        # 0 1  2  3  4  5  6  7  9
        # 0 1  0  0  0  0  0  -1 0
        # 0 1  1  1  1  1  1   0 0

        # [1 - 7)
        # [2, 5] True / False -> True

        difference = [0] * 52

        for start, end in ranges:
            difference[start] += 1
            difference[end + 1] -= 1
        
        # prefix_sum = [0] * 52
        # running = 0
        # for i in range(52):
        #     running += difference[i]
        #     prefix_sum[i] = running
        
        # for i in range(left, right + 1):
        #     if prefix_sum[i] <= 0:
        #         return False
        # return True

        running_sum = 0
        for i in range(52):
            running_sum += difference[i]
            if left <= i <= right and running_sum <= 0:
                return False
        return True
        