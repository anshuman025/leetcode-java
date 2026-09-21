/*
 * LeetCode 3524 - Find X Value of Array I
 * Link: https://leetcode.com/problems/find-x-value-of-array-i/
 *
 * Approach: Brute Force
 * Every possible remaining array is a contiguous subarray.
 * We check every possible subarray, calculate its product % k,
 * and count how many times each remainder occurs.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(k)
 */

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];

        for (int i = 0; i < nums.length; i++) {
            long product = 1;

            for (int j = i; j < nums.length; j++) {
                product = (product * nums[j]) % k;
                result[(int) product]++;
            }
        }

        return result;
    }
}