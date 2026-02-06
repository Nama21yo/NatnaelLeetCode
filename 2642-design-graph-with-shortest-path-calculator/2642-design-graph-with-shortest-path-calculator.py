class Graph:
    def __init__(self, n: int, edges: List[List[int]]):
        self.n = n
        self.graph = [[] for _ in range(n)]
        
        for u, v, w in edges:
            self.graph[u].append((v, w))

    def addEdge(self, edge: List[int]) -> None:
        u, v, w = edge
        self.graph[u].append((v, w))

    def shortestPath(self, node1: int, node2: int) -> int:
        dist = [float("inf")] * self.n
        dist[node1] = 0
        
        pq = [(0, node1)]  
        while pq:
            d, node = heapq.heappop(pq)
            
            if node == node2:
                return d
            
            if d > dist[node]:
                continue
            
            for nei, w in self.graph[node]:
                newDist = d + w
                if newDist < dist[nei]:
                    dist[nei] = newDist
                    heapq.heappush(pq, (newDist, nei))
        
        return -1
