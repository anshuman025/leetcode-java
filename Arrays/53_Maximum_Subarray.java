/*
 * LeetCode 53 - Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
 * Approach: Kadane's Algorithm
 *
 * At every element:
 * - Continue the current subarray, or
 * - Start a new subarray from the current element.
 *
 * sum = current best subarray sum
 * max = overall best sum found so far
 *
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum = Math.max(nums[i], sum + nums[i]);

            max = Math.max(max, sum);
        }

        return max;
    }
}