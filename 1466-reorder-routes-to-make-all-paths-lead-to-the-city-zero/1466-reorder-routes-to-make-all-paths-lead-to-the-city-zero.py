class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        edges = {(a, b) for a,b in connections}
        neighbours = {city : [] for city in range(n)}
        visited = set()
        changes = 0

        for a, b in connections:
            neighbours[a].append(b)
            neighbours[b].append(a)

        
        def dfs(city):
            nonlocal edges, neighbours, visited, changes

            for neigh in neighbours[city]:
                if neigh in visited:
                    continue
                
                if (neigh, city) not in edges:
                    changes += 1
                
                visited.add(neigh)
                dfs(neigh)
        visited.add(0)
        dfs(0)
        return changes