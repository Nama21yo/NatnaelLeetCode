class UnionFind:
    def __init__(self):
        self.parent = {}

    def find(self, x):
        if self.parent.setdefault(x, x) != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        self.parent[self.find(x)] = self.find(y)


class Solution:
    def matrixRankTransform(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])

        value_cells = defaultdict(list)
        for i in range(m):
            for j in range(n):
                value_cells[matrix[i][j]].append((i, j))

        rowRank = [0] * m
        colRank = [0] * n
        result = [[0] * n for _ in range(m)]
        for value in sorted(value_cells):
            uf = UnionFind()

            for r, c in value_cells[value]:
                uf.union(('r', r), ('c', c))

            comp_rank = defaultdict(int)
            for r, c in value_cells[value]:
                root = uf.find(('r', r))
                comp_rank[root] = max(comp_rank[root], rowRank[r], colRank[c])

            for r, c in value_cells[value]:
                root = uf.find(('r', r))
                rank = comp_rank[root] + 1
                result[r][c] = rank
                rowRank[r] = rank
                colRank[c] = rank

        return result
