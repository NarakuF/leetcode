/**
 * Dynamic programming
 */
class Solution {
    public boolean divisorGame(int N) {
        // dp[i] = Alice wins the game for i
        boolean[] dp = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j < i / 2 + 1; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}