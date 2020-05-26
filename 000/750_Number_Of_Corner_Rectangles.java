/**
 * Dynamic Programming
 */
class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        
        // dp[i][j] = the number of pairs of corner points before the current row with position in i, j
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (grid[i][k] == 1) {
                        res += dp[j][k];
                        dp[j][k]++;
                    }
                }
            }
        }
        
        return res;
    }
}