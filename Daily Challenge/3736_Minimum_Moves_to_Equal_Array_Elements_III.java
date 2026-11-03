/*
 * Problem: 3736. Minimum Moves to Equal Array Elements III
 * LeetCode: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/
 *
 * Approach: Greedy + Mathematics
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minMoves(int[] nums) {

        int max = nums[0];
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        return max * nums.length - sum;
    }
}