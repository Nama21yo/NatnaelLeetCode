class Solution {
    public int maxScore(String s) {
        int zero_count = 0;
        int one_count = 0;
        
        for(int i = 0; i < s.length();  i++) {
            if(s.charAt(i) == '1') {
                one_count++;
            }
        }

        int answer = Integer.MIN_VALUE;
        //don't consider the last portion
        for(int i = 0;i<s.length() - 1;i++) {
            if(s.charAt(i) == '0') {
                zero_count++;
            }
            if(s.charAt(i) == '1') {
                one_count--;
            }
            answer = Math.max(answer, zero_count + one_count);
        }

        return answer;
    }
}