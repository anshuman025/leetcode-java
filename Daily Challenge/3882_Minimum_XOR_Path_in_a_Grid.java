

/*
 * LeetCode 3882: Minimum XOR Path in a Grid
 * Problem Link: https://leetcode.com/problems/minimum-xor-path-in-a-grid/
 *
 * Approach: Dynamic Programming with HashSet
 *
 * 1. Store all possible path XOR values for each cell.
 * 2. Get possible values from the top and left cells.
 * 3. XOR each previous value with the current cell value.
 * 4. Return the smallest XOR value at the bottom-right cell.
 *
 * Time Complexity: O(m * n * 1024)
 * Space Complexity: O(m * n * 1024) in the worst case.
 */

import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<Integer>[][] dp = new HashSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();

                if (i == 0 && j == 0) {
                    dp[i][j].add(grid[i][j]);
                    continue;
                }

                if (i > 0) {
                    for (int value : dp[i - 1][j]) {
                        dp[i][j].add(value ^ grid[i][j]);
                    }
                }

                if (j > 0) {
                    for (int value : dp[i][j - 1]) {
                        dp[i][j].add(value ^ grid[i][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int value : dp[m - 1][n - 1]) {
            answer = Math.min(answer, value);
        }

        return answer;
    }
}