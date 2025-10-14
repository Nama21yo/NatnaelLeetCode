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

        if parentx != parenty:
            rankx = self.rank[parentx]
            ranky = self.rank[parenty]

            if rankx > ranky:
                self.parent[parenty] = parentx
            elif rankx < ranky:
                self.parent[parentx] = parenty
            else:
                self.parent[parenty] = parentx
                self.rank[parentx] += 1
    def unionBySize(self, x, y):
        parentx , parenty = self.find(x), self.find(y)

        if parentx != parenty:
            if self.size[parentx] > self.size[parenty]:
                self.parent[parenty] = parentx
                self.size[parentx] += self.size[parenty]
            else:
                self.parent[parentx] = parenty
                self.size[parenty] += self.size[parentx]
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        uf = UnionFind(n)
        num_comp = n

        for i in range(n):
            for j in range(i , n):
                if isConnected[i][j] and (uf.find(i) != uf.find(j)):
                    num_comp -= 1
                    uf.unionByRank(i, j)
        return num_comp