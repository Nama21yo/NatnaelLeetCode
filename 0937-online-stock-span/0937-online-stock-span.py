class StockSpanner:

    def __init__(self):
        self.stack = [] # (pair, span)

    def next(self, price: int) -> int:
        span = 1 # first day
        while self.stack and self.stack[-1][0] <= price:
            span += self.stack.pop()[1] # the span
        self.stack.append((price, span))
        
        return span

        


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)