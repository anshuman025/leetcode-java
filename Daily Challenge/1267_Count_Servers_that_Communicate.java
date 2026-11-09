/*
 * Problem: 1267. Count Servers that Communicate
 * Difficulty: Medium
 *
 * LeetCode:
 * https://leetcode.com/problems/count-servers-that-communicate/
 *
 * Approach: Row and Column Frequency Counting
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m + n)
 */

class Solution {
    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Count servers in each row and column.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int result = 0;

        // Count servers that can communicate with another server.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 &&
                        (rowCount[i] > 1 || colCount[j] > 1)) {

                    result++;
                }
            }
        }

        return result;
    }
}