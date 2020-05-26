/**
 * Dynamic Programming
 */
class Solution {
    public int[] countBits(int num) {
        // dp[i] = the number of 1's in binary representation for i
        int[] dp = new int[num + 1];
        int offset = 1;
        
        for (int i = 1; i < num + 1; i++) {
            if (i == 2 * offset) {
                offset *= 2;
            }
            dp[i] = dp[i - offset] + 1;
        }
        
        return dp;
    }
}