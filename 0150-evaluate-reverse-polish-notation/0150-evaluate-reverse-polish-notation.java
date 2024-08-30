class Solution {
    public int evalRPN(String[] tokens) {
        // Create a stack to store the operands
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over each token in the tokens array
        for (String token : tokens) {
            // If the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop the top two operands from the stack
                int b = stack.pop();
                int a = stack.pop();
                
                // Perform the operation based on the operator
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                // If the token is a number, push it onto the stack
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The final result is the only element left in the stack
        return stack.pop();
    }
}
