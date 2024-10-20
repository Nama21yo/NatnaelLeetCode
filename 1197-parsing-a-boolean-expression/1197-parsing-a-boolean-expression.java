class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        char temp = ' ';

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == ',') continue; // Skip '(' and ','

            // Push 't', 'f', '!', '&', '|' into the stack
            if (ch == 't' || ch == 'f' || ch == '!' || ch == '&' || ch == '|') {
                st.push(ch);
            } 
            // Process when encountering a closing parenthesis ')'
            else if (ch == ')') {
                boolean hasTrue = false;
                boolean hasFalse = false;

                // Pop boolean values inside the parentheses until reaching the operator
                while (!st.isEmpty() && (st.peek() == 't' || st.peek() == 'f')) {
                    char val = st.pop();
                    if (val == 't') hasTrue = true;
                    if (val == 'f') hasFalse = true;
                }

                // Pop the operator ('!', '&', or '|') if stack is not empty
                if (!st.isEmpty()) {
                    char operator = st.pop();

                    // Evaluate the result based on the operator
                    if (operator == '|') {
                        temp = hasTrue ? 't' : 'f';  // OR operation
                    } else if (operator == '&') {
                        temp = hasFalse ? 'f' : 't';  // AND operation
                    } else if (operator == '!') {
                        temp = hasTrue ? 'f' : 't';  // NOT operation
                    }

                    // Push the evaluated result back onto the stack
                    st.push(temp);
                }
            }
        }

        // The final result is at the top of the stack, if the stack is not empty
        return !st.isEmpty() && st.peek() == 't';
    }
}
