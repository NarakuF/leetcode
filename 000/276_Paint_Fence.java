/**
 * Dynamic Programming
 */
class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        
        // dp[i] = the total number of ways to paint i posts
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i < n + 1; i++) {
            // dp[i - 2] = paint the same color as i-1th post 
            // dp[i - 1] = paint the different color as i-1th post
            dp[i] = (dp[i - 2] + dp[i - 1]) * (k - 1);
        }
        
        return dp[n];
    }
}