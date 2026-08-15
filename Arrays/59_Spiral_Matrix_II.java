/*
 * LeetCode 59 - Spiral Matrix II
 * Link: https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Approach:
 * Use four boundaries to fill the matrix layer by layer:
 *
 * top    -> top row
 * bottom -> bottom row
 * left   -> left column
 * right  -> right column
 *
 * num keeps track of the next number to insert.
 *
 * Time: O(n²)
 * Space: O(n²)
 */

class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // Left → Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Top → Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Right → Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            // Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}