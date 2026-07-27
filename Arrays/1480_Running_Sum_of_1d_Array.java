/*
 * LeetCode 1480 - Running Sum of 1d Array
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    // ----------------------------
    // Approach 1: Extra Array
    // Time: O(n)
    // Space: O(n)
    // ----------------------------

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + result[i - 1];
        }

        return result;
    }

    /*
    // ----------------------------
    // Approach 2: In-Place (Optimized)
    // Time: O(n)
    // Space: O(1)
    // ----------------------------

    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
    */
}