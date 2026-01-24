class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int) -> None:
        px, py = self.find(x), self.find(y)
        if px == py:
            return

        if self.rank[px] < self.rank[py]:
            self.parent[px] = py
        elif self.rank[px] > self.rank[py]:
            self.parent[py] = px
        else:
            self.parent[py] = px
            self.rank[px] += 1
class Solution:
    def distanceLimitedPathsExist(
        self,
        n: int,
        edgeList: List[List[int]],
        queries: List[List[int]]
    ) -> List[bool]:
        edgeList.sort(key=lambda x: x[2])

        queries_with_index = []
        for i, (u, v, limit) in enumerate(queries):
            queries_with_index.append((limit, u, v, i))
        queries_with_index.sort()

        uf = UnionFind(n)
        res = [False] * len(queries)

        edge_idx = 0

        for limit, u, v, q_idx in queries_with_index:
            while edge_idx < len(edgeList) and edgeList[edge_idx][2] < limit:
                x, y, _ = edgeList[edge_idx]
                uf.union(x, y)
                edge_idx += 1

            res[q_idx] = uf.find(u) == uf.find(v)

        return res
