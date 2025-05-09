class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        island_data = {}  # for the size of the island
        island_id = 2

        self.grid = grid
        self.rows = len(grid)
        self.cols = len(grid[0])

        def marker(island_id, r, c):
            if not (0 <= r < self.rows and 0 <= c < self.cols):
                return 0
            if self.grid[r][c] != 1:
                return 0
            self.grid[r][c] = island_id
            go_left = marker(island_id, r, c - 1)
            go_right = marker(island_id, r, c + 1)
            go_up = marker(island_id, r - 1, c)
            go_down = marker(island_id, r + 1, c)
            return 1 + go_left + go_right + go_up + go_down

        for r in range(self.rows):
            for c in range(self.cols):
                if self.grid[r][c] == 1:
                    current_island_size = marker(island_id, r, c)
                    island_data[island_id] = current_island_size
                    island_id += 1
        
        # for testcases like if all of them are 1
        if not any(0 in row for row in self.grid):
            return self.rows * self.cols

        solution = 1
        for r in range(self.rows):
            for c in range(self.cols):
                if self.grid[r][c] == 0:
                    current_size = 1
                    island_connected = set()
                    for dx, dy in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        nx, ny = r + dx, c + dy
                        inbound = 0 <= nx < self.rows and 0 <= ny < self.cols
                        if inbound:
                            if self.grid[nx][ny] > 1:
                                island_id = self.grid[nx][ny]
                                island_connected.add(island_id)
                    for id_ in island_connected:
                        current_size += island_data[id_]
                    solution = max(current_size, solution)

        return solution
