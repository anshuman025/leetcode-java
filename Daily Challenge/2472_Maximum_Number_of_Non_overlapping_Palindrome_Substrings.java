/*
 * LeetCode 2472 - Maximum Number of Non-overlapping Palindrome Substrings
 * Link: https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
 *
 * Approach:
 * 1. Use Palindrome DP to determine whether every substring is a palindrome.
 * 2. Use another DP to find the maximum number of non-overlapping
 *    palindromic substrings with length at least k.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        int[] best = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            best[i] = best[i - 1];

            for (int j = 0; j < i; j++) {
                if (i - j >= k && dp[j][i - 1]) {
                    best[i] = Math.max(best[i], best[j] + 1);
                }
            }
        }

        return best[n];
    }
}
