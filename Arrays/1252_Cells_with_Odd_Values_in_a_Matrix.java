/*
 * LeetCode 1252 - Cells with Odd Values in a Matrix
 * Link: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 *
 * ----------------------------------------------------
 * Approach 1: Build the Matrix
 * ----------------------------------------------------
 *
 * Idea:
 * - Create the matrix.
 * - For every operation:
 *      • Increment the entire row.
 *      • Increment the entire column.
 * - Traverse the matrix and count the odd values.
 *
 * Time: O(k × (m + n) + m × n)
 * Space: O(m × n)
 *
 * ----------------------------------------------------
 * Approach 2: Count Row & Column Increments (Optimized)
 * ----------------------------------------------------
 *
 * Idea:
 * - Instead of creating the whole matrix,
 *   just count how many times each row and column is incremented.
 * - Every cell value is simply:
 *      row count + column count
 * - If the sum is odd, increase the answer.
 *
 * Time: O(k + m × n)
 * Space: O(m + n)
 */

class Solution {

    // ---------- Approach 1 : Build the Matrix ----------

    public int oddCells(int m, int n, int[][] indices) {

        int[][] matrix = new int[m][n];

        for (int[] index : indices) {

            int row = index[0];
            int col = index[1];

            for (int j = 0; j < n; j++) {
                matrix[row][j]++;
            }

            for (int j = 0; j < m; j++) {
                matrix[j][col]++;
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] % 2 != 0) {
                    count++;
                }

            }
        }

        return count;
    }


    // ---------- Approach 2 : Count Row & Column Increments ----------

    public int oddCells(int m, int n, int[][] indices) {

        int[] row = new int[m];
        int[] col = new int[n];

        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ((row[i] + col[j]) % 2 != 0) {
                    count++;
                }

            }
        }

        return count;
    }

}