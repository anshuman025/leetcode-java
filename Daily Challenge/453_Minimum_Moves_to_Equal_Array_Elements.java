/*
 * Problem: 453. Minimum Moves to Equal Array Elements
 * LeetCode: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 *
 * Approach: Mathematical / Greedy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long sum = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        return (int) (sum - (long) nums.length * min);
    }
}b