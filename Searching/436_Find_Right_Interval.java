/*
 * LeetCode 436 - Find Right Interval
 * Link: https://leetcode.com/problems/find-right-interval/
 *
 * Approach: Brute Force
 *
 * For every interval, check every other interval.
 * A right interval must have:
 *
 *      start >= current interval's end
 *
 * Among all valid intervals, choose the one
 * with the smallest start.
 *
 * If no valid interval is found, return -1.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * (O(n) for the output array)
 */

class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int e = intervals[i][1];

            int bestS = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < n; j++) {

                int s = intervals[j][0];

                if (s >= e && s < bestS) {
                    bestS = s;
                    index = j;
                }
            }

            ans[i] = index;
        }

        return ans;
    }
}