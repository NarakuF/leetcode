/**
 * Dynamic Programming
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] = the minimum cost to reach on i-th step
        // dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i]
        
        int c1 = cost[0];
        int c2 = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            int c = Math.min(c1, c2) + cost[i];
            c1 = c2;
            c2 = c;
        }

        return Math.min(c1, c2);
    }
}