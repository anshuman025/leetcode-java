/*
 * LeetCode 3619: Count Islands With Total Value Divisible by K
 * Problem Link: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/
 *
 * Approach: Iterative DFS
 *
 * 1. Traverse every cell in the grid.
 * 2. When a positive, unvisited cell is found, explore its island.
 * 3. Add the values of all connected land cells.
 * 4. Mark visited cells as zero to avoid revisiting them.
 * 5. If the island's total is divisible by k, increment the answer.
 *
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n) in the worst case.
 */

import java.util.*;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= 0) {
                    continue;
                }

                long sum = 0;

                stack.push(i * n + j);
                sum += grid[i][j];
                grid[i][j] = 0;

                while (!stack.isEmpty()) {
                    int cell = stack.pop();
                    int row = cell / n;
                    int col = cell % n;

                    for (int d = 0; d < 4; d++) {
                        int nr = row + dr[d];
                        int nc = col + dc[d];

                        if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] > 0) {

                            sum += grid[nr][nc];
                            grid[nr][nc] = 0;
                            stack.push(nr * n + nc);
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}