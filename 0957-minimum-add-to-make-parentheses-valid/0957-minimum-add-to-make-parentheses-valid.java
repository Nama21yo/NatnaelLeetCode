class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 1) return 1;
        if(s.length() == 0) return 0;
        Stack<Character> open = new Stack<>();
        // wrong answer- "))(("
        int imbalance_count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open.push(c);
            } else {
                if(!open.isEmpty() && open.peek() == '(') {
                    open.pop();
                } else {
                    imbalance_count++;
                }
            }
        }   

        return imbalance_count + open.size();
    }
}