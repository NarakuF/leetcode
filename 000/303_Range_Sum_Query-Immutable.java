/**
 * Dynamic Programming
 */
class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        // sums[i] = the sum of the first i elements
        // i.e. nums[0] + ... + nums[i - 1]
        sums = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}