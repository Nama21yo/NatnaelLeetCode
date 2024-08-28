class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Create an array of lists (bucket) to group numbers by frequency
        List<Integer>[] bucket = new List[nums.length + 1];
        
        // Step 2: Create a frequency map to count occurrences of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        
        // Step 3: Populate the bucket array where the index represents the frequency
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        // Step 4: Collect the top k frequent elements from the bucket
        int[] res = new int[k];
        int counter = 0;
        
        // Traverse the bucket array from the end to the beginning
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (Integer integer : bucket[pos]) {
                    res[counter++] = integer;
                }
            }
        }
        
        return res;
    }
}
