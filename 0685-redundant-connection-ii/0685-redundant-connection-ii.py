class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n + 1))

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        if px == py:
            return False
        self.parent[py] = px
        return True

class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        parent = [0] * (n + 1)

        cand1 = None  
        cand2 = None 

        for u, v in edges:
            if parent[v] == 0:
                parent[v] = u
            else:
                cand1 = [parent[v], v]
                cand2 = [u, v]
                break

        uf = UnionFind(n)
        for u, v in edges:
            if cand2 and [u, v] == cand2:
                continue

            if not uf.union(u, v):
                if cand1:
                    return cand1
                return [u, v]

        return cand2
