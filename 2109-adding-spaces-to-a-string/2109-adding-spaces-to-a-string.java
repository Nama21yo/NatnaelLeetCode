class Solution {
    public String addSpaces(String s, int[] spaces) {
        // Create a new character array to store the result
        char[] cstr = new char[s.length() + spaces.length];
        
        int i = 0; // Index for spaces array
        int j = 0; // Index for original string s
        int k = 0; // Index for new character array cstr
        
        while (i < spaces.length && j < s.length()) {
            int insertionIndex = spaces[i]; // Index to insert space
            
            // Copy characters from original string to new array until insertion index
            while (j < insertionIndex && j < s.length()) {
                cstr[k++] = s.charAt(j++);
            }
            
            // Insert space at the insertion index
            cstr[k++] = ' ';
            i++;
        }
        
        // Copy remaining characters from original string to new array
        while (j < s.length()) {
            cstr[k++] = s.charAt(j++);
        }
        
        return new String(cstr);
    }
}
