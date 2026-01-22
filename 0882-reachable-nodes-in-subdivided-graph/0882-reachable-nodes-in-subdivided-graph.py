class Solution:
    def reachableNodes(self, edges: List[List[int]], maxMoves: int, n: int) -> int:
        graph = [[] for _ in range(n)]
        for u, v, cnt in edges:
            w = cnt + 1
            graph[u].append((v, w))
            graph[v].append((u, w))

        dist = [float("inf")] * n
        dist[0] = 0
        pq = [(0, 0)]  

        while pq:
            d, node = heapq.heappop(pq)
            if d > dist[node]:
                continue
            for nei, w in graph[node]:
                nd = d + w
                if nd < dist[nei]:
                    dist[nei] = nd
                    heapq.heappush(pq, (nd, nei))

        reachable = 0
        for i in range(n):
            if dist[i] <= maxMoves:
                reachable += 1

        for u, v, cnt in edges:
            a = max(0, maxMoves - dist[u])
            b = max(0, maxMoves - dist[v])
            reachable += min(cnt, a + b)

        return reachable
