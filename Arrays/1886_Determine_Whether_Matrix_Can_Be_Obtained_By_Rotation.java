/*
 * LeetCode 1886 - Determine Whether Matrix Can Be Obtained By Rotation
 * Link: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 *
 * Approach:
 * - Check the matrix 4 times: 0°, 90°, 180°, and 270°.
 * - If mat matches target at any point, return true.
 * - To rotate 90° clockwise:
 *      1. Transpose the matrix.
 *      2. Reverse every row.
 *
 * Time: O(n²)
 * Space: O(1)
 */

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        for (int r = 0; r < 4; r++) {

            if (same(mat, target)) {
                return true;
            }

            rotate(mat);
        }

        return false;
    }

    private boolean same(int[][] mat, int[][] target) {

        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void rotate(int[][] mat) {

        int n = mat.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse every row
        for (int i = 0; i < n; i++) {

            int l = 0;
            int r = n - 1;

            while (l < r) {

                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;

                l++;
                r--;
            }
        }
    }
}