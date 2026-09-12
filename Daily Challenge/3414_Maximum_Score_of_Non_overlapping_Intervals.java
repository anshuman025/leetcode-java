/*
 * LeetCode 3414 - Maximum Score of Non-overlapping Intervals
 * Link: https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
 *
 * Approach:
 * Sorting + Binary Search + Dynamic Programming
 *
 * Sort intervals by their ending position.
 * For each interval, use Binary Search to find the last
 * interval that ends before the current interval starts.
 *
 * DP keeps the maximum score when choosing at most 4 intervals.
 *
 * If scores are equal, choose the lexicographically smaller
 * array of original indices.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        long[][] dp = new long[n + 1][5];
        int[][][] path = new int[n + 1][5][];

        for (int i = 1; i <= n; i++) {
            int left = arr[i - 1][0];
            int weight = arr[i - 1][2];
            int index = arr[i - 1][3];

            int p = findPrevious(arr, i - 1, left);

            for (int k = 1; k <= 4; k++) {
                dp[i][k] = dp[i - 1][k];
                path[i][k] = path[i - 1][k];

                long takeScore = dp[p][k - 1] + weight;
                int[] takePath = add(path[p][k - 1], index);

                if (takeScore > dp[i][k] ||
                        (takeScore == dp[i][k] &&
                                smaller(takePath, path[i][k]))) {

                    dp[i][k] = takeScore;
                    path[i][k] = takePath;
                }
            }
        }

        return path[n][4] == null ? new int[0] : path[n][4];
    }

    private int findPrevious(int[][] arr, int end, int target) {
        int s = 0;
        int e = end - 1;
        int ans = 0;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid][1] < target) {
                ans = mid + 1;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    private int[] add(int[] arr, int value) {
        int[] result = arr == null
                ? new int[1]
                : Arrays.copyOf(arr, arr.length + 1);

        result[result.length - 1] = value;
        Arrays.sort(result);

        return result;
    }

    private boolean smaller(int[] a, int[] b) {
        if (b == null) return true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return a.length < b.length;
    }
}