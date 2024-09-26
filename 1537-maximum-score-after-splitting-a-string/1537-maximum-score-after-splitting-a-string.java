class Solution {
    public int maxScore(String s) {
        //brute force
        int n = s.length();
        int answer = Integer.MIN_VALUE;
        //split line iteration
        for(int i = 0; i < n - 1; i++) {
        //zero count iteration
            int zero_count = 0;
            for(int j = 0; j <= i; j++) {
                if(s.charAt(j) == '0'){
                    zero_count++;
                }
            }
        // one count iteration
            int one_count = 0;
            for(int j = i+1;j< n;j++) {
                if(s.charAt(j) == '1'){
                    one_count++;
                }
            }

            answer = Math.max(answer, zero_count + one_count);
        }

        return answer;

    }
}