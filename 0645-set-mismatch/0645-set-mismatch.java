class Solution {
    public int[] findErrorNums(int[] arr) {
        
         long N = arr.length;

        long Sn1 = (N * (N + 1)) / 2;              // Sum of first N natural numbers
        long Sn2 = Sn1 * (2 * N + 1) / 3;          // Sum of squares of first N natural numbers
        long sum1 = 0;
        long sum2 = 0;

        for (long value : arr) {
            sum1 += value;
            sum2 += (value * value);
        }

        long diff1 = sum1 - Sn1;                   // x - y (difference between actual sum and expected sum)
        long diff2 = (sum2 - Sn2) / diff1;         // x + y (difference between actual square sum and expected square sum)

        int repeating = (int)(diff1 + diff2) / 2;      // x (repeating number)
        int missing = (int)(diff2 - repeating);          // y (missing number)

        return new int[]{repeating, missing};     // Return array containing repeating and missing numbers

    }
}