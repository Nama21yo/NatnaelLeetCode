public class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are different
        if (s.length() != goal.length()) {
            return false;
        }

        String toGoal = s + s; // Concatenate s with itself
        return KMPSearch(goal, toGoal); // Check if goal is a substring of toGoal
    }

    // KMP search function to check if `pattern` exists in `text`
    private boolean KMPSearch(String pattern, String text) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = new int[m];

        computeLPSArray(pattern, m, lps); // Preprocess the pattern

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return true; // Pattern found in text
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false; // Pattern not found
    }

    // Function to compute the LPS (Longest Prefix Suffix) array
    private void computeLPSArray(String pattern, int m, int[] lps) {
        int i = 0; // Length of previous longest prefix suffix
        int j = 1; // Start from the second character

        lps[0] = 0; // LPS[0] is always 0

        while (j < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
    }
}
