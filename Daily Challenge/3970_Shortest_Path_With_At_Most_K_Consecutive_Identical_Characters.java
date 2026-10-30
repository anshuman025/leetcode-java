import java.util.*;

/*
 * LeetCode 3970: Shortest Path With At Most K Consecutive Identical Characters
 * Problem Link: https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/
 *
 * Approach: Dijkstra's Algorithm
 *
 * 1. Build an adjacency list for the directed weighted graph.
 * 2. Maintain distance[node][count], where count represents
 *    consecutive identical characters at the end of the path.
 * 3. Use a PriorityQueue to process the minimum-cost state first.
 * 4. If the next node has the same label, increment the count.
 * 5. Otherwise, reset the count to 1.
 * 6. Ignore transitions where the count exceeds k.
 * 7. Return the minimum cost when the destination is reached.
 *
 * Time Complexity: O((n + m*k) * log(n*k))
 * Space Complexity: O(n*k + m)
 */

class Solution {

    static class State {
        int node;
        int count;
        long cost;

        State(int node, int count, long cost) {
            this.node = node;
            this.count = count;
            this.cost = cost;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.cost, b.cost)
        );

        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {

            State current = pq.poll();

            int u = current.node;
            int count = current.count;
            long cost = current.cost;

            if (cost != dist[u][count]) {
                continue;
            }

            if (u == n - 1) {
                return (int) cost;
            }

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int weight = edge[1];

                int nextCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                if (nextCount > k) {
                    continue;
                }

                long newCost = cost + weight;

                if (newCost < dist[v][nextCount]) {

                    dist[v][nextCount] = newCost;

                    pq.offer(new State(v, nextCount, newCost));
                }
            }
        }

        return -1;
    }
}
