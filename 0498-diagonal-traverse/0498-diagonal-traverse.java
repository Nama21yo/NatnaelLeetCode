class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        // Edge case: If the matrix is empty, return an empty array
        if (row == 0 || col == 0) return new int[0];

        // Result array to store the diagonal traversal
        int[] diagonal = new int[row * col];

        // Boolean to control the direction of traversal
        boolean up = true;

        // 'last' keeps track of the position in the diagonal array
        int last = 0;

        // Traversing the diagonals starting from the first column and first row
        for (int k = 0; k < row + col - 1; k++) {
            int i, j;

            // If moving upwards along the diagonal
            if (up) {
                i = Math.min(k, row - 1);  // Ensures i doesn't exceed the number of rows
                j = k - i;  // Calculate the corresponding j based on the current diagonal
                while (i >= 0 && j < col) {
                    diagonal[last++] = mat[i][j];
                    i--;
                    j++;
                }
            } 
            // If moving downwards along the diagonal
            else {
                j = Math.min(k, col - 1);  // Ensures j doesn't exceed the number of columns
                i = k - j;  // Calculate the corresponding i based on the current diagonal
                while (j >= 0 && i < row) {
                    diagonal[last++] = mat[i][j];
                    i++;
                    j--;
                }
            }
            up = !up;  // Switch direction after completing each diagonal
        }

        return diagonal;
    }
}
