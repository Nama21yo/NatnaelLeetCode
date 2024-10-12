class Solution {
    public String reverseWords(String s) {
        // Step 1: Remove leading, trailing, and extra spaces
        s = trimSpaces(s);
        
        // Step 2: Convert the string to a character array and reverse the entire string
        char[] words = s.toCharArray();
        int n = words.length;
        reverse(words, 0, n - 1);

        // Step 3: Reverse each word in the reversed string
        int p1 = 0;
        while (p1 < n) {
            int p2 = p1;
            while (p2 < n && words[p2] != ' ') {
                p2++;
            }
            reverse(words, p1, p2 - 1);
            p1 = p2 + 1;
        }

        return new String(words);
    }

    // Helper method to reverse a portion of the character array
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    // Helper method to trim spaces: remove leading, trailing and extra spaces
    private String trimSpaces(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Process characters and collapse multiple spaces
        while (i < n) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
            i++;
        }

        // Remove any trailing space
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
