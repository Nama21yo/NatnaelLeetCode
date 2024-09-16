class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Array to store the last seen index of each character (256 for extended ASCII)
        int[] lastSeen = new int[256]; // Initialize an array for 256 ASCII characters
        // Initialize all values to -1 since none of the characters have been seen
        for (int i = 0; i < 256; i++) {
            lastSeen[i] = -1;
        }
        
        int left = 0;  // Left pointer for the sliding window
        int maxLen = 0;  // Variable to store the length of the longest substring
        
        // Iterate through the string using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right); // Get the current character's ASCII value
            
            // Move the left pointer if the current character was already seen
            if (lastSeen[currentChar] != -1) {
                left = Math.max(lastSeen[currentChar] + 1, left);
            }
            
            // Update the last seen position of the current character
            lastSeen[currentChar] = right; //lastSeen['a'/97] = 0
            
            // Calculate the length of the current substring and update the max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;  // Return the length of the longest substring without repeating characters
    }
}
