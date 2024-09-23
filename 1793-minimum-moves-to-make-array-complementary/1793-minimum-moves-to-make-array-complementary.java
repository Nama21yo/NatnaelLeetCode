class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        
        // Process every pair of elements
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - i - 1];
            
            // Update ranges in the difference array
            diff[2] += 2; // Initially assume that we need 2 moves to make the pair valid
            
            diff[Math.min(a, b) + 1]--; // If the sum falls between min(a, b) + 1, subtract 1 move
            diff[a + b]--; // If we reach exactly a + b, subtract 1 move (no change needed)
            diff[a + b + 1]++; // From a + b + 1 to higher, add 1 move
            diff[Math.max(a, b) + limit + 1]++; // From max(a, b) + limit + 1, we add 2 moves (as initially)
        }
        
        // Now, sweep through the difference array to calculate the minimum number of moves
        int result = Integer.MAX_VALUE;
        int moves = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            moves += diff[i];
            result = Math.min(result, moves);
        }
        
        return result;
    }
}
