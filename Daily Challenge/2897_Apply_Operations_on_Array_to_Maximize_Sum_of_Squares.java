/*
 * LeetCode 2897 - Apply Operations on Array to Maximize Sum of Squares
 *
 * Difficulty: Hard
 * Topics: Greedy, Bit Manipulation
 *
 * Problem:
 * Given an integer array nums and an integer k, perform operations
 * using bitwise AND and OR to redistribute set bits across the array.
 * Select k elements from the resulting array to maximize their
 * sum of squares. Return the answer modulo 10^9 + 7.
 *
 * LeetCode:
 * https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
 *
 * Approach:
 * 1. Count the occurrences of every set bit across all elements.
 * 2. Construct k numbers greedily using the available bits.
 * 3. Use each bit occurrence at most once.
 * 4. Calculate the square of each constructed number.
 * 5. Add the squares modulo 10^9 + 7.
 *
 * Time Complexity: O((n + k) * 31)
 * Space Complexity: O(1)
 */

import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[31];
        long mod = 1_000_000_007L;

        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    num |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            ans = (ans + num * num) % mod;
        }

        return (int) ans;
    }
}