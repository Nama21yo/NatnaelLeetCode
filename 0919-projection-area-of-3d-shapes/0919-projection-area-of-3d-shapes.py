class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        # The xy plane
        n  = len(grid)
        m = len(grid[0])

        total = 0
        for r in range(n):
            max_row = 0
            max_col = 0
            for c in range(m):
                max_row = max(max_row, grid[r][c])
                max_col = max(max_col, grid[c][r])
                if grid[r][c] > 0:
                    total += 1
            total += max_row + max_col

        return total

