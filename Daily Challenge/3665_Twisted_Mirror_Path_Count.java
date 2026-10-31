/*
 * Problem: 3665. Twisted Mirror Path Count
 * LeetCode: https://leetcode.com/problems/twisted-mirror-path-count/
 *
 * Approach: Space Optimized Dynamic Programming
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(n)
 */

class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;

        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            int left = 0;

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    // Mirror: swap incoming path counts.
                    int temp = left;
                    left = dp[j];
                    dp[j] = temp;

                } else {
                    // Empty cell: combine paths from left and above.
                    int total = (left + dp[j]) % MOD;

                    left = total;
                    dp[j] = total;
                }
            }
        }

        return dp[n - 1];
    }
}