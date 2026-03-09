class RecentCounter:
    def __init__(self):
        self.queue = deque()

    def ping(self, t: int) -> int:
        self.queue.append(t)

        minimum = t - 3000

        while self.queue and self.queue[0] < minimum:
            self.queue.popleft()
        
        return len(self.queue)

# [1, 100, 3001, 3002]

# t - 3000 -> remove them from left

# 1
# t - 3000, t
# -2999, 1 -> 1

# 100
# -2900, 100 -> 2

# 3001
# 1 , 3001 -> 3

# 3002
# 2, 3002 -> 3


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)