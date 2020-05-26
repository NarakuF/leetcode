/**
 * Dynamic Programming
 */
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // dp[i + 1][j + 1] = the length of the biggest square with matrix[i][j] at bottom-right corner
        // dp[i + 1][j + 1] = the number of squares with matrix[i][j] at bottom-right corner
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    res += dp[i + 1][j + 1];
                }
            }
        }
        
        return res;
    }
}