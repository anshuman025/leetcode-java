/*
 * LeetCode 1802 - Maximum Value at a Given Index in a Bounded Array
 * Link: https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 *
 * Approach:
 * Binary Search on Answer + Mathematical Sum
 *
 * For every possible value at the given index, calculate the minimum
 * sum required for the remaining elements while maintaining the
 * difference of at most 1 between adjacent elements.
 *
 * Time Complexity: O(log(maxSum))
 * Space Complexity: O(1)
 */

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long left = index;
        long right = n - index - 1;

        long low = 1;
        long high = maxSum;
        long ans = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long total = mid;
            total += sumSide(mid, left);
            total += sumSide(mid, right);

            if (total <= maxSum) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    private long sumSide(long peak, long count) {
        if (peak - 1 >= count) {
            long first = peak - count;
            return (peak - 1 + first) * count / 2;
        }

        long decreasing = peak - 1;
        long ones = count - decreasing;

        return decreasing * (decreasing + 1) / 2 + ones;
    }
}