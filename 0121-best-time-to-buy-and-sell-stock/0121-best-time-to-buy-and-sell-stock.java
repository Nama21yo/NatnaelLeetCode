class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;//minimum profit is zero
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buy_price) { // take the smallest buy price
                buy_price = prices[i];
            } else {
                int current_profit = prices[i] - buy_price;//sell - buy
                profit = Math.max(profit,current_profit);
            }
        }
        
        return profit;
    }
}