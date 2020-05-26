/**
 * Dynamic Programming
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] = the maximum Subarray has nums[i] as the end element
        // dp[i] = max(dp[i - 1], 0) + nums[i]; 

        int curSum = nums[0];
        int maxSum = curSum;
        
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
    }
}

/**
 * Divide and Conquer
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;
        
        int leftSum = helper(nums, left, mid); // middle element always belongs to the left subarray
        int rightSum = helper(nums, mid + 1, right);
        int crossSum = crossSum(nums, left, right, mid);
        
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    
    private int crossSum(int[] nums, int left, int right, int mid) {
        if (left == right) {
            return nums[left];
        }
        
        int leftSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = mid; i >= left; i--) {
            curSum += nums[i];
            leftSum = Math.max(leftSum, curSum);
        }
        
        int rightSum = Integer.MIN_VALUE;
        curSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            curSum += nums[i];
            rightSum = Math.max(rightSum, curSum);
        }
        
        return leftSum + rightSum;
    }
}