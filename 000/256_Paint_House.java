/**
 * Dynamic Programming
 */
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        // COLOR[i] = the minimum cost to paint the i-th house COLOR
        // COLOR1[i] = min(COLOR2[i - 1], COLOR3[i - 1]) + costs[i][COLOR1]
        
        int r = costs[0][0];
        int b = costs[0][1];
        int g = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int rr = r, bb = b, gg = g;
            r = Math.min(bb, gg) + costs[i][0];
            b = Math.min(rr, gg) + costs[i][1];
            g = Math.min(rr, bb) + costs[i][2];
        }
        
        return Math.min(Math.min(r, b), g);
    }
}