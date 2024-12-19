class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        n = len(tickets)
        queue = deque(range(n))


        time = 0
        # Until my queue isn't empty
        while queue:
            time += 1
            id = queue.popleft()
            tickets[id] -= 1

            if id == k and tickets[id] == 0:
                return time
            if tickets[id] != 0:
                queue.append(id)
        return time