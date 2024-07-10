class Solution {
    public int myAtoi(String str) {
        // Initialize result and index, determine the length of the string
        int result = 0;
        int i = 0;
        int sign = 1;
        int len = str.length();

        // Step 1: Discard all leading whitespaces
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for optional sign
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to number
        while (i < len && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';

            // Step 4: Check for overflow and underflow conditions
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Step 5: Update result
            result = result * 10 + digit;
            i++;
        }

        // Step 6: Apply sign to result
        return result * sign;
    }
}
