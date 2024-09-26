class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int entire_sum = 0;

        // Outer loop to select the starting point of subarrays
        for (int i = 0; i <= n - 1; i++) {
            int sum = 0;

            // Inner loop to select the end point of subarrays
            for (int j = i; j <= n - 1; j++) {
                sum += arr[j];  // Add the current element to the sum

                // Only add to entire_sum if the length of the subarray is odd
                if ((j - i + 1) % 2 != 0) {  // Length of subarray = j - i + 1
                    entire_sum += sum;
                }
            }
        }
        return entire_sum;
    }
}
