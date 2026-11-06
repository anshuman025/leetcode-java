/*
 * Problem: 2747. Count Zero Request Servers
 * LeetCode: https://leetcode.com/problems/count-zero-request-servers/
 *
 * Approach: Sorting + Sliding Window + Hashing
 *
 * Time Complexity: O(L log L + Q log Q)
 * Space Complexity: O(n + Q)
 */

import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int q = queries.length;

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        Integer[] indices = new Integer[q];

        for (int i = 0; i < q; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) ->
                Integer.compare(queries[a], queries[b])
        );

        int[] result = new int[q];
        int[] frequency = new int[n + 1];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int index : indices) {

            int start = queries[index] - x;
            int end = queries[index];

            while (right < logs.length && logs[right][1] <= end) {
                int server = logs[right][0];

                if (frequency[server] == 0) {
                    activeServers++;
                }

                frequency[server]++;
                right++;
            }

            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];

                frequency[server]--;

                if (frequency[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            result[index] = n - activeServers;
        }

        return result;
    }
}