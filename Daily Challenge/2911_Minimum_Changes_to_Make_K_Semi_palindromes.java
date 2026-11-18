import java.util.Arrays;

class Solution {

    /*
     * Problem: 2911. Minimum Changes to Make K Semi-palindromes
     * Link: https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/
     *
     * Approach:
     * 1. Precompute the minimum changes required to make every
     *    substring a semi-palindrome.
     * 2. Try every valid divisor of the substring length.
     * 3. Use dynamic programming to partition the string into
     *    exactly k semi-palindromes.
     *
     * Time Complexity: O(n^3 * tau(n) + k * n^2)
     * Space Complexity: O(n^2 + k * n)
     */

    public int minimumChanges(String s, int k) {

        int n = s.length();
        int INF = 1_000_000;

        // cost[i][j] = minimum changes to make s[i...j]
        // a semi-palindrome.
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
        }

        // Precompute substring costs.
        for (int len = 2; len <= n; len++) {

            for (int start = 0; start + len <= n; start++) {

                // Try every proper divisor of len.
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Check each group formed by positions
                    // having the same remainder modulo d.
                    for (int r = 0; r < d; r++) {

                        int groupSize = (len - 1 - r) / d + 1;

                        for (int t = 0; t < groupSize / 2; t++) {

                            int left = start + r + t * d;

                            int right = start + r
                                    + (groupSize - 1 - t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[start][start + len - 1] =
                            Math.min(cost[start][start + len - 1], changes);
                }
            }
        }

        // dp[parts][end] = minimum changes to divide
        // the first 'end' characters into 'parts' substrings.
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        // Build DP.
        for (int parts = 1; parts <= k; parts++) {

            for (int end = parts * 2; end <= n; end++) {

                // Every substring must have length >= 2.
                for (int start = (parts - 1) * 2;
                     start <= end - 2; start++) {

                    if (dp[parts - 1][start] == INF) {
                        continue;
                    }

                    dp[parts][end] = Math.min(
                            dp[parts][end],
                            dp[parts - 1][start] + cost[start][end - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}