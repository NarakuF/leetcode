/**
 * Dynamic programming
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int c1 = cost[0];
        int c2 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int c = cost[i] + Math.min(c1, c2);
            c1 = c2;
            c2 = c;
        }
        return Math.min(c1, c2);
    }
}