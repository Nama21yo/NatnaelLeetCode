class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // If k equals the length of the array, all elements are the answer
        if (k == nums.length) return nums;
        
        // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        // Step 2: Use a PriorityQueue (min-heap) to find the top k frequent elements
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );
        
        // Step 3: Maintain a heap of size k
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent element
            }
        }
        
        // Step 4: Extract the elements from the heap into an array
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        
        return ans;
    }
}
