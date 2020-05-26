/**
 * Dynamic Programming
 */
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        // dp[i][j] = the sum of all elements in the first i rows and j columns
        // i.e. mat[0][0] + ... + mat[i - 1][j - 1]
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + mat[i][j];
            }
        }
        
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - K, 0);
                int c1 = Math.max(j - K, 0);
                int r2 = Math.min(i + K + 1, m);
                int c2 = Math.min(j + K + 1, n);
                res[i][j] = dp[r2][c2] - dp[r2][c1] - dp[r1][c2] + dp[r1][c1];
            }
        }
        
        return res;
    }
}