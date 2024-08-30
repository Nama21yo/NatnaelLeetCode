
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // HashMap to store the frequency of mod values
        Map<Integer, Integer> modCount = new HashMap<>();
        modCount.put(0, 1); // Initialize with 0 mod and frequency 1
        
        int cumulativeSum = 0;
        int result = 0;
        
        for (int num : nums) {
            // Update the cumulative sum
            cumulativeSum += num;
            
            // Compute mod with k
            int mod = cumulativeSum % k;
            
            // Handle negative mods by converting them to positive equivalent
            if (mod < 0) {
                mod += k;
            }
            
            // If this mod has been seen before, add its frequency to the result
            if (modCount.containsKey(mod)) {
                result += modCount.get(mod);
            }
            
            // Update the frequency of the current mod in the hashmap
            modCount.put(mod, modCount.getOrDefault(mod, 0) + 1);
        }
        
        return result;
    }
}
