class Solution {
    public boolean isPowerOfThree(int n) {
        // Check if n is less than 1, in which case it cannot be a power of three
        if (n < 1) {
            return false;
        }
        // Using the properties of logarithms to determine if n is a power of three
        // log3(n) = log10(n) / log10(3)
        // If the result is an integer, then n is a power of three
        double logResult = Math.log10(n) / Math.log10(3);
        // Check if the result is an integer by seeing if the modulo 1 is 0
        return logResult % 1 == 0;
    }
}
