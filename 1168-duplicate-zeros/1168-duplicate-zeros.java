class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int possibleDups = 0;

        // Find the number of zeros to be duplicated
        // and adjust the number of elements accordingly
        for (int i = 0; i < n - possibleDups; i++) {
            if (arr[i] == 0) {
                // Edge case: Check if the zero to be duplicated is the last element
                if (i == n - 1 - possibleDups) {
                    // Duplicate the last zero and break, as there's no space left
                    arr[n - 1] = 0;
                    n--;
                    break;
                }
                possibleDups++;
            }
        }

        // Start from the last element to duplicate zeros
        for (int i = n - possibleDups - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
