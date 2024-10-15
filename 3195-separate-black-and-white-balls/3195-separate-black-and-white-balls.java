class Solution {
    public long minimumSteps(String s) {
        long min_swap = 0;

        int l = 0;
        for(int r = 0; r < s.length(); ++r) {
            if(s.charAt(r) == '0') {
                min_swap += (r - l);
                l++;
            }
        }

        return min_swap;
    }
}
