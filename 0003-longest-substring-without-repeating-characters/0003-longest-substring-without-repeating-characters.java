class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store the last position of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0, right = 0; // Two pointers for the sliding window
        int n = s.length(); // Length of the input string
        int len = 0; // Variable to store the length of the longest substring
        
        // Iterate through the string
        while (right < n) {
            char currentChar = s.charAt(right); // Get the current character
            
            // If the character is already in the map, move the left pointer
            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            }
            
            // Update the last position of the current character in the map
            map.put(currentChar, right);
            
            // Calculate the length of the current substring and update the maximum length
            len = Math.max(len, right - left + 1);
            
            // Move the right pointer
            right++;
        }
        
        return len; // Return the length of the longest substring
    }
}
