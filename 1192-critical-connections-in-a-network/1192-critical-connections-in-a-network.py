class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        graph = defaultdict(list)

        for u,v in connections:
            graph[u].append(v)
            graph[v].append(u)
        

        tin = [-1] * n
        low = [-1] * n
        visited = set()
        self.timer = 0
        bridges = []

        def dfs(node, parent):
            visited.add(node)
            low[node] = tin[node] = self.timer
            self.timer += 1

            for neigh in graph[node]:
                # parent isn't a back edge
                if neigh == parent:
                    continue
                
                if neigh in visited:
                    # back-edge
                    low[node] = min(low[node], tin[neigh])
                else:
                    dfs(neigh, node)
                    low[node] = min(low[node], low[neigh])

                    # bridge condition
                    if low[neigh] > tin[node]:
                        bridges.append([node, neigh])
        
        for i in range(n):
            if i not in visited:
                dfs(i, -1)
        
        return bridges