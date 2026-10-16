/*
 * LeetCode 2916 - Subarrays Distinct Element Sum of Squares II
 *
 * Difficulty: Hard
 * Topics: Array, Segment Tree, Lazy Propagation
 *
 * Problem:
 * Calculate the sum of squared distinct-element counts across
 * all non-empty subarrays of nums.
 *
 * Return the answer modulo 10^9 + 7.
 *
 * LeetCode:
 * https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/
 *
 * Approach:
 * 1. Process the array from left to right.
 * 2. Maintain distinct counts for subarrays ending at each position.
 * 3. When a value appears again, update only the subarrays
 *    starting after its previous occurrence.
 * 4. Use a lazy segment tree to update ranges and query the
 *    sum of squared distinct counts.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] sumSquares;
    private long[] lazy;
    private int size;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        size = n;
        sum = new long[4 * n];
        sumSquares = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int previous = last[nums[i]];
            last[nums[i]] = i + 1;

            update(1, 0, n - 1, previous, i, 1);

            ans = (int) ((ans + sumSquares[1]) % MOD);
        }

        return ans;
    }

    private void update(int node, int left, int right,
                        int ql, int qr, long value) {
        if (ql > right || qr < left) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, value);
            return;
        }

        pushDown(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr, value);
        update(node * 2 + 1, mid + 1, right, ql, qr, value);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        sumSquares[node] =
                (sumSquares[node * 2] + sumSquares[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int left, int right, long value) {
        long length = right - left + 1L;

        long increase = (2 * value % MOD * sum[node]) % MOD;
        long squareIncrease = (value * value % MOD * length) % MOD;

        sumSquares[node] =
                (sumSquares[node] + increase + squareIncrease) % MOD;

        sum[node] = (sum[node] + value * length) % MOD;

        lazy[node] = (lazy[node] + value) % MOD;
    }

    private void pushDown(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }
}