class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
        // Constructor initializes the queue
        // Time Complexity: O(1) - Initialization is a constant-time operation
        // Space Complexity: O(1) - Only an empty queue is initialized
    }
    
    public void push(int x) {
        queue.add(x);
        // Add the new element to the queue
        // Time Complexity: O(1) for adding an element to the queue
        
        // Move all elements behind the new element to the back of the queue
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
            // Time Complexity: O(n) for rearranging elements, where n is the size of the queue
        }
        
        // Overall Time Complexity: O(n) for push operation due to reordering
        // Space Complexity: O(1) - No additional space beyond the queue
    }
    
    public int pop() {
        // Remove the front element which represents the top of the stack
        // Time Complexity: O(1) - Removing an element from the front of the queue is constant time
        return queue.remove();
    }
    
    public int top() {
        // Peek at the front element which represents the top of the stack
        // Time Complexity: O(1) - Accessing the front of the queue is constant time
        return queue.peek();
    }
    
    public boolean empty() {
        // Check if the queue is empty
        // Time Complexity: O(1) - Checking if the queue is empty is constant time
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
