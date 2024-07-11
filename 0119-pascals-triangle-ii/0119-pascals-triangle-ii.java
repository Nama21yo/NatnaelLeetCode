import java.util.ArrayList;
import java.util.List;

class Solution {
    // Function to get a specific row of Pascal's Triangle
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long ansRow = 1;
        ans.add((int) ansRow); // Add the first element which is always 1
        rowIndex += 1; // Adjust for 0-based index
        
        for (int col = 1; col < rowIndex; col++) { // Loop through each column in the row
            ansRow = ansRow * (rowIndex - col); // Calculate the current element using binomial coefficient
            ansRow = ansRow / col;
            ans.add((int) ansRow); // Add the calculated element to the current row list
        }
        
        return ans; // Return the current row list
    }
}
