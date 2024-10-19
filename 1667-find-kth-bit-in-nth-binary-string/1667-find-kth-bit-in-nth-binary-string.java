class Solution {
    // O(n) time with O(n) space
    public char findKthBit(int n, int k) {
        boolean invert = false;
        // Correct length calculation: 2^n - 1
        int length = (int)(Math.pow(2, n)) - 1;

        return helper(length, k, invert);
    }

    private char helper(int length, int k, boolean invert) {
        // base case
        if (length == 1) {
            return !invert ? '0' : '1';
        }

        int half = length / 2;

        // the left part
        if (k <= half) {
            return helper(half, k, invert);
        } else if (k > half + 1) {
            // the right part (mirrored and inverted)
            return helper(half, (length - k) + 1, !invert);
        } else { // the middle part
            return !invert ? '1' : '0';
        }
    }
}
