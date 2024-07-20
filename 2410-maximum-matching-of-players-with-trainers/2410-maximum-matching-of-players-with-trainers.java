import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Sort both arrays to facilitate matching
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int n = players.length;
        int m = trainers.length;
        int ans = 0; // Counter for the number of successful matches
        int j = 0; // Pointer for the trainers array
        
        // Iterate through each player
        for (int i = 0; i < n; i++) {
            // Find the first trainer that can match the current player
            while (j < m && trainers[j] < players[i]) {
                j++;
            }
            // If a match is found, increment the counter and move to the next trainer
            if (j < m) {
                ans++;
                j++;
            }
        }
        
        return ans; // Return the number of matches
    }
}
