class Solution {
    public boolean isAnagram(String s, String t) {
        // If the lengths of the two strings are not the same, they cannot be anagrams
        if (s.length() != t.length()) return false;
        
        // Create an array to count the frequency of each character
        int[] count = new int[26];
        
        // Iterate over the strings
        for (int i = 0; i < s.length(); i++) {
            // Increment the count for the character in string `s`
            count[s.charAt(i) - 'a']++;
            // Decrement the count for the character in string `t`
            count[t.charAt(i) - 'a']--;
        }
        
        // Check if all counts are zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        
        // If all counts are zero, then the strings are anagrams
        return true;
    }
}
