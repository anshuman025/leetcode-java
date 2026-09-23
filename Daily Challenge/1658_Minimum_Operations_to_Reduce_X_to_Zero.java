/*
 * LeetCode 1658 - Minimum Operations to Reduce X to Zero
 * Link: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * Approach:
 * Instead of removing elements from both ends to make their sum x,
 * find the longest contiguous subarray whose sum is total - x.
 *
 * Since all elements are positive, Sliding Window can be used.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int left = 0;
        long sum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == -1 ? -1 : n - maxLength;
    }
}