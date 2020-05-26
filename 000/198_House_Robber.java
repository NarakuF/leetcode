/**
 * Dynamic Programming
 */
class Solution {
    public int rob(int[] nums) {
        // dp[i] = the maximum amount that you can rob from the first i houses
        // dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        int prevMax = 0;
        int currMax = 0;
        
        for (int curr : nums) {
            int tmp = currMax;
            currMax = Math.max(currMax, prevMax + curr);
            prevMax = tmp;
        }
        
        return currMax;
    }
}