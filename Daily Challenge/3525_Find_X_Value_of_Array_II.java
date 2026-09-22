/*
 * LeetCode 3525 - Find X Value of Array II
 * Link: https://leetcode.com/problems/find-x-value-of-array-ii/
 *
 * Approach:
 * Segment Tree + Dynamic Programming on remainders.
 *
 * Each segment stores:
 * 1. Product of all elements modulo k.
 * 2. Number of subarrays ending in that segment for every remainder.
 *
 * For every query:
 * 1. Update nums[index] with the new value.
 * 2. Query the segment from start to n - 1.
 * 3. Return the count of subarrays whose product % k == x.
 *
 * Time Complexity:
 * Build: O(n * k)
 * Update: O(k * log n)
 * Query: O(k * log n)
 *
 * Space Complexity: O(n * k)
 */

class Solution {
    static class Node {
        int product;
        long[] count;

        Node(int k) {
            count = new long[k];
        }
    }

    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, index, value);

            Node result = query(1, 0, n - 1, start, n - 1);

            ans[q] = (int) result.count[x];
        }

        return ans;
    }

    private void build(int node, int left, int right, int[] nums) {
        if (left == right) {
            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].count[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int left, int right, int index, int value) {
        if (left == right) {
            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].product = rem;
            tree[node].count[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node query(int node, int left, int right, int ql, int qr) {
        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        Node leftNode = query(node * 2, left, mid, ql, qr);
        Node rightNode = query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(leftNode, rightNode);
    }

    private Node merge(Node left, Node right) {
        Node result = new Node(k);

        result.product = (left.product * right.product) % k;

        for (int i = 0; i < k; i++) {
            result.count[i] += left.count[i];
        }

        for (int i = 0; i < k; i++) {
            if (right.count[i] == 0) {
                continue;
            }

            int newRem = (left.product * i) % k;
            result.count[newRem] += right.count[i];
        }

        return result;
    }
}