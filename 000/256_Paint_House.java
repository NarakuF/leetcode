/**
 * Dynamic programming
 */
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        // COLOR = the minumun cost to paint the i-th house COLOR
        int r = costs[0][0];
        int b = costs[0][1];
        int g = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int rr = r, bb = b, gg = g;
            r = costs[i][0] + Math.min(bb, gg);
            b = costs[i][1] + Math.min(rr, gg);
            g = costs[i][2] + Math.min(rr, bb);
        }
        
        return Math.min(Math.min(r, b), g);
    }
}