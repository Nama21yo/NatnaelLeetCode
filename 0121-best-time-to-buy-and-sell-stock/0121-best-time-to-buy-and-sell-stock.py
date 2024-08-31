class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        maxProfit = 0
        
        for right in range(1,len(prices)):
            if prices[right] < buy:
                buy = prices[right]
            else:
                profit = prices[right] - buy
                maxProfit = max(maxProfit,profit)
        
        return maxProfit
        