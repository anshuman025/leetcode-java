import java.util.*;

/*
 * LeetCode 3841: Palindromic Path Queries in a Tree
 * Problem Link: https://leetcode.com/problems/palindromic-path-queries-in-a-tree/
 *
 * Approach:
 * 1. Use Euler Tour to assign entry and exit times to each node.
 * 2. Use Binary Lifting to find the Lowest Common Ancestor (LCA).
 * 3. Represent character frequencies using a 26-bit parity mask.
 * 4. Use a Fenwick Tree with XOR range updates to handle character updates.
 * 5. Calculate the parity mask of each queried path using root-prefix masks.
 * 6. A path can form a palindrome if at most one character has an odd frequency.
 *
 * Time Complexity: O((n + q) * log n)
 * Space Complexity: O(n * log n)
 */

class Solution {
    private int n;
    private int log;
    private List<Integer>[] graph;

    private int[] tin;
    private int[] tout;
    private int[] depth;
    private int[] basePrefix;
    private int[][] up;

    private char[] chars;
    private Fenwick fenwick;
    private int timer;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        this.log = 1;

        while ((1 << log) <= n) {
            log++;
        }

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        basePrefix = new int[n];
        up = new int[log][n];

        chars = s.toCharArray();
        timer = 0;

        buildEulerTour();

        fenwick = new Fenwick(n);

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int node = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);

                if (chars[node] == newChar) {
                    continue;
                }

                int oldMask = 1 << (chars[node] - 'a');
                int newMask = 1 << (newChar - 'a');
                int delta = oldMask ^ newMask;

                fenwick.rangeXor(tin[node], tout[node], delta);

                chars[node] = newChar;
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int maskU = basePrefix[u] ^ fenwick.query(tin[u]);
                int maskV = basePrefix[v] ^ fenwick.query(tin[v]);
                int ancestorMask = 1 << (chars[ancestor] - 'a');

                int pathMask = maskU ^ maskV ^ ancestorMask;

                answer.add(Integer.bitCount(pathMask) <= 1);
            }
        }

        return answer;
    }

    private void buildEulerTour() {
        int[] stackNode = new int[2 * n + 5];
        int[] stackParent = new int[2 * n + 5];
        boolean[] stackExit = new boolean[2 * n + 5];

        int top = 0;

        stackNode[top] = 0;
        stackParent[top] = 0;
        stackExit[top] = false;
        top++;

        while (top > 0) {
            top--;

            int node = stackNode[top];
            int parent = stackParent[top];
            boolean exiting = stackExit[top];

            if (exiting) {
                tout[node] = timer;
                continue;
            }

            tin[node] = ++timer;

            depth[node] = (node == 0) ? 0 : depth[parent] + 1;

            up[0][node] = parent;

            for (int j = 1; j < log; j++) {
                up[j][node] = up[j - 1][up[j - 1][node]];
            }

            int currentMask = 1 << (chars[node] - 'a');

            basePrefix[node] = (node == 0)
                    ? currentMask
                    : basePrefix[parent] ^ currentMask;

            stackNode[top] = node;
            stackParent[top] = parent;
            stackExit[top] = true;
            top++;

            for (int i = graph[node].size() - 1; i >= 0; i--) {
                int next = graph[node].get(i);

                if (next == parent) {
                    continue;
                }

                stackNode[top] = next;
                stackParent[top] = node;
                stackExit[top] = false;
                top++;
            }
        }
    }

    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }

    private int lca(int u, int v) {
        if (isAncestor(u, v)) {
            return u;
        }

        if (isAncestor(v, u)) {
            return v;
        }

        for (int j = log - 1; j >= 0; j--) {
            if (!isAncestor(up[j][u], v)) {
                u = up[j][u];
            }
        }

        return up[0][u];
    }

    private static class Fenwick {
        private final int[] tree;
        private final int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        private void update(int index, int value) {
            while (index <= n) {
                tree[index] ^= value;
                index += index & -index;
            }
        }

        void rangeXor(int left, int right, int value) {
            update(left, value);
            update(right + 1, value);
        }

        int query(int index) {
            int result = 0;

            while (index > 0) {
                result ^= tree[index];
                index -= index & -index;
            }

            return result;
        }
    }
}