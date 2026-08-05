/*
 * LeetCode 1572 - Matrix Diagonal Sum
 * Link: https://leetcode.com/problems/matrix-diagonal-sum/
 *
 * ----------------------------------------------------
 * Approach: Single Traversal
 * ----------------------------------------------------
 *
 * Idea:
 * - Traverse the matrix only once.
 * - Add the primary diagonal using mat[i][i].
 * - Add the secondary diagonal using mat[i][n - 1 - i].
 * - If both diagonals meet at the same element (middle element),
 *   don't add it twice.
 *
 * Time: O(n)
 * Space: O(1)
 */

class Solution {

    public int diagonalSum(int[][] mat) {

        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            // Primary diagonal
            sum += mat[i][i];

            // Secondary diagonal
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }

        return sum;
    }
}