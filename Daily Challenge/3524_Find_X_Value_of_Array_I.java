/*
 * LeetCode 3524 - Find X Value of Array I
 * Link: https://leetcode.com/problems/find-x-value-of-array-i/
 *
 * Approach 1: Brute Force
 * Every possible remaining array is a contiguous subarray.
 * Check every subarray and calculate its product % k.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(k)
 *
 * Approach 2: Dynamic Programming on Remainders
 * dp[mod] stores the number of subarrays ending at the previous
 * position whose product has remainder 'mod'.
 *
 * For every new number:
 * 1. Start a new subarray with that number.
 * 2. Extend every previous subarray.
 * 3. Calculate the new remainder using:
 *    (oldRemainder * currentRemainder) % k
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(k)
 */

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int r = num % k;
            long[] next = new long[k];

            // Start a new subarray
            next[r]++;

            // Extend previous subarrays
            for (int mod = 0; mod < k; mod++) {
                if (dp[mod] > 0) {
                    int newMod = (mod * r) % k;
                    next[newMod] += dp[mod];
                }
            }

            // Add all subarrays ending at this position
            for (int mod = 0; mod < k; mod++) {
                result[mod] += next[mod];
            }

            dp = next;
        }

        return result;
    }
}