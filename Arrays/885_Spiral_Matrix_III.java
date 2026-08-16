/*
 * LeetCode 885 - Spiral Matrix III
 * Link: https://leetcode.com/problems/spiral-matrix-iii/
 *
 * Approach:
 * Start from (rStart, cStart) and move in a clockwise spiral.
 *
 * Movement:
 * RIGHT 1
 * DOWN  1
 * LEFT  2
 * UP    2
 * RIGHT 3
 * DOWN  3
 * LEFT  4
 * UP    4
 *
 * steps increases after every two directions.
 *
 * We can move outside the grid, but we only store
 * coordinates that are inside the grid.
 *
 * Time: O(rows × cols)
 * Space: O(rows × cols)
 */

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] res = new int[rows * cols][2];

        int r = rStart;
        int c = cStart;

        int count = 0;
        int steps = 1;

        res[count++] = new int[]{r, c};

        while (count < rows * cols) {

            for (int i = 0; i < steps; i++) {
                c++;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[count++] = new int[]{r, c};
                }
            }

            for (int i = 0; i < steps; i++) {
                r++;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[count++] = new int[]{r, c};
                }
            }

            steps++;

            for (int i = 0; i < steps; i++) {
                c--;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[count++] = new int[]{r, c};
                }
            }

            for (int i = 0; i < steps; i++) {
                r--;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[count++] = new int[]{r, c};
                }
            }

            steps++;
        }

        return res;
    }
}