class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] char_count = new int[26];  // Array to count occurrences of each character
        
        int window_start = 0;
        int max_length = 0;
        int max_count = 0;  // Maximum count of a single character in the current window
        
        for (int window_end = 0; window_end < N; window_end++) {
            char_count[s.charAt(window_end) - 'A']++;  // Increment count of the current character
            int current_char_count = char_count[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);  // Update max_count
            
            // Check if the current window is valid
            while (window_end - window_start + 1 - max_count > k) {
                char_count[s.charAt(window_start) - 'A']--;  // Decrement count of the character at window_start
                window_start++;  // Move window_start to the right
            }
            
            max_length = Math.max(max_length, window_end - window_start + 1);  // Update max_length
        }
        
        return max_length;  // Return the maximum length found
    }
}
