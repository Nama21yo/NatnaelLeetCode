Time Complexity:
Constructor (MyCircularDeque):
​
Time Complexity: O(k) where k is the capacity of the deque, due to the Arrays.fill(q, -1) operation which initializes the array.
Space Complexity: O(k) for storing the deque elements.
Insert Front (insertFront):
​
Time Complexity: O(1) because inserting at the front involves simple pointer arithmetic and a single assignment.
Space Complexity: O(1) since no additional space is required beyond the internal array.
Insert Last (insertLast):
​
Time Complexity: O(1) because inserting at the rear involves simple pointer arithmetic and a single assignment.
Space Complexity: O(1) since no additional space is required beyond the internal array.
Delete Front (deleteFront):
​
Time Complexity: O(1) because deleting from the front involves simple pointer arithmetic and a single assignment.
Space Complexity: O(1) since no additional space is required beyond the internal array.
Delete Last (deleteLast):
​
Time Complexity: O(1) because deleting from the rear involves simple pointer arithmetic and a single assignment.
Space Complexity: O(1) since no additional space is required beyond the internal array.
Get Front (getFront):
​
Time Complexity: O(1) because retrieving the front element is a single array access.
Space Complexity: O(1) since no additional space is required.
Get Rear (getRear):
​
Time Complexity: O(1) because retrieving the rear element is a single array access.
Space Complexity: O(1) since no additional space is required.
Is Empty (isEmpty):
​
Time Complexity: O(1) because it only checks the size variable.
Space Complexity: O(1) since no additional space is required.
Is Full (isFull):
​
Time Complexity: O(1) because it only checks the size variable.
Space Complexity: O(1) since no additional space is required.
Summary:
Overall Time Complexity: Each method operates in constant time O(1).
Overall Space Complexity: The space complexity is O(k), where k is the capacity of the deque, because we are using a fixed-size array to store the elements of the deque.