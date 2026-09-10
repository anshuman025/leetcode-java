/*
 * LeetCode 436 - Find Right Interval
 * Link: https://leetcode.com/problems/find-right-interval/
 *
 * ----------------------------------------------------
 * Approach 1: Brute Force
 * ----------------------------------------------------
 * For every interval, check every other interval.
 *
 * A right interval must have:
 *
 *      start >= current interval's end
 *
 * Among all valid intervals, choose the one
 * with the smallest start.
 *
 * If no valid interval exists, return -1.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * (O(n) for the output array)
 *
 *
 * ----------------------------------------------------
 * Approach 2: Sorting + Binary Search
 * ----------------------------------------------------
 * Store each interval's start together with its
 * original index, then sort by start.
 *
 * For every interval's end, use Binary Search to
 * find the smallest start that is >= the end.
 *
 * [start, original index]
 *
 * The original index is stored because sorting changes
 * the positions of the intervals.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */


/*
 * ------------------------------------------------
 * Approach 1: Brute Force
 * ------------------------------------------------
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


        /*
         * ------------------------------------------------
         * Approach 2: Sorting + Binary Search
         * ------------------------------------------------
         */

        int[][] S = new int[n][2];

        // Store [start, original index]
        for (int i = 0; i < n; i++) {
            S[i][0] = intervals[i][0];
            S[i][1] = i;
        }

        // Sort by start value
        Arrays.sort(S, (a, b) -> Integer.compare(a[0], b[0]));

        // Binary Search for each interval's end
        for (int i = 0; i < n; i++) {

            int target = intervals[i][1];

            int s = 0;
            int e = n - 1;
            int index = -1;

            while (s <= e) {

                int mid = s + (e - s) / 2;

                if (S[mid][0] >= target) {
                    index = S[mid][1];
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }

            ans[i] = index;
        }

        return ans;
    }
}