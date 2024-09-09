class Solution {
    public int[] findErrorNums(int[] arr) {
        
        long N = arr.length;

        int xr = 0;  // XOR of all elements and numbers from 1 to N

        // Perform XOR of all array elements and numbers from 1 to N
        for (int i = 0; i < N; i++) {
            xr = xr ^ (int) arr[i];
            xr = xr ^ (i + 1);
        }

        // Find the rightmost set bit in xr (the bit where the two numbers differ)
        int bitNo = 0;
        while (true) {
            if ((xr & (1 << bitNo)) != 0) {
                break;
            }
            bitNo++;
        }

        // Classify the numbers based on the found bit
        int zero = 0;
        int one = 0;

        // XOR all elements in the array, based on the bitNo classification
        for (int i = 0; i < N; i++) {
            if ((arr[i] & (1 << bitNo)) != 0) {
                one = one ^ (int) arr[i];
            } else {
                zero = zero ^ (int) arr[i];
            }
        }

        // XOR numbers from 1 to N, again based on the bitNo classification
        for (int i = 1; i <= N; i++) {
            if ((i & (1 << bitNo)) != 0) {
                one = one ^ i;
            } else {
                zero = zero ^ i;
            }
        }

        // Determine which is repeating and which is missing
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == zero) count++;
        }

        // If 'zero' is the repeating number
        if (count == 2) {
            return new int[]{zero, one};
        }

        // Otherwise, 'one' is the repeating number
        return new int[]{one, zero};


    }
}