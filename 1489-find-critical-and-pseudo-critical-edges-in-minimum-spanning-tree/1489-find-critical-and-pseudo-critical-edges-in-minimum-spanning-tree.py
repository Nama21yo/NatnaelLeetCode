class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        if px == py:
            return False
        if self.rank[px] < self.rank[py]:
            self.parent[px] = py
        elif self.rank[px] > self.rank[py]:
            self.parent[py] = px
        else:
            self.parent[py] = px
            self.rank[px] += 1
        return True


class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        edges = [edge + [i] for i, edge in enumerate(edges)]
        edges.sort(key=lambda x: x[2])

        def kruskal(skip_edge=-1, force_edge=None):
            uf = UnionFind(n)
            weight = 0
            used = 0

            if force_edge:
                u, v, w, _ = force_edge
                if uf.union(u, v):
                    weight += w
                    used += 1

            for u, v, w, idx in edges:
                if idx == skip_edge:
                    continue
                if uf.union(u, v):
                    weight += w
                    used += 1
                if used == n - 1:
                    break

            return weight if used == n - 1 else float('inf')

        mst_weight = kruskal()

        critical = []
        pseudo = []

        for u, v, w, idx in edges:
            if kruskal(skip_edge=idx) > mst_weight:
                critical.append(idx)
            elif kruskal(force_edge=[u, v, w, idx]) == mst_weight:
                pseudo.append(idx)

        return [critical, pseudo]
