class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount < 1:
            return 0
        
        memo = [0] * (amount + 1)
        # for making 0 amount we need no/0 coins
        for i in range(1, amount + 1):
            memo[i] = float("inf")
            for coin in coins:
                if  (coin <= i) and (memo[i - coin] != float("inf")):
                    memo[i] = min(memo[i], 1 + memo[i - coin])
        
        return memo[amount] if memo[amount] != float("inf") else -1