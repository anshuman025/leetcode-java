/*
 * LeetCode 1621 - Number of Sets of K Non-Overlapping Line Segments
 * Link: https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
 *
 * Approach:
 * Dynamic Programming
 *
 * dp[i][j] represents the number of ways to draw j segments
 * using the first i points.
 *
 * Since segments are allowed to share endpoints, a segment can
 * start where the previous segment ended.
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(n * k)
 */

class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1000000007L;

        long[][] dp = new long[k + 1][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int segments = 1; segments <= k; segments++) {
            long sum = 0;

            for (int points = 1; points < n; points++) {
                sum = (sum + dp[segments - 1][points - 1]) % MOD;
                dp[segments][points] =
                        (dp[segments][points - 1] + sum) % MOD;
            }
        }

        return (int) dp[k][n - 1];
    }
}