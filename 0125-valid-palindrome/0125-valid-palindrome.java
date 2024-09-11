class Solution {
    public boolean isPalindrome(String s) {
        // Clean up the string: ignore non-alphanumeric characters and make it lowercase
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        // Call the recursive helper function
        return checkpal(s, 0, s.length() - 1);
    }
    
    private boolean checkpal(String s, int start, int end) {
        // Base case: if the start index crosses the end index, it's a palindrome
        if (start >= end) return true;
        
        // Recursive case: check if characters at start and end are the same
        if (s.charAt(start) != s.charAt(end)) return false;
        
        // Recurse for the next characters
        return checkpal(s, start + 1, end - 1);
    }
}
