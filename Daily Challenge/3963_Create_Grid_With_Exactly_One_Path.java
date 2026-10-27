import java.util.*;

/*
 * LeetCode 3963: Create Grid With Exactly One Path
 * Problem Link: https://leetcode.com/problems/create-grid-with-exactly-one-path/
 *
 * Approach: Constructive Algorithm
 *
 * 1. Initialize every cell as an obstacle '#'.
 * 2. Make every cell in the top row free '.'.
 * 3. Make every cell in the rightmost column free '.'.
 * 4. This creates exactly one path: right across the top row,
 *    then down the rightmost column.
 *
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n)
 */

class Solution {
    public List<String> createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            result.add(new String(grid[i]));
        }

        return result;
    }
}