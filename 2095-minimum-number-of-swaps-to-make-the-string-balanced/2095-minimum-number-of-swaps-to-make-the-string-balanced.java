class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int misMatched = 0;
        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {

                stack.pop();
                } else {
                    misMatched++;
                }
            }
        }
        return (misMatched + 1 ) / 2;

    }
}