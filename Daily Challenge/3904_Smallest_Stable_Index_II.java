/*
 * LeetCode 3904 - Smallest Stable Index II
 * Link: https://leetcode.com/problems/smallest-stable-index-ii/
 *
 * Approach: Optimized using Suffix Minimum
 *
 * For every index i:
 * - Find the maximum from index 0 to i.
 * - Find the minimum from index i to the end.
 * - If max - min <= k, return i.
 *
 * To avoid repeatedly finding the minimum from i to the end,
 * we pre-calculate the minimum value for every suffix.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        // Store the minimum value from each index to the end
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Track the maximum from index 0 to i
        int max = nums[0];

        for (int i = 0; i < n; i++) {

            max = Math.max(max, nums[i]);

            if (max - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}