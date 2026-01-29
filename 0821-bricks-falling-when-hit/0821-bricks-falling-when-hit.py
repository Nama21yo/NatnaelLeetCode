class Solution:
    def hitBricks(self, grid: List[List[int]], hits: List[List[int]]) -> List[int]:
        def dfs(x, y):
            if not (0 <= x < m and 0 <= y < n) or grid[x][y] != 1:
                return 0
            grid[x][y] = 2  
            return 1 + sum(dfs(x + dx, y + dy) for dx, dy in dirs if 0 <= x + dx < m and 0 <= y + dy < n)
        
        def is_stable(x, y):
            return x == 0 or any((0 <= nx < m and 0 <= ny < n) and grid[nx][ny] == 2 for nx, ny in [(x + dx, y + dy) for dx, dy in dirs])
        
        m, n, dirs = len(grid), len(grid[0]), [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        for x, y in hits:
            if 0 <= x < m and 0 <= y < n: 
                grid[x][y] -= 1
        
        for y in range(n):
            dfs(0, y)
        
        res = []
        for x, y in reversed(hits):
            if 0 <= x < m and 0 <= y < n:  
                grid[x][y] += 1
                res.append(dfs(x, y) - 1 if grid[x][y] == 1 and is_stable(x, y) else 0)
        
        return res[::-1]  