/*
 * LeetCode 1380 - Lucky Numbers in a Matrix
 * Link: https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 *
 * Approach:
 * 1. Find the minimum value of every row.
 * 2. Find the maximum value of every column.
 * 3. Traverse the matrix again.
 * 4. A number is lucky if it is:
 *      - minimum in its row
 *      - maximum in its column
 *
 * Time: O(N × M)
 * Space: O(N + M)
 */

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        int N = matrix.length;
        int M = matrix[0].length;

        List<Integer> rowMin = new ArrayList<>();

        // Find minimum of every row
        for (int row = 0; row < N; row++) {

            int rMin = Integer.MAX_VALUE;

            for (int col = 0; col < M; col++) {
                rMin = Math.min(rMin, matrix[row][col]);
            }

            rowMin.add(rMin);
        }

        List<Integer> colMax = new ArrayList<>();

        // Find maximum of every column
        for (int col = 0; col < M; col++) {

            int cMax = Integer.MIN_VALUE;

            for (int row = 0; row < N; row++) {
                cMax = Math.max(cMax, matrix[row][col]);
            }

            colMax.add(cMax);
        }

        List<Integer> luckyNumbers = new ArrayList<>();

        // Find lucky numbers
        for (int row = 0; row < N; row++) {

            for (int col = 0; col < M; col++) {

                if (matrix[row][col] == rowMin.get(row)
                        && matrix[row][col] == colMax.get(col)) {

                    luckyNumbers.add(matrix[row][col]);
                }
            }
        }

        return luckyNumbers;
    }
}