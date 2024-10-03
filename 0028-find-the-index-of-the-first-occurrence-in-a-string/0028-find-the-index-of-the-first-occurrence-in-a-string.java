class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0; // Edge case: empty needle
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int j = 0;
            // Compare the substring of haystack with the needle
            while (j < needleLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needleLen) {
                return i; // Found the needle starting at index i
            }
        }
        
        return -1; // Needle not found
    }
}
