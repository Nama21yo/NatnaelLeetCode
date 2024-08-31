class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        
        for(int right = 1; right < prices.length;right++) {
            if(prices[right] < buy) {
                buy = prices[right];
            } else {
                int profit = prices[right] - buy;
                maxProfit = Math.max(maxProfit,profit);
            }
        }
        
        return maxProfit;
    }
}