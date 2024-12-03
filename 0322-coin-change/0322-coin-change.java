class Solution {
    public int coinChange(int[] coins, int amount) {
        // the last example edge case
        if (amount < 1) return 0;

        // my memoization array
        int[] memo = new int[amount + 1];

        // for making 0 you only need no coins(0)
        for (int i = 1;i <= amount; i++) {
            memo[i] = Integer.MAX_VALUE;

            // Try to check for the possible coins
            for(int coin: coins) {
                if(coin <= i && memo[i - coin] != Integer.MAX_VALUE) {
                    memo[i] = Math.min(memo[i], 1 + memo[i - coin]);
                }
            }
        }

        if(memo[amount] == Integer.MAX_VALUE) return -1;
        return memo[amount];
    }
}