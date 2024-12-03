public class Solution {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                memo[j] += memo[j - coin];
            }
        }
        
        return memo[amount];
    }
}