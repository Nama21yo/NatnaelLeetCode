class Solution {
    public double myPow(double x, int n) {
        double finalAnswer = 1.0; // Variable to store the final result
        long powerOf = n; // Use a long to handle the edge case of n being Integer.MIN_VALUE

        // If the power is negative, convert it to positive for easier calculation
        if (powerOf < 0) {
            powerOf = -1 * powerOf;
        }

        // Loop until all bits of the power have been processed
        while (powerOf > 0) {
            // If the current power is even
            if (powerOf % 2 == 0) {
                x = x * x; // Square the base
                powerOf = powerOf / 2; // Halve the power
            } else { // If the current power is odd
                finalAnswer = finalAnswer * x; // Multiply the result by the base
                powerOf = powerOf - 1; // Decrement the power by 1
            }
        }

        // If the original power was negative, invert the result
        if (n < 0) {
            finalAnswer = 1.0 / finalAnswer;
        }
        return finalAnswer; // Return the final result
    }
}
