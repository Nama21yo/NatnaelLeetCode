class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        visited = set()
        rows, cols = len(land), len(land[0])
        
        def dfs(row, col):
            nonlocal top, left, bottom, right
            if row < 0 or row >= rows or col < 0 or col >= cols or land[row][col] == 0 or (row, col) in visited:
                return
            visited.add((row, col))
            top = min(row, top)
            bottom = max(row, bottom)
            left =  min(col, left)
            right = max(col, right)
            dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
            for dr, dc in dirs:
                newr, newc = row + dr, col + dc
                dfs(newr, newc)
        res = []
        for row in range(rows):
            for col in range(cols):
                if land[row][col] and (row, col) not in visited:
                    top = bottom = row
                    left = right = col
                    dfs(row, col)
                    res.append([top, left, bottom, right])
        return res