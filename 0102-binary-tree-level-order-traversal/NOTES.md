**Pseudocode**:
Initialize a queue and a result list.
If the root is null, return the empty result list.
Add the root node to the queue.
While the queue is not empty:
Get the number of nodes at the current level (levelNum).
Initialize a list (subList) to hold the values of nodes at the current level.
For each node at the current level:
If the node has a left child, add it to the queue.
If the node has a right child, add it to the queue.
Add the node's value to subList and remove the node from the queue.
Add subList to the result list.
Return the result list.