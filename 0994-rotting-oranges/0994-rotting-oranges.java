import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Step 1: Initialize the queue with all rotten oranges and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        // Edge case: If there are no fresh oranges, return 0 immediately
        if (freshOranges == 0) return 0;

        int minutesElapsed = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: BFS to spread the rot to adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0], c = current[1];

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    // If adjacent cell is within bounds and is a fresh orange, rot it
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        queue.add(new int[]{newRow, newCol});
                        freshOranges--;
                        rottenThisMinute = true;
                    }
                }
            }
            // Increment minutes only if at least one orange rotted in this minute
            if (rottenThisMinute) minutesElapsed++;
        }

        // Step 3: If there are still fresh oranges left, return -1
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}
