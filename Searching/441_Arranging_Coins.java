/*
 * LeetCode 441 - Arranging Coins
 *
 * Link:
 * https://leetcode.com/problems/arranging-coins/
 *
 * ----------------------------------------------------
 * Approach 1: Iterative
 *
 * Build the rows one by one.
 *
 * Each row requires one more coin than the previous row.
 *
 * Time Complexity: O(sqrt(n))
 * Space Complexity: O(1)
 *
 * ----------------------------------------------------
 * Approach 2: Binary Search
 *
 * Search for the maximum number of complete rows.
 *
 * Coins required for m rows:
 *
 * m * (m + 1) / 2
 *
 * If required coins == n:
 *     Found the exact answer.
 *
 * If required coins < n:
 *     m rows are possible, so search for more rows.
 *
 * If required coins > n:
 *     m rows are not possible, so search for fewer rows.
 *
 * At the end, e represents the largest valid number
 * of complete rows.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Binary Search.
 * ----------------------------------------------------
 */

class Solution {

    // Approach 1: Iterative

    public int arrangeCoinsIterative(int n) {

        int ans = 0;
        int index = 1;

        while (n >= index) {

            ans++;
            n -= index;
            index++;
        }

        return ans;
    }


    // Approach 2: Binary Search

    public int arrangeCoins(int n) {

        int s = 1;
        int e = n;

        while (s <= e) {

            int m = s + (e - s) / 2;

            long N = (long) m * (m + 1) / 2;

            if (N == n) {
                return m;

            } else if (N < n) {
                s = m + 1;

            } else {
                e = m - 1;
            }
        }

        return e;
    }
}