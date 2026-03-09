class DataStream:
    def __init__(self, value: int, k: int):
        self.streak = 0
        self.value = value
        self.window = k

    def consec(self, num: int) -> bool:
        # simulating a stream
        if num == self.value:
            self.streak += 1
        else:
            self.streak = 0
        
        return self.streak >= self.window
# value = 4
# k - check last k = 3
# [4]
# false
# [4,4]
# false
# [4,4,4]
# true

# [4,4,4,3] -> remove from the left until we get the last k elements
# k = 3 size = 4
# size == k
# popleft
# [4,4,3]

# [4,4,3] last 3 elements
# false

# Your DataStream object will be instantiated and called as such:
# obj = DataStream(value, k)
# param_1 = obj.consec(num)