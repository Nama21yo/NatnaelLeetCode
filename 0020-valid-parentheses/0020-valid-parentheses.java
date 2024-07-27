class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // Push the corresponding closing bracket onto the stack for each opening bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                // If the stack is empty (no corresponding opening bracket) or the top of the stack
                // does not match the current closing bracket, return false
                return false;
            }
        }
        
        // If the stack is empty at the end, all opening brackets were properly closed
        return stack.isEmpty();
    }
}
