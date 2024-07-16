class Solution {
    public String reverseVowels(String s) {
        // Convert the input string to a character array for in-place modifications
        char[] chars = s.toCharArray();
        
        // Initialize two pointers, one at the start and one at the end of the array
        int left = 0;
        int right = s.length() - 1;
        
        // Iterate until the two pointers meet
        while (left < right) {
            // Move the left pointer to the right until a vowel is found
            if (!isVowel(chars[left])) {
                left++;
            // Move the right pointer to the left until a vowel is found
            } else if (!isVowel(chars[right])) {
                right--;
            // If both pointers are at vowels, swap the vowels
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                // Move both pointers towards the center
                left++;
                right--;
            }
        }
        // Convert the character array back to a string and return it
        return new String(chars);
    }
    
    // Helper method to check if a character is a vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
