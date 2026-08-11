/*
 * LeetCode 53 - Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
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

        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            sum = Math.max(nums[i], sum + nums[i]);

            max = Math.max(max, sum);
        }

        return max;
    }
}