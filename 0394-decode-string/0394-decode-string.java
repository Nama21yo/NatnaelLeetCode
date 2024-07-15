class Solution {
    int i = 0;  // Initialize a class-level index variable

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();  // Create a StringBuilder to store the result

        // Iterate through the string until the end or until a closing bracket is encountered
        while (i < s.length() && s.charAt(i) != ']') {
            if (Character.isDigit(s.charAt(i))) {  // Check if the current character is a digit
                int k = 0;  // Initialize a variable to store the number (k)
                // Build the number (k) by iterating through the digits
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    k = k * 10 + s.charAt(i++) - '0';  // Update k and increment the index
                }
                i++;  // Skip the opening bracket '['
                String r = decodeString(s);  // Recursively decode the substring inside the brackets
                // Append the decoded substring 'k' times to the result
                while (k-- > 0) {
                    result.append(r);
                }
                i++;  // Skip the closing bracket ']'
            } else {
                // If the current character is not a digit, append it to the result
                result.append(s.charAt(i++));
            }
        }

        return result.toString();  // Convert the StringBuilder to a String and return it
    }
}
