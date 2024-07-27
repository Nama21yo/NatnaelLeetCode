from collections import deque

class MyStack:
    def __init__(self):
        self.queue1 = deque()
        self.queue2 = deque()
        # Constructor initializes two queues
        # Time Complexity: O(1) - Initialization is a constant-time operation
        # Space Complexity: O(1) - Only two empty queues are initialized

    def push(self, x: int) -> None:
        self.queue1.append(x)
        # Add the new element to queue1
        # Time Complexity: O(1) - Adding an element to the queue is constant time
        # Space Complexity: O(1) - No additional space beyond the queues

    def pop(self) -> int:
        # Move all elements except the last one from queue1 to queue2
        while len(self.queue1) > 1:
            self.queue2.append(self.queue1.popleft())
        
        # The last element of queue1 is the top of the stack
        result = self.queue1.popleft()
        
        # Swap the names of queue1 and queue2
        self.queue1, self.queue2 = self.queue2, self.queue1
        
        return result
        # Time Complexity: O(n) - Moving elements between queues is O(n) in the worst case
        # Space Complexity: O(1) - No additional space beyond the queues

    def top(self) -> int:
        # Move all elements except the last one from queue1 to queue2
        while len(self.queue1) > 1:
            self.queue2.append(self.queue1.popleft())
        
        # The last element of queue1 is the top of the stack
        result = self.queue1.popleft()
        self.queue2.append(result)
        
        # Swap the names of queue1 and queue2
        self.queue1, self.queue2 = self.queue2, self.queue1
        
        return result
        # Time Complexity: O(n) - Moving elements between queues is O(n) in the worst case
        # Space Complexity: O(1) - No additional space beyond the queues

    def empty(self) -> bool:
        return not self.queue1
        # Time Complexity: O(1) - Checking if the queue is empty is constant time
        # Space Complexity: O(1) - No additional space beyond the queues

# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
