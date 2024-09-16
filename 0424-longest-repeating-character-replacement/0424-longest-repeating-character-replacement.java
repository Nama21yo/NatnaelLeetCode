class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> countChar = new HashMap<>();
        int left = 0, maxLen = 0, maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            // Count the frequency of the current character
            countChar.put(s.charAt(right), countChar.getOrDefault(s.charAt(right), 0) + 1);
            // Track the frequency of the most frequent character in the window
            maxFreq = Math.max(maxFreq, countChar.get(s.charAt(right)));

            // If the current window size minus the most frequent character's count is greater than k, shrink the window
            if ((right - left + 1) - maxFreq > k) {
                countChar.put(s.charAt(left), countChar.get(s.charAt(left)) - 1);
                left++;
            }

            // Update the maximum length of the valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
