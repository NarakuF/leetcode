/**
 * Dynamic Programming
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        
        // dp[i] = the number of ways to reach on i-th step
        // dp[i] = dp[i - 1] + dp[i - 2]
        
        int num1 = 1;
        int num2 = 2;

        for (int i = 2; i < n; i++) {
            int num = num1 + num2;
            num1 = num2;
            num2 = num;
        }
        
        return num2;
    }
}