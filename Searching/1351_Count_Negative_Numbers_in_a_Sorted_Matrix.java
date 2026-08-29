/*
 * LeetCode 1351 - Count Negative Numbers in a Sorted Matrix
 *
 * Link:
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * Approach:
 *
 * Visit every row and use Binary Search to find the
 * first negative number in that row.
 *
 * Once the first negative number is found, every element
 * to its right is also negative because the row is sorted.
 *
 * Number of negatives:
 *
 * row length - firstNegative
 *
 * If no negative number exists, firstNegative remains
 * equal to the row length, giving 0 negatives.
 *
 * Time Complexity: O(m log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;

        for (int row = 0; row < grid.length; row++) {

            int s = 0;
            int e = grid[row].length - 1;
            int firstNegative = grid[row].length;

            while (s <= e) {

                int m = s + (e - s) / 2;

                if (grid[row][m] < 0) {
                    firstNegative = m;
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }

            count += grid[row].length - firstNegative;
        }

        return count;
    }
}
