class Solution {
    public int scoreOfParentheses(String s) {
        // Initialize the count to accumulate the total score
        int count = 0;
        // Stack to store intermediate scores
        Stack<Integer> st = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is '(', push 0 onto the stack
            if (c == '(') {
                st.push(0);
            } else {
                // If the character is ')', calculate the score
                int val = 0;
                // Pop from the stack and accumulate the score until encountering a 0
                while (st.peek() != 0) {
                    val += st.pop();
                }
            // Pop the 0 which represents '(' and calculate the score for the balanced pair
                st.pop();
                // If val is 0, it means we encountered '()', so the score is 1
                // Otherwise, the score is 2 * val for nested parentheses
                val = Math.max(2 * val, 1);
                // Push the calculated score back onto the stack
                st.push(val);
            }
        }
        
        // Sum up all the values in the stack to get the final score
        while (!st.isEmpty()) {
            count += st.pop();
        }
        
        return count;
    }
}
