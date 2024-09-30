class Solution {
    public int captureForts(int[] forts) {
        int max_forts = 0;
        
        for (int i = 0; i < forts.length; i++) {
            // Check for a friendly fort at position i
            if (forts[i] == 1) {
                // Try to capture forts to the left
                int left_forts = 0;
                int left = i - 1;
                while (left >= 0 && forts[left] == 0) {
                    left_forts++;
                    left--;
                }
                // Ensure that we are capturing only if there is an enemy fort (-1)
                if (left >= 0 && forts[left] == -1) {
                    max_forts = Math.max(max_forts, left_forts);
                }

                // Try to capture forts to the right
                int right_forts = 0;
                int right = i + 1;
                while (right < forts.length && forts[right] == 0) {
                    right_forts++;
                    right++;
                }
                // Ensure that we are capturing only if there is an enemy fort (-1)
                if (right < forts.length && forts[right] == -1) {
                    max_forts = Math.max(max_forts, right_forts);
                }
            }
        }
        
        return max_forts;
    }
}
