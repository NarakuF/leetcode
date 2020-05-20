/**
 * Dynamic programming
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        
        int num1 = 1;
        int num2 = 2;
        for (int i = 2; i < n; i++) {
            int num = num1 + num2;
            num1 = num2;
            num2 = num;
        }
        return num2;
    }
}