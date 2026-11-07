/*
 * Problem: 1882. Process Tasks Using Servers
 * LeetCode: https://leetcode.com/problems/process-tasks-using-servers/
 *
 * Approach: Greedy + Priority Queue (Min Heap)
 *
 * Time Complexity: O((n + m) log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available servers: sorted by weight, then index.
        PriorityQueue<Integer> free = new PriorityQueue<>(
                (a, b) -> {
                    if (servers[a] != servers[b]) {
                        return Integer.compare(servers[a], servers[b]);
                    }
                    return Integer.compare(a, b);
                }
        );

        // Busy servers: sorted by finish time, weight, then index.
        PriorityQueue<long[]> busy = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return Long.compare(a[0], b[0]);
                    }
                    if (a[1] != b[1]) {
                        return Long.compare(a[1], b[1]);
                    }
                    return Long.compare(a[2], b[2]);
                }
        );

        for (int i = 0; i < n; i++) {
            free.offer(i);
        }

        long time = 0;

        for (int i = 0; i < m; i++) {

            time = Math.max(time, i);

            // Release all servers that have finished.
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();
                free.offer((int) server[2]);
            }

            // If no server is free, wait for the earliest one.
            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();
                    free.offer((int) server[2]);
                }
            }

            int serverIndex = free.poll();
            ans[i] = serverIndex;

            long finishTime = time + tasks[i];

            busy.offer(new long[]{
                    finishTime,
                    servers[serverIndex],
                    serverIndex
            });
        }

        return ans;
    }
}