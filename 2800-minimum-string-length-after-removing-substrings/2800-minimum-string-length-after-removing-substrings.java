class Solution {
    public int minLength(String s) {
       Stack<Character> stack = new Stack<>();
        // O(n) time and O(n) space
        for (char c : s.toCharArray()) {
           if(c == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
           } else if(c == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
           } else {
                stack.push(c);
           }
        }
        
        return stack.size();
    }
}