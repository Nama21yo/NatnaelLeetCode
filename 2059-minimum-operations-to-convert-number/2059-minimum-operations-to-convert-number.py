
class Solution:
    def minimumOperations(self, nums: List[int], start: int, goal: int) -> int:
        q = deque()
        q.append((start, 0))
        visited = set()
        visited.add(start)

        while q:
            curr, steps = q.popleft()

            # If we reached goal, return steps
            if curr == goal:
                return steps

            for num in nums:
                for nxt in (curr + num, curr - num, curr ^ num):
                    # If next is goal, return immediately
                    if nxt == goal:
                        return steps + 1

                    # Only explore valid range
                    if 0 <= nxt <= 1000 and nxt not in visited:
                        visited.add(nxt)
                        q.append((nxt, steps + 1))

        return -1
