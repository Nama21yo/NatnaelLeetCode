class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        // Step 1: Transpose the matrix (swap elements across the diagonal)
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                swap(matrix, i, j);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < m; i++) {
            reverse(matrix[i]);
        }
    }

    // Helper method to swap elements at (i, j) and (j, i)
    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    // Helper method to reverse a row
    private void reverse(int[] row) {
        int start = 0;
        int end = row.length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}
