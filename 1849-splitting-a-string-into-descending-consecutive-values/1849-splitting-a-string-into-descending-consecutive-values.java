class Solution {
    public boolean splitString(String s) {
        // Start the helper function with the entire string and an initial parent value of -1
        return helper(s, -1);
    }
    
    private boolean helper(String s, long parent) {
        // Base case: if the string is empty, return true
        if (s.length() == 0) return true;
        
        // Initialize the current number as 0
        long current = 0;
        
        // Iterate through the string to form numbers
        for (int i = 0; i < s.length(); i++) {
            // Construct the current number by appending the current digit
            current = current * 10 + s.charAt(i) - '0';
            
            // Check if it's the initial call or the difference between parent and current is 1
            if ((i != s.length() - 1 && parent == -1) || parent - current == 1) {
                // Check if the remaining string can be split into a descending sequence
                if (helper(s.substring(i + 1), current)) return true;
            }
        }
        
        // If no valid split is found, return false
        return false;
    }
}
