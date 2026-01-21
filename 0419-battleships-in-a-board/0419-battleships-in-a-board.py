class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        rows, cols = len(board), len(board[0])

        def dfs(row, col):
            if row < 0 or col < 0 or row >= rows or col >= cols or board[row][col] == ".":
                return
            
            board[row][col] = "."
            dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]
            for dr, dc in dirs:
                newr, newc = row + dr, col + dc
                dfs(newr, newc)
        count = 0
        for row in range(rows):
            for col in range(cols):
                if board[row][col] == "X":
                    dfs(row, col)
                    count += 1
        return count