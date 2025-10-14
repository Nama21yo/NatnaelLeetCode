# Prim's doesn't work Modified Bellman-Ford (for up to k stops)
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dist = [float('inf')] * n
        dist[src] = 0
        
        # Relax edges up to k+1 times (since k stops = k+1 edges)
        for _ in range(k + 1):
            temp = dist.copy()
            for u, v, w in flights:
                if dist[u] != float('inf') and dist[u] + w < temp[v]:
                    temp[v] = dist[u] + w
            dist = temp
        
        return -1 if dist[dst] == float('inf') else dist[dst]
