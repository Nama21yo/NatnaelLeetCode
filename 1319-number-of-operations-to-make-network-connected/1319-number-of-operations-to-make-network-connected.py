class UnionFind:
    def __init__(self, size):
        self.parent = [i for i in range(size)]
        self.rank = [0] * size
        self.size = [0] * size

    def find(self, x):
        if x == self.parent[x]:
            return self.parent[x]
        # path compression
        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def unionByRank(self, x, y):
        parentx , parenty = self.find(x), self.find(y)

        if parentx == parenty:
            return False
        
        rankx = self.rank[parentx]
        ranky = self.rank[parenty]

        if rankx > ranky:
            self.parent[parenty] = parentx
        elif rankx < ranky:
            self.parent[parentx] = parenty
        else:
            self.parent[parenty] = parentx
            self.rank[parentx] += 1
        return True
    def unionBySize(self, x, y):
        parentx , parenty = self.find(x), self.find(y)

        if parentx == parenty:
            return False
        if self.size[parentx] > self.size[parenty]:
            self.parent[parenty] = parentx
            self.size[parentx] += self.size[parenty]
        else:
            self.parent[parentx] = parenty
            self.size[parenty] += self.size[parentx]
        return True
class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n - 1:
            return -1 # not enough edges to connect
        uf = UnionFind(n)

        extra_edges = 0
        for u, v in connections:
            if uf.unionByRank(u,v):
                extra_edges += 1
        
         # To connect all nodes, we need at least `n-1` edges. 
        # extra_edges tells us how many extra edges we used to reduce the number of components.
        # After processing, we check how many disconnected components remain.
        
        # The number of components = total nodes - number of successful unions.

        components = sum(1 for i in range(n) if uf.find(i) == i)
       
        needed_edges = components - 1
        
        return needed_edges if extra_edges >= needed_edges else -1
        