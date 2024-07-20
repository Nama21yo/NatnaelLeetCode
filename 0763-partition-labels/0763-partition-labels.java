class Solution {
    public List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();
        
        // Create a map to store the last occurrence of each character
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < str.length(); i++) {
            lastOccurrence[str.charAt(i) - 'a'] = i;
        }
        
        int startIndex = 0;
        int endIndex = 0;
        
        // Iterate through the string to determine the partitions
        for (int i = 0; i < str.length(); i++) {
            // Update the endIndex to the farthest last occurrence of the character
            endIndex = Math.max(endIndex, lastOccurrence[str.charAt(i) - 'a']);
            
            // If the current index reaches the endIndex, we have found a partition
            if (i == endIndex) {
                partitions.add(endIndex - startIndex + 1);
                startIndex = i + 1;
            }
        }
        
        return partitions;
    }
}
