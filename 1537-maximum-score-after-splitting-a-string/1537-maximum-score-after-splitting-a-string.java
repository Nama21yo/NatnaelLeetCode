class Solution {
    public int maxScore(String s) {
        int right_zero = 0;
        int right_one = 0;
        int left_zero = 0;
        int left_one = 0;
        for(int i = 0; i < s.length();  i++) {
            if(s.charAt(i) == '0') {
                right_zero++; // 2
            } else {
                right_one++; // 3
            }
        }

        int answer = Integer.MIN_VALUE;
        //don't consider the last portion
        for(int i = 0;i<s.length() - 1;i++) {
            if(s.charAt(i) == '0') {
                left_zero++; //1 2
                right_zero--;//1 0
            } else {
                right_one--;//3 2 1
                left_one++;// 1 2 3
            }
            
            answer = Math.max(answer, left_zero + right_one);
        }

        return answer;
    }
}