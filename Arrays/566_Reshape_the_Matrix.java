/*
 * LeetCode 566 - Reshape the Matrix
 * Link: https://leetcode.com/problems/reshape-the-matrix/
 *
 * ==========================================================
 * Approach 1 - Matrix Traversal + Index
 * ==========================================================
 *
 * i → current row of the original matrix
 * j → current column of the original matrix
 * index → position in the flattened sequence
 *
 * index / c → new row
 * index % c → new column
 *
 * Time: O(m × n)
 * Space: O(r × c)
 */

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int row = mat.length;
        int col = mat[0].length;

        if(row * col != r * c){
            return mat;
        }

        int [][] res = new int[r][c];
        int index = 0;


        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){

                int newRow = index / c;
                int newCol = index % c;

                res[newRow][newCol] = mat[i][j];

                index++;
            }
        }

        return res;

    }
}



/*
 * ==========================================================
 * Approach 2 - Direct Index Mapping
 * ==========================================================
 *
 * Treat the matrix as one continuous sequence.
 *
 * For the OLD matrix:
 * i / col → old row
 * i % col → old column
 *
 * For the NEW matrix:
 * i / c → new row
 * i % c → new column
 *
 * Time: O(m × n)
 * Space: O(r × c)
 */

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int row = mat.length;
        int col = mat[0].length;

        int total = row * col;

        if (total != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];

        for (int i = 0; i < total; i++) {
            res[i / c][i % c] = mat[i / col][i % col];
        }

        return res;
    }
}




