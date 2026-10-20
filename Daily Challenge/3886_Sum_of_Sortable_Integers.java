/*
 * LeetCode 3886: Sum of Sortable Integers
 * Problem: https://leetcode.com/problems/sum-of-sortable-integers/
 *
 * Approach:
 * 1. Precompute prefix maximums, suffix minimums, and prefix descent counts.
 * 2. Enumerate divisors of n.
 * 3. For each divisor k, check whether every block of length k:
 *    - Can be sorted by a cyclic rotation.
 *    - Can join the other blocks to form a globally sorted array.
 * 4. Add every valid k to the answer.
 *
 * Time Complexity: O(n * number of divisors of n)
 * Space Complexity: O(n)
 */

class Solution {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        int[] suffMin = new int[n + 1];
        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        // Count descending adjacent pairs in each prefix.
        int[] prefDrop = new int[n];

        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1]
                    + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int answer = 0;

        // Enumerate divisors of n.
        for (int k = 1; k <= n / k; k++) {
            if (n % k == 0) {

                if (isSortable(nums, prefMax, suffMin, prefDrop, k)) {
                    answer += k;
                }

                int other = n / k;

                if (other != k &&
                        isSortable(nums, prefMax, suffMin, prefDrop, other)) {
                    answer += other;
                }
            }
        }

        return answer;
    }

    private boolean isSortable(
            int[] nums,
            int[] prefMax,
            int[] suffMin,
            int[] prefDrop,
            int k) {

        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;

            // Count descents inside the current block.
            int drops = prefDrop[end] - prefDrop[start];

            // Include the circular boundary of the block.
            if (nums[end] > nums[start]) {
                drops++;
            }

            // More than one circular descent means it cannot
            // be sorted using cyclic rotations.
            if (drops > 1) {
                return false;
            }

            // Ensure this block can follow all preceding blocks
            // in a globally non-decreasing array.
            if (prefMax[start] > suffMin[start]) {
                return false;
            }
        }

        return true;
    }
}