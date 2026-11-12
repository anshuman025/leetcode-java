/*
 * Problem: 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 * LeetCode: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
 *
 * Approach: Single Pass
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int increasing = 1;
        int decreasing = 1;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                increasing++;
                decreasing = 1;
            }
            else if (nums[i] < nums[i - 1]) {
                decreasing++;
                increasing = 1;
            }
            else {
                increasing = 1;
                decreasing = 1;
            }

            maxLength = Math.max(maxLength,
                    Math.max(increasing, decreasing));
        }

        return maxLength;
    }
}