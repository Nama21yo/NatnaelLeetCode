class Solution {
    public String simplifyPath(String path) {
        // Split the input path by "/" to get individual tokens
        // "+": This ensures it handles multiple consecutive slashes
        String[] tokens = path.split("/+");
        
        // Use a stack to manage the tokens and simplify the path
        Stack<String> stack = new Stack<>();
        
        // Iterate through each token
        for(String t : tokens) {
            // If the token is "..", pop from the stack if it's not empty
            // This means going back to the parent directory
            if ("..".equals(t)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            // If the token is neither empty string nor ".", push it onto the stack
            // Empty string: This handles cases like multiple slashes
            // ".": This means current directory, so we ignore it
            } else if (!t.isEmpty() && !".".equals(t)) {
                stack.push(t);
            }
        }
        
        // Use a StringBuilder to construct the simplified path
        StringBuilder sb = new StringBuilder();
        // Iterate through each element in the stack and append it to the result path
        for (String s : stack) {
            sb.append("/").append(s);
        }
        
        // If the StringBuilder is empty, it means the path was root or it reduced to root
        // Return "/", otherwise return the constructed path
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
