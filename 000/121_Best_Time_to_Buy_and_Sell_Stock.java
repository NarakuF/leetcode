/**
 * Dynamic Programming
 */
class Solution {
    public int maxProfit(int[] prices) {
        // dp[i] = the maximum profit by i-th day
        // dp[i] = max(dp[i - 1], prices[i] - minPrice)

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int curPrice : prices) {
            maxProfit = Math.max(maxProfit, curPrice - minPrice);
            minPrice = Math.min(minPrice, curPrice);
        }
        
        return maxProfit;
    }
}