class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int oddSum = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - i;
            int total = start * end;
            int oddLength = total % 2 == 0 ? total / 2: (total / 2) + 1;
            oddSum += oddLength * arr[i];
        }
        return oddSum;
    }
}
