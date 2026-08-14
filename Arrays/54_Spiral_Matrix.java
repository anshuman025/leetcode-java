/*
 * LeetCode 54 - Spiral Matrix
 * Link: https://leetcode.com/problems/spiral-matrix/
 *
 * Approach:
 * Traverse the matrix layer by layer using four boundaries:
 *
 * top    -> top row
 * bottom -> bottom row
 * left   -> left column
 * right  -> right column
 *
 * After traversing each side, move its boundary inward.
 *
 * Time: O(m × n)
 * Space: O(m × n) for the returned result list
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Left → Right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Top → Bottom
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // Right → Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}