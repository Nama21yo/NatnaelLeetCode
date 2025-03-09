class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        n = len(matrix)
        m = len(matrix[0])

        # find prefix sum column wise except if you get 0
        # reset sum to 0
        dp = [[0]*m for _ in range(n)]
        for c in range(m):
            running_sum = 0
            for r in range(n):
                if int(matrix[r][c]) == 0:
                    running_sum = 0
                else:
                    running_sum += int(matrix[r][c])
                dp[r][c] +=  running_sum
        
        # for each row find the largest histogram
        row_max_area = [-1] * n
        for r in range(n):
            prev_smaller = [-1] * m
            next_smaller = [m] * m
            stack  = []
            for c in range(m): # left smaller
                while stack and dp[r][stack[-1]] >= dp[r][c]:
                    stack.pop()
                if stack:
                    prev_smaller[c] = stack[-1]
                stack.append(c)
            stack = []
            for c in range(m - 1, -1, -1): # right smaller
                while stack and dp[r][stack[-1]] >= dp[r][c]:
                    stack.pop()
                if stack:
                    next_smaller[c] = stack[-1]
                stack.append(c)
            row_max = -1
            for c in range(m):
                width = next_smaller[c] - prev_smaller[c] - 1
                height = dp[r][c]
                area = width * height
                row_max = max(row_max, area)
            row_max_area[r] = row_max
        # return the maximum area of the rows
        return max(row_max_area)
