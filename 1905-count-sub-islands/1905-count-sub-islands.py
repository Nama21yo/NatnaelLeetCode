class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        rows, cols = len(grid1), len(grid1[0])
        visited = set()

        def dfs(row, col):
            if row < 0 or col < 0 or row == rows or col == cols or grid2[row][col] == 0 or (row, col) in visited:
                return True
            
            visited.add((row, col))
            res = True
            if grid1[row][col] == 0:
                res = False


            dirs = [(1, 0), (0, 1), (0 , -1), (-1, 0)]
            for dr,dc in dirs:
                newr, newc = row + dr, col + dc
                res = dfs(newr, newc) and res
            return res

        count = 0
        for row in range(rows):
            for col in range(cols):
                if grid2[row][col] and (row, col) not in visited and dfs(row, col):
                    count += 1
        return count
        