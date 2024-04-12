class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Add one to the last digit
        digits[n - 1]++;//10
        
        // Check for carry
        int carry = digits[n - 1] / 10;//1
        digits[n - 1] %= 10;//0
        
        // Iterate from the second last digit to the first
        for (int i = n - 2; i >= 0 && carry > 0; i--) {
            digits[i] += carry;//12
            carry = digits[i] / 10;//00
            digits[i] %= 10;//123456789
        }
        
        // If there is still a carry, we need to increase the size of the array
        if (carry > 0) {
            int[] result = new int[n + 1];
            result[0] = carry;
            for (int i = 0; i < n; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }
    }
}
