class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        # The xy plane
        n  = len(grid)
        m = len(grid[0])

        xy_area = 0
        for r in range(n):
            for c in range(m):
                if grid[r][c] != 0:
                    xy_area += 1
        # The xz plane
        xz_area = 0
        for r in range(n):
            maxi = 0
            for c in range(m):
                maxi = max(grid[r][c], maxi)
            xz_area += maxi
        
        # The yz plane
        yz_area = 0
        for c in range(m):
            maxi = 0
            for r in range(n):
                maxi = max(grid[r][c], maxi)
            yz_area += maxi
        
        return xy_area + xz_area + yz_area
                

