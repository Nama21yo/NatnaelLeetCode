class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 1) return 1;
        if(s.length() == 0) return 0;
        Stack<Character> open = new Stack<>();
        // wrong answer- "))(("
        int min_moves = s.length();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open.push(c);
            } else {
                if(!open.isEmpty() && open.peek() == '(') {
                    min_moves -= 2;
                    open.pop();
                }
            }
        }   

        return min_moves;
    }
}