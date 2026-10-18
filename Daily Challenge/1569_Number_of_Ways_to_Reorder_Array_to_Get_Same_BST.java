/*
 * LeetCode 1569 - Number of Ways to Reorder Array to Get Same BST
 *
 * Difficulty: Hard
 * Topics: Binary Search Tree, Recursion, Combinatorics
 *
 * Problem:
 * Given a permutation of integers, count the reorderings that
 * produce the same Binary Search Tree as the original array.
 *
 * The original ordering is included in the count, so subtract
 * one before returning the answer.
 *
 * Return the result modulo 10^9 + 7.
 *
 * LeetCode:
 * https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 *
 * Approach:
 * 1. Treat the first element as the BST root.
 * 2. Divide the remaining elements into left and right subtrees.
 * 3. Recursively count valid reorderings for each subtree.
 * 4. Interleave the left and right subtree sequences using
 *    combinations: C(leftSize + rightSize, leftSize).
 * 5. Subtract one to exclude the original ordering.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        combinations = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;

            for (int j = 1; j < i; j++) {
                combinations[i][j] =
                        (combinations[i - 1][j - 1]
                                + combinations[i - 1][j]) % MOD;
            }
        }

        List<Integer> values = new ArrayList<>();
        for (int num : nums) {
            values.add(num);
        }

        return (int) ((countWays(values) - 1 + MOD) % MOD);
    }

    private long countWays(List<Integer> nums) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        long interleavings =
                combinations[left.size() + right.size()][left.size()];

        return (((interleavings * leftWays) % MOD) * rightWays) % MOD;
    }
}
