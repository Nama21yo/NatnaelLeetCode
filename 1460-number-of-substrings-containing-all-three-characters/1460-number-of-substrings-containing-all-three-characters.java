class Solution {
    public int numberOfSubstrings(String s) {
      
        int right = 0;
        int lastSeen[] = {-1,-1,-1};
        int count = 0;
        
        while(right < s.length()) {
            lastSeen[s.charAt(right) - 'a'] = right;
           
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]);
            }
            right++;
        }

        return count;
    }
}