/*
 * LeetCode 73 - Set Matrix Zeroes
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Approach:
 * First pass:
 * Find all cells containing 0.
 * Store their rows and columns in separate boolean arrays.
 *
 * Second pass:
 * If a cell's row OR column was marked,
 * set that cell to 0.
 *
 * Time: O(m × n)
 * Space: O(m + n)
 *
 * Optimization pending:
 * This solution can be optimized to O(1) extra space
 * by using the first row and first column as markers.
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] zRow = new boolean[m];
        boolean[] zCol = new boolean[n];


        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if(matrix[i][j] == 0){
                    zRow[i]= true;
                    zCol[j]= true;
                }
            }
        }

        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if( zRow[i] || zCol[j] ){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}