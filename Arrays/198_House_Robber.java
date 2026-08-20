/*
 * LeetCode 198 - House Robber
 *
 * Link:
 * https://leetcode.com/problems/house-robber/
 *
 * Approach:
 *
 * Use Dynamic Programming with two variables.
 *
 * p1 -> best amount from the previous house
 * p2 -> best amount from two houses back
 *
 * For every house:
 *
 * Rob current:
 * nums[i] + p2
 *
 * Skip current:
 * p1
 *
 * Take the maximum of both choices.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Space-optimized Dynamic Programming.
 */

class Solution {
    public int rob(int[] nums) {

        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < nums.length; i++) {

            int current = Math.max(nums[i] + p2, p1);

            p2 = p1;
            p1 = current;
        }

        return p1;
    }
}