class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int lastSeen[] = new int[3];
        int count = 0;
        
        while(right < s.length()) {
            lastSeen[s.charAt(right) - 'a']++;
           
            while(lastSeen[0] > 0 && lastSeen[1] > 0 && lastSeen[2] > 0) {
                count += (s.length() - right);
                lastSeen[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return count;
    }
}