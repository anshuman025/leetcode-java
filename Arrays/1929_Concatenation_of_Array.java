/*
 * LeetCode 1929 - Concatenation of Array
 * Problem Link: https://leetcode.com/problems/concatenation-of-array/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    // ----------------------------
    // Approach 1: Two Assignments (Preferred)
    // Time: O(n)
    // Space: O(n)
    // ----------------------------
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }

    /*
    // ----------------------------
    // Approach 2: Modulo
    // Time: O(n)
    // Space: O(n)
    // ----------------------------
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            ans[i] = nums[i % n];
        }

        return ans;
    }
    */
}