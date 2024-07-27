class MyLinkedList {
    // Definition for singly-linked list node
    class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
        }
    }
    
    // Head of the linked list
    private Node head;
    
    // Initialize your data structure here.
    public MyLinkedList() {
        head = null;
    }
    
    // Get the value of the index-th node in the linked list. If the index is invalid, return -1.
    public int get(int index) {
        Node current = head;
        for (int i = 0; current != null && i < index; i++) {
            current = current.next;
        }
        return (current != null) ? current.val : -1;
    }
    
    // Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    
    // Append a node of value val to the last element of the linked list.
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        
        if (current == null) {
            return;
        }
        
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }
    
    // Delete the index-th node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if (index == 0 && head != null) {
            head = head.next;
            return;
        }
        
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        
        if (current == null || current.next == null) {
            return;
        }
        
        current.next = current.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
