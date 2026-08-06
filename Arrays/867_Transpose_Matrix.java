/*
 * LeetCode 867 - Transpose Matrix
 * Link: https://leetcode.com/problems/transpose-matrix/
 *
 * ----------------------------------------------------
 * Approach: Create a New Transposed Matrix
 * ----------------------------------------------------
 *
 * Idea:
 * - Create a new matrix with swapped dimensions.
 * - Traverse every element of the original matrix.
 * - Swap the row and column indices while storing:
 *      transp[c][r] = matrix[r][c]
 * - Return the transposed matrix.
 *
 * Time: O(m × n)
 *       m = number of rows
 *       n = number of columns
 *
 * Space: O(m × n)
 */

class Solution {

    public int[][] transpose(int[][] matrix) {

        int[][] transp = new int[matrix[0].length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {

            for (int c = 0; c < matrix[0].length; c++) {

                transp[c][r] = matrix[r][c];

            }
        }

        return transp;
    }
}

/*
----------------------------------------------------
Key Learnings
----------------------------------------------------

1. matrix.length
   - Gives the number of rows.

2. matrix[0].length
   - Gives the number of columns.

3. Transpose swaps the indices:
      (r, c) -> (c, r)

4. The new matrix dimensions become:
      new int[matrix[0].length][matrix.length]

5. Why not use c = r + 1?
   - r + 1 is used only for in-place transpose of a
     square matrix.
   - In this problem, we're creating a new matrix,
     so every element must be copied exactly once.
*/