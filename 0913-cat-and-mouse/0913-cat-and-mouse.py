class Solution:
    def catMouseGame(self, graph: List[List[int]]) -> int:
        DRAW, MOUSE, CAT = 0, 1, 2
        
        n = len(graph)
        
        color = [[[DRAW] * 2 for _ in range(n)] for _ in range(n)]
        
        degree = [[[0] * 2 for _ in range(n)] for _ in range(n)]
        
        for m in range(n):
            for c in range(n):
                degree[m][c][0] = len(graph[m])  # mouse moves
                degree[m][c][1] = sum(1 for nxt in graph[c] if nxt != 0)

        q = deque()
        
        for c in range(n):
            for turn in range(2):
                color[0][c][turn] = MOUSE
                q.append((0, c, turn, MOUSE))
        
        for m in range(1, n):
            for turn in range(2):
                color[m][m][turn] = CAT
                q.append((m, m, turn, CAT))

        def parents(m, c, turn):
            if turn == 0:
                for pc in graph[c]:
                    if pc != 0:
                        yield (m, pc, 1)
            else:
                for pm in graph[m]:
                    yield (pm, c, 0)

        while q:
            m, c, turn, result = q.popleft()

            for pm, pc, pturn in parents(m, c, turn):
                if color[pm][pc][pturn] != DRAW:
                    continue

                if pturn == 0 and result == MOUSE:
                    color[pm][pc][pturn] = MOUSE
                    q.append((pm, pc, pturn, MOUSE))

                elif pturn == 1 and result == CAT:
                    color[pm][pc][pturn] = CAT
                    q.append((pm, pc, pturn, CAT))

                else:
                    degree[pm][pc][pturn] -= 1
                    if degree[pm][pc][pturn] == 0:
                        lose = CAT if pturn == 0 else MOUSE
                        color[pm][pc][pturn] = lose
                        q.append((pm, pc, pturn, lose))

        return color[1][2][0]
