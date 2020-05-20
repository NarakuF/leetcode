/**
 * Greedy algorithm: two pointers
 */
class Solution {
  public boolean isSubsequence(String s, String t) {
      if (s.length() == 0) {
          return true;
      }
      
      int indexS = 0;
      int indexT = 0;
      while (indexT < t.length()) {
          if (s.charAt(indexS) == t.charAt(indexT)) {
              indexS++;
              if (indexS == s.length()) {
                  return true;
              }
          }
          indexT++;
      }
      return false;
  }
}

/**
 * Dynamic programming
 */
class Solution {
  public boolean isSubsequence(String s, String t) {
      if (s.length() == 0) {
          return true;
      }
      
      int m = s.length();
      int n = t.length();
      // dp[i][j] = if s[:i] is subsequence of t[:j] (exclusive)?
      boolean[][] dp = new boolean[m + 1][n + 1];
      for (int i = 0; i < n + 1; i++) {
          dp[0][i] = true;
      }
      for (int i = 1; i < m + 1; i++) {
          for (int j = 1; j < n + 1; j++) {
              dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1);
          }
      }
      return dp[m][n];
  }
}

/**
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
 * and you want to check one by one to see if T has its subsequence.
 * In this scenario, how would you change your code?
 * 
 * Binary search
 */
class Solution {
  public boolean isSubsequence(String s, String t) {
      if (s.length() == 0) {
          return true;
      }
      
      Map<Character, List<Integer>> map = new HashMap<>();
      // precomputation, build the HashMap for t
      for (int i = 0; i < t.length(); i++) {
        char c = t.charAt(i);
        if (!map.containsKey(c)) {
          map.put(c, new ArrayList<>());
        }
        map.get(c).add(i);
      }

      int prev = -1;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!map.containsKey(c)) {
          return false;
        }
        List<Integer> indices = map.get(c);
        prev = binarySearch(indices, prev);
        if (prev == -1) {
          return false;
        }
        prev++;
      }
      return true;
  }

  // binary search implementation
  private int binarySearch(List<Integer> list, int key) {
    int low = 0;
    int high = list.size() - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int midVal = list.get(mid);
      if (midVal < key) {
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return low == list.size() ? -1 : list.get(low);
  }
}