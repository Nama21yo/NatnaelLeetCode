class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Sort the array based on the difference in costs of sending to city A and city B
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int totalCost = 0;
        int n = costs.length / 2;
        
        // Send the first half to city A and the second half to city B
        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0]; // Send first n people to city A
        }
        for (int i = n; i < 2 * n; i++) {
            totalCost += costs[i][1]; // Send remaining n people to city B
        }
        
        return totalCost;
    }
}
