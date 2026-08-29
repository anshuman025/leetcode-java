/*
 * Approach:
 *
 * Visit every element in the matrix.
 * If the current element is negative, increase the count.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] < 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
