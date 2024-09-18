class Solution {
    public String longestPalindrome(String s) {
        //using expanding technique
        int left = 0;
        int right  = 0;

        String maxStr = s.substring(0,1);
        for(int i = 0; i < s.length();i++) {
            String odd = expand(s,i,i);
            String even = expand(s,i,i+1);

            if(odd.length() > maxStr.length()){
                maxStr = odd;
            }

            if(even.length() > maxStr.length()) {
                maxStr = even;
            }
            
        }
     
        return maxStr;
    }
    private String expand(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1,end);
    }
}