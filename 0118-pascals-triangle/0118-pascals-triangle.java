import java.util.ArrayList;
import java.util.List;

class Solution {
    // Main function to generate Pascal's Triangle up to numRows
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store all rows of Pascal's Triangle
        for (int i = 1; i <= numRows; i++) { // Loop through each row
            ans.add(generateRow(i)); // Generate each row and add to the list
        }
        return ans; // Return the final list containing all rows
    }

    // Helper function to generate a specific row of Pascal's Triangle
    private List<Integer> generateRow(int row) {
        int ans = 1; // Initialize the first value of the row
        List<Integer> ansRow = new ArrayList<>(); // List to store the current row
        ansRow.add(1); // Add the first element which is always 1

        for (int col = 1; col < row; col++) { // Loop through each column in the row
            ans = ans * (row - col); // Calculate the current element using binomial coefficient
            ans = ans / col;
            ansRow.add(ans); // Add the calculated element to the current row list
        }
        return ansRow; // Return the current row list
    }
}
