/*
 * Problem: 1606. Find Servers That Handled Most Number of Requests
 * Link: https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
 *
 * Approach: TreeSet + Priority Queue
 *
 * Time Complexity: O((n + k) log k)
 * Space Complexity: O(k)
 */

import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int n = arrival.length;

        TreeSet<Integer> free = new TreeSet<>();

        PriorityQueue<long[]> busy = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < n; i++) {

            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                long[] server = busy.poll();
                free.add((int) server[1]);
            }

            if (free.isEmpty()) {
                continue;
            }

            int preferred = i % k;

            Integer server = free.ceiling(preferred);

            if (server == null) {
                server = free.first();
            }

            free.remove(server);
            count[server]++;

            long finishTime = (long) arrival[i] + load[i];

            busy.offer(new long[]{finishTime, server});
        }

        int maxRequests = 0;

        for (int requests : count) {
            maxRequests = Math.max(maxRequests, requests);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}