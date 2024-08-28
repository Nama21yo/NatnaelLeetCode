class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Return an empty list if the input array is empty
        if (strs.length == 0) return new ArrayList<>();
        
        // A HashMap to store the grouped anagrams
        Map<String, List<String>> ansMap = new HashMap<>();
        
        int[] count = new int[26]; // Array to store character counts
        
        // Iterate over each string in the input array
        for (String s : strs) {
            Arrays.fill(count, 0); // Reset the count array for each string
            
            // Count the frequency of each character in the string
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Build a unique key using the counts
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString(); // Convert StringBuilder to a string to use as the key
            
            // If the key does not exist in the map, create a new entry
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());
            }
            
            // Add the string to the corresponding list in the map
            ansMap.get(key).add(s);
        }
        
        // Return the values of the map as a list of lists
        return new ArrayList<>(ansMap.values());
    }
}
