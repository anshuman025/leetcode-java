/*
 * LeetCode 441 - Arranging Coins
 *
 * Link:
 * https://leetcode.com/problems/arranging-coins/
 *
 * Approach 1: Iterative
 *
 * Start with row 1.
 * Each row requires one more coin than the previous row.
 *
 * If we have enough coins to complete the current row:
 *     Complete the row.
 *     Subtract the required coins.
 *     Move to the next row.
 *
 * Stop when there are not enough coins to complete
 * the next row.
 *
 * Time Complexity: O(sqrt(n))
 * Space Complexity: O(1)
 *
 * Optimization:
 * Binary Search can reduce the time complexity to O(log n).
 */

class Solution {
    public int arrangeCoins(int n) {

        int ans = 0;
        int index = 1;

        while (n >= index) {

            ans++;
            n -= index;
            index++;
        }

        return ans;
    }
}