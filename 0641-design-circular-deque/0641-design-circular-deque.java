class MyCircularDeque {
    int[] q;
    int front;
    int rear;
    int size;
    
    public MyCircularDeque(int k) {
        q = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            front = rear = 0;
            q[front] = value;
            size++;
            return true;
        }
        front = (front - 1 + q.length) % q.length;
        q[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % q.length;
        q[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        q[front] = -1;
        front = (front + 1) % q.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        q[rear] = -1;
        rear = (rear - 1 + q.length) % q.length;
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : q[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : q[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
