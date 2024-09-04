class Solution {
    public int minStoneSum(int[] piles, int k) {
        // Max-Heap implemented using a PriorityQueue with negative values
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all piles to the max-heap
        for (int pile : piles) {
            maxHeap.add(pile);
        }
        
        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the largest pile
            int largest = maxHeap.poll();
            
            // Calculate the new pile size after removing half the stones
            int reduced = largest - largest / 2;
            
            // Add the reduced pile back into the heap
            maxHeap.add(reduced);
        }
        
        // Calculate the final sum of stones
        int totalStones = 0;
        while (!maxHeap.isEmpty()) {
            totalStones += maxHeap.poll();
        }
        
        return totalStones;
    }
}
