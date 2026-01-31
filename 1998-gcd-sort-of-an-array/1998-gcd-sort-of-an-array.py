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
            return
        if self.rank[px] < self.rank[py]:
            self.parent[px] = py
        elif self.rank[px] > self.rank[py]:
            self.parent[py] = px
        else:
            self.parent[py] = px
            self.rank[px] += 1


class Solution:
    def gcdSort(self, nums: List[int]) -> bool:
        n = len(nums)
        uf = UnionFind(n)

        prime_to_index = {}

        def prime_factors(x):
            f = 2
            while f * f <= x:
                if x % f == 0:
                    yield f
                    while x % f == 0:
                        x //= f
                f += 1
            if x > 1:
                yield x

        for i, val in enumerate(nums):
            for p in prime_factors(val):
                if p in prime_to_index:
                    uf.union(i, prime_to_index[p])
                else:
                    prime_to_index[p] = i

        components = {}
        for i in range(n):
            root = uf.find(i)
            components.setdefault(root, []).append(i)

        sorted_nums = sorted(nums)

        for indices in components.values():
            original_vals = sorted(nums[i] for i in indices)
            target_vals = sorted(sorted_nums[i] for i in indices)
            if original_vals != target_vals:
                return False

        return True
