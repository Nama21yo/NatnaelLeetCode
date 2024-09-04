class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1; // Variable to track if the first column should be set to zero

        // First pass: Mark the rows and columns that need to be set to zero
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    // Mark the first element of the corresponding row
                    matrix[i][0] = 0;
                    
                    // Mark the first element of the corresponding column (if it's not the first column)
                    if(j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        // If it's the first column, mark col0 as 0
                        col0 = 0;
                    }
                }
            }
        }   
        
        // Second pass: Use the marks to set elements to zero
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0) {
                    // If either the row or column is marked, set the element to zero
                    if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        } 
        
        // If the first row needs to be set to zero
        if(matrix[0][0] == 0) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // If the first column needs to be set to zero
        if(col0 == 0) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
