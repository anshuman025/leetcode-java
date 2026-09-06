/*
 * LeetCode 115 - Distinct Subsequences
 * Link: https://leetcode.com/problems/distinct-subsequences/
 *
 * Approach: Dynamic Programming
 *
 * dp[i][j] represents the number of distinct subsequences
 * of the first i characters of s that can form the first
 * j characters of t.
 *
 * If the current characters match:
 *   1. Take s[i - 1] to match t[j - 1]
 *   2. Skip s[i - 1]
 *
 * Therefore:
 *   dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
 *
 * If they do not match, we must skip s[i - 1]:
 *   dp[i][j] = dp[i - 1][j]
 *
 * Base case:
 * An empty t can always be formed by deleting all characters
 * from s, so dp[i][0] = 1.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        long[][] dp = new long[m + 1][n + 1];

        // Empty t can be formed in exactly one way.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {

                    // Take the current character OR skip it.
                    dp[i][j] = dp[i - 1][j - 1]
                            + dp[i - 1][j];

                } else {

                    // Characters don't match, so skip s[i - 1].
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return (int) dp[m][n];
    }
}