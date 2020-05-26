/**
 * Dynamic Programming
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        
        // dp[i, j] = the cost of the interval [i, j]
        // dp[i, j] = min_k(dp[i, k] + dp[k + 1, j] + max(arr[i, k]) * max(arr[k + 1, j]))
        int[][] dp = new int[n][n];
        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++) {
            int localMax = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] > localMax) {
                    localMax = arr[j];
                }
                max[i][j] = localMax;
            }
        }
        for (int len = 1; len < n; len++) {
            for (int left = 0; left + len < n; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                if (len == 1) {
                    dp[left][right] = arr[left] * arr[right];
                } 
                else {
                    for (int k = left; k < right; k++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k + 1][right] + max[left][k] * max[k + 1][right]);
                    }
                }
            }
        }
        
        return dp[0][arr.length-1];
    }
}

/**
 * Greedy Algorithm: remove the less of pair arr[i] and arr[i + 1] which has minimum product during each iteration
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        List<Integer> nums = new ArrayList<>();
        
        for (int a : arr) {
            nums.add(a);
        }
        while (nums.size() > 1) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) * nums.get(i + 1) < min) {
                    min = nums.get(i) * nums.get(i + 1);
                    idx = i;
                }
            }
            res += min;
            if (nums.get(idx) > nums.get(idx + 1)) {
                idx++;
            }
            nums.remove(idx);
        }
        
        return res;
    }
}

/**
 * Stack
 */
class Solution {
  public int mctFromLeafValues(int[] arr) {
      int res = 0;
      Stack<Integer> stack = new Stack<>();
      
      stack.push(Integer.MAX_VALUE);
      for (int a : arr) {
          while (stack.peek() <= a) {
              int mid = stack.pop();
              res += mid * Math.min(stack.peek(), a);
          }
          stack.push(a);
      }
      while (stack.size() > 2) {
          res += stack.pop() * stack.peek();
      }
      
      return res;
  }
}